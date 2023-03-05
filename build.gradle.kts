import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.8.0"
    application
}

group = "com.bikeleasing.antoniotest"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions{
        freeCompilerArgs = listOf("-Xruntime-logs=gc=info")
        jvmTarget = "17"
    }
}

kotlin {
    jvmToolchain(17)

}

application {
    mainClass.set("com.bikeleasing.antoniotest.MainKt")
}