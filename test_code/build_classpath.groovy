#!/usr/bin/env groovy

import groovy.io.FileType
import groovy.json.JsonOutput
import groovy.json.JsonSlurper

def path = "/workspace/.vscode-remote/data/Machine/settings.json"

File settingsFile = new File(path)

def slurper = new JsonSlurper()

def origJson = slurper.parse(settingsFile)

def list = []

def dir = new File("/home/gitpod/.m2/repository")

dir.eachFileRecurse (FileType.FILES) { file -> 
    list << file
}

list = list.findAll { it.path.endsWith(".jar") }

filenames = list.collect { it.path }

origJson["groovy.classpath"] = filenames

settingsFile.newWriter().withWriter { w ->
    w << JsonOutput.prettyPrint(JsonOutput.toJson(origJson))
}

// settingsFile.text = JsonOutput.prettyPrint(JsonOutput.toJson(origJson))