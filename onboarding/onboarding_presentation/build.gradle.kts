plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
}

apply(from = "$rootDir/compose-module.gradle")

android {
    namespace = "pl.dnajdrowski.onboarding_presentation"
}

dependencies {
    implementation(project(Modules.coreModule))
    implementation(project(Modules.coreUiModule))
    implementation(project(Modules.onBoardingDomainModule))
}