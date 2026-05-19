import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
}

android {
    namespace = "com.example.movieexplorer"
    compileSdk {
        version = release(36) {
            minorApiLevel = 1
        }
    }

    defaultConfig {
        applicationId = "com.example.movieexplorer"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        val properties = Properties()
        val localProperties = rootProject.file("local.properties")
        if (localProperties.exists()) {
            localProperties.inputStream().use { properties.load(it) }
        }
        val tmbd: String = properties.getProperty("tmdb.api.key", "")
        buildConfigField(type = "String", name = "TMDB_API_KEY", value = "\"$tmbd\"")
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
}

dependencies {
    implementation(libs.androidx.navigation.fragment)
    implementation(libs.hilt)
    implementation(libs.retrofit)
    implementation(libs.retrofit.gson)
    implementation(libs.moshi)
    implementation(libs.okhttp)
    implementation(libs.okhttp.logging)
    ksp(libs.moshi.codegen)
    implementation(libs.moshi.kotlin)
    implementation(libs.retrofit.moshi)
    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
    ksp(libs.room.compiler)
    ksp(libs.hilt.compiler)
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.core.ktx)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
}