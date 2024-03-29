plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
}

apply(from = "$rootDir/base-module.gradle")

android {
    namespace = "pl.dnajdrowski.onboarding_domain"
}

dependencies {
    implementation(project(Modules.coreModule))
}