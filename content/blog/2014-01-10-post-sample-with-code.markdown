---
layout: post
title: "Post sample with code"
date: "2014-01-10 15:00"
author: SysGears
categories: [grain, groovy]
comments: true                    # disables/enables comments section for the post
published: true                   # defines whether to render the post in 'generate' mode
sharing: true                     # (optional) disables/enables sharing options for the post, 'true' is by default
asides: [ asides/recent_posts.html, asides/github.html,
  asides/about.html]              # (optional) asides to include into the post page, all asides are included by default
---

<!--more-->

##Example with line numbers:

####Code:

&#096;&#096;&#096;groovy HelloWorld.groovy<br>
println "Hello, world!"<br>
&#096;&#096;&#096;

####Result:

```groovy HelloWorld.groovy
println "Hello, world!"
```

##Example without line numbers:

####Code:

&#096;&#096;&#096;groovy**:nl** HelloWorld.groovy<br>
println "Hello, world!"<br>
&#096;&#096;&#096;

####Result:

```groovy:nl HelloWorld.groovy
println "Hello, world!"
```