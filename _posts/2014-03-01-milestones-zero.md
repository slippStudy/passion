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

로컬 개발 환경을 설정하기 위해서는 아래와 같은 사항은 이미 설치되고 숙지 되어 있다라고 가정한다. 

- [jdk 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html)
- [maven](http://maven.apache.org/download.cgi)
- [tomcat 7](http://tomcat.apache.org/download-70.cgi)
- [eclipse](https://www.eclipse.org/downloads/packages/eclipse-ide-java-ee-developers/keplersr2)

### Download source in github 
{% highlight bash %}$ git clone  https://github.com/slippStudy/passion.git
$ cd passion
$ git status {% endhighlight %}


### Install lombok 
[lombok](http://projectlombok.org/)
{% highlight bash %}$ java -jar lombok.jar {% endhighlight %}

### Generate eclipse project
{% highlight bash %}$ mvn eclipse:clean eclipse:eclipse {% endhighlight %}

### Import project 

### run project


### before push
{% highlight bash %}$ mvn test {% endhighlight %}
