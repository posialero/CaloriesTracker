plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.kspLibrary)
}

apply(from = "$rootDir/base-module.gradle")

android {
    namespace = "pl.dnajdrowski.tracker_data"
}

dependencies {
    implementation(project(Modules.coreModule))
    implementation(project(Modules.trackerDomainModule))

    implementation(libs.retrofit)
    implementation(libs.okHtttp3)
    implementation(libs.okHtttp3.logging.interceptor)
    implementation(libs.moshi.converter)
    implementation(libs.moshi.codegen)
    implementation(libs.moshi.kotlin)
    implementation(libs.moshi)

    ksp(libs.room.compiler)
    implementation(libs.room.ktx)
    implementation(libs.room.runtime)
}