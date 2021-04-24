plugins {
    kotlin("multiplatform") version "1.4.32"
    id("com.android.library")
}

group = "me.takahirom"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
android {
    defaultConfig {
        compileSdkVersion(29)
        targetSdkVersion(29)
    }
}

kotlin {
    /* Targets configuration omitted. 
    *  To find out how to configure the targets, please follow the link:
    *  https://kotlinlang.org/docs/reference/building-mpp-with-gradle.html#setting-up-targets */
    ios()
    android()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(kotlin("stdlib-common"))
                implementation(project(":module-b"))
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
    }
}