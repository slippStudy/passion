---
layout: post
title: "로컬 개발환경 설정"
description: ""
category: milestones zero
tags: [개발환경, lombok, eclipse, mvn]
---
{% include JB/setup %}

- ### Issue 
[#22](https://github.com/slippStudy/passion/issues/22)

- ### Requirements

로컬 개발 환경을 설정하기 위해서는 아래와 같은 사항은 이미 설치되고 숙지 되어 있다라고 가정한다. 

- [jdk 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html)
- [maven](http://maven.apache.org/download.cgi)
- [tomcat 7](http://tomcat.apache.org/download-70.cgi)
- [eclipse](https://www.eclipse.org/downloads/packages/eclipse-ide-java-ee-developers/keplersr2)

- ## Download source in github 

{% highlight bash %}
$ git clone  https://github.com/slippStudy/passion.git
$ cd passion
$ git status 

# On branch master
nothing to commit, working directory clean

{% endhighlight %}

- ## Install lombok 

passion 은 [lombok](http://projectlombok.org/) 을 사용한다. lombok 에 대한 자세한 사항은 관련 사이트를 참고 바란다.

-- ### Download Lombok [여기서 다운로드](http://projectlombok.org/download.html)

다운로드 후 해당 폴더에서 jar 를 실행 시켜 IDE 에서 lombok 사용을 활성화 시켜준다. 
{% highlight bash %}$ java -jar lombok.jar {% endhighlight %}

<img src="{{ BASE_PATH }}/assets/lombok_install.png" width = "100%" alt="{{HOME_PATH}}lombok과 프로젝트의 연결 " title="lombok과 프로젝트의 연결 ">

lombok 과 eclipse 가 잘 연결 되었다면 이 후 eclipse 로 web project 를 import 한 후 lombok관련 class 를 찾지 못해 발생하는 compile 오류를 보지 않을 것이다.

- ## Generate eclipse project
{% highlight bash %}$ mvn eclipse:clean eclipse:eclipse {% endhighlight %}

- ## Import project 

- ## run project


- ## before push
{% highlight bash %}$ mvn test {% endhighlight %}
