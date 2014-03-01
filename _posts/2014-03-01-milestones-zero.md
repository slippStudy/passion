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

### Download source in github 
{% highlight bash %} $ git clone  https://github.com/slippStudy/passion.git
$ cd passion
$ git status {% endhighlight %}


### Install lombok 
{% highlight bash %} $ java -jar lombok.jar {% endhighlight %}

### Generate eclipse project
{% highlight bash %} $ mvn eclipse:clean eclipse:eclipse {% endhighlight %}

### Import project 

### run project


### before push
{% highlight bash %} $ mvn test {% endhighlight %}
