plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
}

apply(from = "$rootDir/compose-module.gradle")

android {
    namespace = "pl.dnajdrowski.core_ui"
}