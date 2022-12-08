package com.androiders.dateme.buildsrc

object SDK {
    const val min = 21
    const val max = 33
    const val compile = max
}

object Libs {

    object Kotlin {
        const val kotlinCompiler = "1.3.2"
    }

    object AndroidX {
        const val coreKtx = "androidx.core:core-ktx:1.7.0"

        object Compose {
            const val version = "1.4.0-alpha01"

            const val ui = "androidx.compose.ui:ui:$version"
            const val material = "androidx.compose.material3:material3:1.0.1"
            const val toolingPreview = "androidx.compose.ui:ui-tooling-preview:$version"

            //testing
            const val uiTest = "androidx.compose.ui:ui-test-junit4:$version"
            const val uiTooling = "androidx.compose.ui:ui-tooling:$version"
            const val uiTestManifest = "androidx.compose.ui:ui-tooling:$version"

        }

        object Activity {
            const val activityCompose = "androidx.activity:activity-compose:1.6.1"
        }

        object Lifecycle {
            const val version = "2.5.1"
            const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:$version"
            const val viewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:$version"

        }
    }

    object Accompanist {
        const val systemUi = "com.google.accompanist:accompanist-systemuicontroller:0.27.0"
        const val pager ="com.google.accompanist:accompanist-pager:0.12.0"
    }

    object Navigation {
        const val nav = "androidx.navigation:navigation-runtime-ktx:2.5.3"
    }

    object SplashScreen {
        const val core  = "androidx.core:core-splashscreen:1.0.0"
    }

    object DataStore {
        const val prefs = "androidx.datastore:datastore-preferences:1.0.0"
    }


}