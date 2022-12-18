plugins {
    id(BuildPlugins.ANDROID_APPLICATION)
    id(BuildPlugins.KOTLIN_KAPT)
    id(BuildPlugins.JETBRAINS_KOTLIN_ANDROID)
    id(BuildPlugins.KTLINT)
    id(BuildPlugins.VERSIONS)
    id(BuildPlugins.DAGGER_HILT_PLUGIN)
}

android {
    compileSdk = ProjectProperties.COMPILE_SDK

    defaultConfig {
        applicationId = ProjectProperties.APPLICATION_ID
        minSdk = ProjectProperties.MIN_SDK
        targetSdk = ProjectProperties.TARGET_SDK
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            isShrinkResources = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    ktlint {
        disabledRules.set(setOf("no-wildcard-imports", "filename"))
    }
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.KOTLIN_COMPILER_VERSION
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

tasks.getByPath("preBuild").dependsOn("ktlintFormat")

dependencies {

    // Core Dependencies
    implementation(Dependencies.AndroidX.CORE_KTX)
    implementation(Dependencies.AndroidX.Compose.COMPOSE_UI)
    implementation(Dependencies.AndroidX.Compose.COMPOSE_MATERIAL)
    implementation(Dependencies.AndroidX.Compose.COMPOSE_PREVIEW_TOOLING)
    implementation(Dependencies.AndroidX.Activity.COMPOSE_ACTIVITY)
    implementation(Dependencies.AndroidX.Lifecycle.LIFECYCLE_RUNTIME)

    // Google Accompanist
    implementation(Dependencies.Accompanist.SYSTEM_UI_CONTROLLER)
    implementation(Dependencies.Accompanist.PAGER)
    // This dependency is used for Horizontal Pager.

    // DataStore Preferences
    implementation(Dependencies.DataStore.PREFERENCES)

    // Splash Screen API
    implementation(Dependencies.SplashScreen.SPLASH_SCREEN_CORE)

    // Navigation Compose
    implementation(Dependencies.Navigation.NAVIGATION_RUNTIME)

    // firebase
    implementation("com.google.firebase:firebase-auth-ktx:21.1.0")

    // Dagger - Hilt
    implementation("com.google.dagger:hilt-android:2.43.2")
    kapt("com.google.dagger:hilt-android-compiler:2.43.2")
    kapt("androidx.hilt:hilt-compiler:1.0.0")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")

    // Testing Dependencies
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.4")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.0")

    testImplementation("org.robolectric:robolectric:4.9")
    testImplementation("androidx.test.espresso:espresso-core:3.5.0")

    testImplementation("androidx.compose.ui:ui-test-junit4:1.3.2")
    debugImplementation("androidx.compose.ui:ui-test-manifest:1.3.2")

    androidTestImplementation(Dependencies.AndroidX.Compose.COMPOSE_JUNIT_UI)
    debugImplementation(Dependencies.AndroidX.Compose.COMPOSE_UI_TOOLING)
    debugImplementation(Dependencies.AndroidX.Compose.COMPOSE_PREVIEW_TOOLING)
}

subprojects {
    apply(plugin = BuildPlugins.KTLINT)

    repositories {
        mavenCentral()
    }

    configure<org.jlleitschuh.gradle.ktlint.KtlintExtension> {
        version.set("11.0.0")
        debug.set(true)
        verbose.set(true)
        android.set(false)
        outputToConsole.set(true)
        outputColorName.set("RED")
        ignoreFailures.set(true)
        enableExperimentalRules.set(true)
        additionalEditorconfigFile.set(file("/some/additional/.editorconfig"))
        baseline.set(file("my-project-ktlint-baseline.xml"))
        reporters {
            reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.PLAIN)
            reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.CHECKSTYLE)
            reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.SARIF)

            customReporters {
                register("csv") {
                    fileExtension = "csv"
                    dependency = project(":project-reporters:csv-reporter")
                }
                register("yaml") {
                    fileExtension = "yml"
                    dependency = "com.example:ktlint-yaml-reporter:1.0.0"
                }
            }
        }
        kotlinScriptAdditionalPaths {
            include(fileTree("scripts/"))
        }
        filter {
            exclude("**/generated/**")
            include("**/kotlin/**")
        }
    }

    dependencies {
        ktlintRuleset("com.github.username:rulseset:master-SNAPSHOT")
        ktlintRuleset(files("/path/to/custom/rulseset.jar"))
        ktlintRuleset(project(":chore:project-ruleset"))
    }
}
