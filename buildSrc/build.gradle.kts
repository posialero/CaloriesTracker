plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
}

allprojects{
    repositories {
        maven("https://oss.sonatype.org/content/repositories/snapshots/")
    }
}