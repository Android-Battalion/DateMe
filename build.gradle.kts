buildscript {
    dependencies {
        classpath(BuildPlugins.DAGGER_HILT)
        classpath(BuildPlugins.VERSIONS_PLUGIN)
        classpath(BuildPlugins.TOOLS_BUILD_GRADLE)
        classpath(BuildPlugins.KOTLIN_GRADLE_PLUGIN)
    }
}

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(BuildPlugins.ANDROID_APPLICATION) version Versions.PLUGIN_ANDROID apply false
    id(BuildPlugins.ANDROID_LIBRARY) version Versions.PLUGIN_ANDROID apply false
    id(BuildPlugins.JETBRAINS_KOTLIN_ANDROID) version Versions.PLUGIN_JETBRAINS_KOTLIN_ANDROID apply false
    id(BuildPlugins.KTLINT) version Versions.PLUGIN_KTLINT
}

task<Delete>("clean") {
    delete = setOf(rootProject.buildDir)
}
