object Dependencies {

    object AndroidX {
        const val CORE_KTX = "androidx.core:core-ktx:${Versions.KTX_CORE}"

        object Compose {

            const val COMPOSE_UI = "androidx.compose.ui:ui:${Versions.COMPOSE}"
            const val COMPOSE_MATERIAL = "androidx.compose.material:material:${Versions.COMPOSE}"
            const val COMPOSE_PREVIEW_TOOLING =
                "androidx.compose.ui:ui-tooling-preview:${Versions.COMPOSE}"

            // Testing
            const val COMPOSE_JUNIT_UI = "androidx.compose.ui:ui-test-junit4:${Versions.COMPOSE}"
            const val COMPOSE_UI_TOOLING = "androidx.compose.ui:ui-tooling:${Versions.COMPOSE}"
            const val COMPOSE_MANIFEST_TEST =
                "androidx.compose.ui:ui-test-manifest:${Versions.COMPOSE_TEST_MANIFEST}"

        }

        object Activity {
            const val COMPOSE_ACTIVITY =
                "androidx.activity:activity-compose:${Versions.COMPOSE_ACTIVITY}"
        }

        object Lifecycle {
            const val LIFECYCLE_RUNTIME =
                "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.LIFECYCLE}"
            const val LIFECYCLE_VIEWMODEL =
                "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.LIFECYCLE}"

        }
    }

    object Accompanist {
        const val SYSTEM_UI_CONTROLLER =
            "com.google.accompanist:accompanist-systemuicontroller:${Versions.ACCOMPANIST_SYSTEM_UI_CONTROLLER}"

        const val PAGER = "com.google.accompanist:accompanist-pager:${Versions.ACCOMPANIST_PAGER}"
    }

    object Testing {
        const val JUNIT = "junit:junit:${Versions.JUNIT}"
        const val JUNIT_ANDROID = "androidx.test.ext:junit:${Versions.JUNIT_ANDROID}"
        const val ROBOLECTRIC = "org.robolectric:robolectric:${Versions.ROBOLECTRIC}"
        const val ESPRESSO = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO}"
    }

    object Navigation {
        const val NAVIGATION_RUNTIME =
            "androidx.navigation:navigation-runtime-ktx:${Versions.NAVIGATION}"
    }

    object SplashScreen {
        const val SPLASH_SCREEN_CORE = "androidx.core:core-splashscreen:${Versions.SPLASH_SCREEN}"
    }

    object DataStore {
        const val PREFERENCES = "androidx.datastore:datastore-preferences:${Versions.DATA_STORE}"
    }

    object Firebase {
        const val FIREBASE_AUTH = "com.google.firebase:firebase-auth-ktx:${Versions.FIREBASE_AUTH}"
    }

    object DaggerHilt {
        const val HILT_ANDROID =
            "com.google.dagger:hilt-android:${Versions.DAGGER_HILT}"
        const val HILT_ANDROID_COMPILER =
            "com.google.dagger:hilt-android-compiler:${Versions.DAGGER_HILT}"
        const val HILT_COMPILER = "androidx.hilt:hilt-compiler:${Versions.DAGGER_HILT_COMPILER}"
        const val HILT_NAVIGATION =
            "androidx.hilt:hilt-navigation-compose:${Versions.DAGGER_HILT_NAVIGATION}"
    }


}
