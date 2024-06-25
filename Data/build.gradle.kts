plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsKotlinAndroid)

    alias(libs.plugins.kspSupport)
    alias(libs.plugins.hiltAndroid)
    //alias(libs.plugins.roomSupport)
    id("androidx.room")
}

android {
    namespace = "com.adrian.data"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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

    room {
        schemaDirectory("$projectDir/schemas")
    }
}

dependencies {

    implementation(project(":Commons"))

    // Data layer is the only aware that Retrofit is being implemented.
    // Data layer is the only one that knows "How" the Data is obtained
    implementation(libs.google.gson)
    implementation(libs.bundles.retrofit)

    // Dagger - Hilt dependencies
    implementation(libs.dagger.hilt)
    ksp(libs.dagger.hilt.compiler)

    // Room dependencies
    implementation(libs.room.runtime)
    ksp(libs.room.compiler)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}