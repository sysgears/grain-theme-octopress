---
layout: post
title: "Blockqoute tag"
date: "2014-01-08 13:00"
author: SysGears
categories: [grain, groovy]
comments: true
published: true
---

<!--more-->

####Code:

```jsp
<%= blockquote content:
'''Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor
incididunt ut labore et dolore magna aliqua.'''
%>
```

####Result:

<%= blockquote content:
'''Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor
incididunt ut labore et dolore magna aliqua.'''
%>

##Quote from a printed work

####Code:

```jsp
<%= blockquote author: 'John Doe', sourceTitle: 'Lorem ipsum', content:
'''Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor
incididunt ut labore et dolore magna aliqua.'''
%>
```

####Result:

<%= blockquote author: 'John Doe', sourceTitle: 'Lorem ipsum', content:
'''Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor
incididunt ut labore et dolore magna aliqua.'''
%>

##Quote from Twitter

####Code:

```jsp
<%= blockquote author: 'John Doe', sourceLink: 'http://example.com', content:
'''Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor
incididunt ut labore et dolore magna aliqua.'''
%>
```

####Result:

<%= blockquote author: 'John Doe', sourceLink: 'http://example.com', content:
'''Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor
incididunt ut labore et dolore magna aliqua.'''
%>

##Quote from a post

####Code:

```jsp
<%= blockquote author: 'John Doe', sourceTitle: 'Lorem ipsum', sourceLink: 'http://example.com', content:
'''Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor
incididunt ut labore et dolore magna aliqua.'''
%>
```

####Result:

<%= blockquote author: 'John Doe', sourceTitle: 'Lorem ipsum', sourceLink: 'http://example.com', content:
'''Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor
incididunt ut labore et dolore magna aliqua.'''
%>