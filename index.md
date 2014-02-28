---
layout: page
title: Sustainable Life, Programming, Programmer
tagline: java study slipp
---
{% include JB/setup %}

## Update Author Attributes

## Posts

<ul class="posts">
  {% for post in site.posts %}
    <li><span>{{ post.date | date_to_string }}</span> &raquo; <a href="{{ BASE_PATH }}{{ post.url }}">{{ post.title }}</a></li>
  {% endfor %}
</ul>

## To-Do


