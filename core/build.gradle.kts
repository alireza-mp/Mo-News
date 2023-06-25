plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "ir.alirezamp.core"
    compileSdk = 33

    defaultConfig {
        minSdk = 21

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = true
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

    api(project(":constants"))

    val ktorVersion: String by rootProject.extra
    val kotlinxSerialization: String by rootProject.extra
    val koinVersion: String by rootProject.extra
    val logback: String by rootProject.extra
    val composeRuntime: String by rootProject.extra

    //ktor
    api("io.ktor:ktor-client-core:$ktorVersion")
    api("io.ktor:ktor-client-android:$ktorVersion")
    api("io.ktor:ktor-client-content-negotiation:$ktorVersion")
    api("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
//    api("io.ktor:ktor-client-logging:$ktorVersion")
//    api("ch.qos.logback:logback-classic:$logback")
    api("org.jetbrains.kotlinx:kotlinx-serialization-json:$kotlinxSerialization")

    //koin
    api("io.insert-koin:koin-android:$koinVersion")

    //compose runtime
    api("androidx.compose.runtime:runtime:$composeRuntime")
}