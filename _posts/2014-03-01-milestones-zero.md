---
layout: post
title: "로컬 개발환경 설정"
description: ""
category: milestones zero
tags: ["개발환경"]
---
{% include JB/setup %}

[#22](https://github.com/slippStudy/passion/issues/22)

## require environment

## download source in github 
{% highlight bash %} $ git clone  https://github.com/slippStudy/passion.git||$ cd passion||$ git status {% endhighlight %}


## install lombok 
{% highlight bash %} $ java -jar lombok.jar {% endhighlight %}

## generate eclipse project
{% highlight bash %} $ mvn eclipse:clean eclipse:eclipse {% endhighlight %}

## import project 

## run project


## before push
{% highlight bash %} $ mvn test {% endhighlight %}
