---
layout: post
title: "로컬 개발환경 설정"
description: ""
category: milestones zero
tags: ["개발환경"]
---
{% include JB/setup %}

### Issue 
[#22](https://github.com/slippStudy/passion/issues/22)

### Requirements

Installing Jekyll is easy and straight-forward, but there are a few requirements
you’ll need to make sure your system has before you start.

- [Ruby](http://www.ruby-lang.org/en/downloads/)
- [RubyGems](http://rubygems.org/pages/download)
- Linux, Unix, or Mac OS X

<div class="note info">
  <h5>Running Jekyll on Windows</h5>
  <p>
    While Windows is not officially supported, it is possible to get it running
    on Windows. Special instructions can be found on our
    <a href="../windows/#installation">Windows-specific docs page</a>.
  </p>
</div>

### Download source in github 
{% highlight bash %}$ git clone  https://github.com/slippStudy/passion.git
$ cd passion
$ git status {% endhighlight %}


### Install lombok 
{% highlight bash %}$ java -jar lombok.jar {% endhighlight %}

### Generate eclipse project
{% highlight bash %}$ mvn eclipse:clean eclipse:eclipse {% endhighlight %}

### Import project 

### run project


### before push
{% highlight bash %}$ mvn test {% endhighlight %}
