plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id ("androidx.navigation.safeargs.kotlin")

}

android {
    namespace = "com.example.threadexchange"
    compileSdk = 34
    viewBinding{
        enable=true
    }

    defaultConfig {
        applicationId = "com.example.threadexchange"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
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
}

dependencies {
    val nav_version="2.7.0"
    implementation ("com.google.android.material:material:1.8.0")
    implementation ("com.google.android.material:material:1.4.0")

    // Preferences DataStore (SharedPreferences like APIs)
    dependencies {
        implementation("androidx.datastore:datastore-preferences:1.0.0")

        implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
        // optional - RxJava2 support
        implementation("androidx.datastore:datastore-preferences-rxjava2:1.0.0")

        // optional - RxJava3 support
        implementation("androidx.datastore:datastore-preferences-rxjava3:1.0.0")
    }

    // Alternatively - use the following artifact without an Android dependency.
    dependencies {
        implementation("androidx.datastore:datastore-preferences-core:1.0.0")
    }


    // Typed DataStore (Typed API surface, such as Proto)
    dependencies {
        implementation("androidx.datastore:datastore:1.0.0")

        // optional - RxJava2 support
        implementation("androidx.datastore:datastore-rxjava2:1.0.0")

        // optional - RxJava3 support
        implementation("androidx.datastore:datastore-rxjava3:1.0.0")
    }

    // Alternatively - use the following artifact without an Android dependency.
    dependencies {
        implementation("androidx.datastore:datastore-core:1.0.0")
    }

    implementation("com.github.bumptech.glide:glide:4.12.0")
    annotationProcessor("com.github.bumptech.glide:compiler:4.12.0")
    implementation("androidx.viewpager2:viewpager2:1.0.0")

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation ("androidx.navigation:navigation-fragment-ktx:+")
    implementation ("androidx.navigation:navigation-ui-ktx:+")
    implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
    implementation("androidx.navigation:navigation-ui-ktx:$nav_version")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}