import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinxSerialization)
}

kotlin {
    jvm()
    androidTarget()
    jvmToolchain(17)

    val xcf = XCFramework()
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "gdg-network"
            xcf.add(this)
        }
    }

    sourceSets {
        commonMain.dependencies {
            // Ktorfit
            implementation(libs.ktorfit)
            implementation(libs.ktorfit.converters.response)
            implementation(libs.ktorfit.converters.call)
            implementation(libs.ktorfit.converters.flow)

            // Ktor
            implementation(libs.ktor.client.serialization)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.serialization.kotlinx.json)
            implementation(libs.ktor.extension.logging)
        }
    }
}

android {
    namespace = "id.gdg.network"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")

    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
    }
}
