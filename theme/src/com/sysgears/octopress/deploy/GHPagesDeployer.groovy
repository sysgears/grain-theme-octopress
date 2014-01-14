package com.sysgears.octopress.deploy

import com.sysgears.grain.taglib.Site

/**
 * Provides deploying of the generated site to GitHub Pages service.
 */
class GHPagesDeployer {

    /**
     * Site reference, provides access to site configuration.
     */
    private final Site site

    public GHPagesDeployer(Site site) {
        this.site = site
    }

    /**
     * Deploys generated site.
     */
    def deploy = {
        def cacheDir = site.cache_dir
        def destinationDir = site.destination_dir
        def ghPagesUrl = site.gh_pages_url

        if (!ghPagesUrl) {
            System.err.println('Couldn\'t upload to GitHub Pages, please specify your GitHub repo url first')
            return
        }

        def isUserPage = ghPagesUrl.toString().endsWith('.github.io.git')
        def workingBranch = isUserPage ? 'master' : 'gh-pages'
        def cacheDeployDir = "$cacheDir/gh-deploy"

        def ant = new AntBuilder()
        def ghPagesExists = !isUserPage ? ghPagesBranchExists(ant, ghPagesUrl) : null

        def git = { List args ->
            ant.exec(executable: 'git', dir: cacheDeployDir) {
                args.collect { arg(value: it) }
            }
        }

        ant.sequential {
            ant.delete(dir: cacheDeployDir, failonerror: false)
            ant.mkdir(dir: cacheDeployDir)
            git(['init'])
            if (!isUserPage && !ghPagesExists) {
                git(['remote', 'add', '-f', 'origin', ghPagesUrl])
                git(['checkout', '-b', workingBranch])
            } else {
                git(['remote', 'add', '-t', workingBranch, '-f', 'origin', ghPagesUrl])
                git(['checkout', workingBranch])
                ant.delete(includeEmptyDirs: true) {
                    fileset(dir: cacheDeployDir) {
                        exclude(name: '.git')
                    }
                }
            }
            ant.copy(todir: cacheDeployDir) {
                fileset(dir: destinationDir)
            }
            git(['add', '.'])
            git(['commit', '-m', 'Updated site'])
            git(['push', 'origin', "$workingBranch:$workingBranch"])
            ant.delete(dir: cacheDeployDir)
        }
    }

    /**
     * Determines whether gh-pages branch exists for given repo.
     *
     * @param ant AntBuilder instance
     * @param ghPagesUrl GitHub repo url
     * @return true if branch exists, false otherwise
     */
    private def ghPagesBranchExists(AntBuilder ant, String ghPagesUrl) {
        ant.exec(executable: 'git', outputproperty: 'gitLsOutput') {
            ['ls-remote', '--heads', ghPagesUrl].collect { arg(value: it) }
        }
        ant.project.properties.gitLsOutput.contains('refs/heads/gh-pages')
    }
}
