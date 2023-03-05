import org.jetbrains.dokka.DokkaDefaults.outputDir
import org.jetbrains.dokka.DokkaDefaults.pluginsConfiguration
import org.jetbrains.dokka.gradle.DokkaTask
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.dokka.base.DokkaBase
import org.jetbrains.dokka.base.DokkaBaseConfiguration

plugins {
    kotlin("jvm") version "1.8.0"
    id("org.jetbrains.dokka") version "1.7.20"
    application
}

group = "com.bikeleasing.antoniotest"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.8.10")
    testImplementation(kotlin("test"))
}

buildscript {
    dependencies {
        classpath("org.jetbrains.dokka:dokka-base:1.7.20")
    }
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


tasks.withType<DokkaTask> {
    pluginConfiguration<DokkaBase, DokkaBaseConfiguration>{
        outputDirectory.set(File("$projectDir/docs"))
        footerMessage = "This is a footer message"
    }
}

kotlin {
    jvmToolchain(17)

}

application {
    mainClass.set("com.bikeleasing.antoniotest.MainKt")
}