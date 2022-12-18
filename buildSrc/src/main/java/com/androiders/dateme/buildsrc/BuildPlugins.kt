object BuildPlugins {
    const val ANDROID_APPLICATION = "com.android.application"
    const val ANDROID_LIBRARY = "com.android.library"
    const val JETBRAINS_KOTLIN_ANDROID = "org.jetbrains.kotlin.android"
    const val KOTLIN_KAPT = "kotlin-kapt"
    const val KTLINT = "org.jlleitschuh.gradle.ktlint"
    const val DAGGER_HILT_PLUGIN = "dagger.hilt.android.plugin"
    const val VERSIONS = "com.github.ben-manes.versions"

    private const val TOOLS_BUILD_VERSION = "7.1.3"
    const val TOOLS_BUILD_GRADLE =
        "com.android.tools.build:gradle:$TOOLS_BUILD_VERSION"

    private const val KOTLIN_GRADLE = "1.6.10"
    const val KOTLIN_GRADLE_PLUGIN =
        "org.jetbrains.kotlin:kotlin-gradle-plugin:$KOTLIN_GRADLE"

    const val VERSIONS_PLUGIN =
        "com.github.ben-manes:gradle-versions-plugin:${Versions.PLUGIN_DAGGER_HILT}"

    const val DAGGER_HILT =
        "com.google.dagger:hilt-android-gradle-plugin:${Versions.DAGGER_HILT}"
}
