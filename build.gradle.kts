buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.0.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.0")
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.46.1")
    }
}

extra["compose_version"] = "1.0.2"

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
