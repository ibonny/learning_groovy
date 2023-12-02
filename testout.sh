#!/usr/bin/env groovy
this.class.classLoader.rootLoader.URLs.each{ println it }
