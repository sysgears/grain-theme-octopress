Octopress Grain Theme
=====================

This is a port of Octopress blogging theme for Grain framework.

Features
========

Octopress theme out of the box provides all the necessary features and tools to instantly start blogging,
implement custom pages and organize posts. Moreover, it offers the same site structure as original Octoperess to
ensure simple and painless migration.

The latest version of the theme comes with:

  - integration with social networks: Facebook, Twitter, Google+, GitHub, etc.
  - various content formatting tools to easily customize blog content
  - built-in atom news feed

Commands
--------

The theme ships with a few handy commands that allow to create new pages and posts:

``` sh:nl
./grainw create-page "/portfolio" "Portfolio" # adds 'Portfolio' page to a blog
```

``` sh:nl
./grainw create-post "Post Sample" # adds new post 'Post Sample'
```

Customization
-------------

Theme configuration settings allow to change a blog name, meta information, the number of posts per page,
set sharing options and rearrange sidebar sections.

At this time, the theme ships with the next sidebar modules:

  - **recent_posts** - shows the latest posts
  - **tweets** - shows the most recent tweets
  - **github** - displays links to GitHub repositories
  - **pinboard** and **delicious** - show recent Pinboard and Delicious bookmarks
  - **google_plus**, **facebook**, **twitter** and **instagram** - render links to social networks

Tag Library
-----------

Theme's tag library provides content formatting features similar to Octopress [plugins][plugins].

Currently, the following tags are available to use:

  - **blockquote** - renders a block quote with quote text, author and source
  - **pullquote** - renders a *HTML5 + CSS* pull quote
  - **img** - embeds an image into a page
  - **gist** - downloads and embeds a GitHub gist
  - **video** - embeds a HTML5 video encoded as *mp4*, *ogv* or *webm*

[plugins]: http://octopress.org/docs/plugins/

Contributing
============

Any person or company wanting to contribute to this project should follow
the following rules in order to their contribution being accepted.

Sign your Work
--------------

We require that all contributors "sign-off" on their commits.  This
certifies that the contribution is your original work, or you have rights to
submit it under the same license, or a compatible license.

Any contribution which contains commits that are not Signed-Off will not be
accepted.

To sign off on a commit you simply use the `--signoff` (or `-s`) option when
committing your changes:

    $ git commit -s -m "Adding a new widget driver for cogs."

This will append the following to your commit message:

    Signed-off-by: Your Name <your@email.com>

By doing this you certify the below:

    Developer's Certificate of Origin 1.1

If you wish to add the signoff to the commit message on your every commit
without the need to specify -s or --signoff, rename
.git/hooks/commit-msg.sample to .git/hooks/commit-msg and uncomment the lines:

``` sh
SOB=$(git var GIT_AUTHOR_IDENT | sed -n 's/^\(.*>\).*$/Signed-off-by: \1/p')
grep -qs "^$SOB" "$1" || echo "$SOB" >> "$1"
```

Developer's Certificate of Origin
---------------------------------

To help track the author of a patch as well as the submission chain,
and be clear that the developer has authority to submit a patch for
inclusion into this project please sign off your work.  The sign off
certifies the following:

    Developer's Certificate of Origin 1.1

    By making a contribution to this project, I certify that:

    (a) The contribution was created in whole or in part by me and I
        have the right to submit it under the open source license
        indicated in the file; or

    (b) The contribution is based upon previous work that, to the best
        of my knowledge, is covered under an appropriate open source
        license and I have the right under that license to submit that
        work with modifications, whether created in whole or in part
        by me, under the same open source license (unless I am
        permitted to submit under a different license), as indicated
        in the file; or

    (c) The contribution was provided directly to me by some other
        person who certified (a), (b) or (c) and I have not modified
        it.

    (d) I understand and agree that this project and the contribution
        are public and that a record of the contribution (including all
        personal information I submit with it, including my sign-off) is
        maintained indefinitely and may be redistributed consistent with
        this project or the open source license(s) involved.

    (e) I hereby grant to the project, SysGears, LLC and its successors; 
        and recipients of software distributed by the Project a perpetual,
        worldwide, non-exclusive, no-charge, royalty-free, irrevocable
        copyright license to reproduce, modify, prepare derivative works of,
        publicly display, publicly perform, sublicense, and distribute this
        contribution and such modifications and derivative works consistent
        with this Project, the open source license indicated in the previous
        work or other appropriate open source license specified by the Project
        and approved by the Open Source Initiative(OSI)
        at http://www.opensource.org.

License
=======

Grain Octopress theme is licensed under the terms of the
[MIT License][MIT License].

[MIT License]: https://github.com/sysgears/grain-theme-octopress/blob/master/LICENSE

