package com.sysgears.octopress.taglibs

import com.sun.xml.internal.ws.util.StringUtils
import com.sysgears.grain.taglib.GrainTagLib

class OctopressTagLib {

    /**
     * Grain taglib reference.
     */
    private GrainTagLib taglib

    public OctopressTagLib(GrainTagLib taglib) {
        this.taglib = taglib
    }

    /**
     * Renders a quote block which contains the quote text, author and source.
     *
     * @attr content REQUIRED quote content
     * @attr author the quote author
     * @attr sourceTitle the title of the quote source
     * @attr sourceLink the link to the quote source
     */
    def blockquote = { Map attrs ->
        // validates the tag attributes
        if (!attrs.content) throw new IllegalArgumentException('Tag [blockquote] is missing required attribute [content]')

        taglib.include('/tags/blockquote.html', [quote: attrs])
    }

    /**
     * Renders a jsFiddle iframe code.
     *
     * @attr shorttag REQUIRED jsFiddle shortcode
     * @attr tabs jsFiddle tabs to show, 'js,resources,html,css,result' by default
     * @attr skin jsFiddle skin name, 'light' by default
     * @attr width iframe width, 100% by default
     * @attr height iframe height, '300px' by default
     */
    def jsfiddle = { Map attrs ->
        // validates the tag attributes
        if (!attrs.shorttag) throw new IllegalArgumentException('Tag [jsfiddle] is missing required attribute [shorttag]')

        // sets default values
        attrs.tabs = attrs.tabs ?: 'js,resources,html,css,result'
        attrs.skin = attrs.skin ?: 'light'
        attrs.width = attrs.width ?: '100%'
        attrs.height = attrs.height ?: '300px'

        taglib.include('/tags/jsfiddle.html', [jsfiddle: attrs])
    }

    /**
     * Renders a content and duplicates the quote withing the content with a different formatting style.
     * <br />
     * The quote must be surrounded by '{/' '/}' tags, for instance: 'Lorem ipsum {/dolor/} sit amet'.
     *
     * @attr content REQUIRED content that contains a quote
     * @attr align quote position, can be either 'right' or 'left', 'right' is by default
     */
    def pullquote = { Map attrs ->
        // validates the tag attributes
        if (!attrs.content) throw new IllegalArgumentException('Tag [pullquote] is missing required attribute [content]')

        String content = attrs.content
        String align = attrs.align ?: 'right'

        // finds quote which is surrounded by '{/' '/}' tags
        String quote = content.find(/\{\/(.*)\/\}/) { match, quote -> quote }
        // removes '{/' '/}' tags from the content
        content = content.replace('{/', '').replace('/}', '')

        taglib.include('/tags/pullquote.html', [textblock: [content: content, quote: quote, align: align]])
    }

    /**
     * Embeds a gist into the page.
     *
     * @attr id REQUIRED unique gist identifier
     */
    def gist = { Map attrs ->
        // validates the tag attributes
        if (!attrs.id) throw new IllegalArgumentException('Tag [gist] is missing required attribute [id]')

        taglib.include('/tags/gist.html', [gist: attrs])
    }

    /**
     * Generates html tag for an image.
     *
     * @attr src REQUIRED image location
     * @attr height image height
     * @attr width image width
     * @attr alt alternate text for the image
     */
    def img = { Map attrs ->
        // validates the tag attributes
        if (!attrs.src) throw new IllegalArgumentException('Tag [img] is missing required attribute [src]')

        attrs.src = attrs.src.startsWith('/') ? taglib.r(attrs.src) : attrs.src
        taglib.include('/tags/img.html', [img: attrs])
    }

    /**
     * Prevents groovy code parsing.
     *
     * @attr text REQUIRED groovy code which should not be be parsed.
     */
    def raw = { Map attrs ->
        if (!attrs.text) throw new IllegalArgumentException('Tag [raw] is missing required attribute [text]')

        attrs.text
    }

    /**
     * Embeds a video into the page.
     *
     * @attr urls REQUIRED links to the videos
     * @attr poster link to a poster
     * @attr wight video wight
     * @attr height video height
     */
    def video = { Map attrs ->

        // validates the tag attributes
        if (!attrs.urls || !(attrs.urls instanceof List) || attrs.urls.isEmpty()) {
            throw new IllegalArgumentException('Tag [video] is missing required attribute [urls]')
        }

        def types = ['mp4': 'video/mp4',
                'ogv': 'video/ogg',
                'webm': 'video/webm'] // supported video types

        def videoSources = []

        attrs.urls.each {
            def type = types."${it.find(/[^\.]+$/)}"
            if (type) {
                videoSources << [url: it, type: type]
            }
        }

        if (videoSources.isEmpty()) {
            throw new IllegalArgumentException("Tag [video] does not support file formats of any of the provided video sources")
        }

        attrs << [sources: videoSources]

        taglib.include('/tags/video.html', [video: attrs])
    }

    /**
     * Converts title by applying Title Case capitalizing convention (capitalizes all principal words).
     *
     * @attr title REQUIRED the title to convert
     */
    def titleCase = { Map attrs ->
        if (!attrs.title) throw new IllegalArgumentException('Tag [titleCase] is missing required attribute [title]')

        def nonPrincipalWords = ['a', 'an', 'and', 'as', 'at', 'but', 'by', 'en', 'for', 'if', 'in',
                'of', 'on', 'or', 'the', 'to', 'v', 'v.', 'via', 'vs', 'vs.']

        attrs.title.split(' ').inject(new StringBuilder()) {result, word ->
            word in nonPrincipalWords ? result.append(word) : result.append(StringUtils.capitalize(word))
            result.append(' ')
        } .toString().trim()
    }

    /**
     * Converts a date to XML date time format: 2013-12-31T12:49:00+07:00
     *
     * @attr date REQUIRED the date to convert
     */
    def xmlDateTime = { Map attrs ->
        if (!attrs.date) throw new IllegalArgumentException('Tag [xmlDateTime] is missing required attribute [date]')

        def tz = String.format('%tz', attrs.date)

        String.format("%tFT%<tT${tz.substring(0, 3)}:${tz.substring(3)}", attrs.date)
    }
}
