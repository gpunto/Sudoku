import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    kotlin("multiplatform") version "1.3.72"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

tasks.withType<Test> {
    useJUnitPlatform()
}
tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}
kotlin {
    /* Targets configuration omitted. 
    *  To find out how to configure the targets, please follow the link:
    *  https://kotlinlang.org/docs/reference/building-mpp-with-gradle.html#setting-up-targets */

    jvm()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(kotlin("stdlib-common"))
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
                implementation("io.kotest:kotest-assertions-core:4.0.6")
                implementation("io.kotest:kotest-runner-junit5:4.0.6")
                implementation("io.kotest:kotest-property:4.0.6")
            }
        }
        val jvmMain by getting {
            dependencies {
                implementation(kotlin("stdlib-jdk8"))
            }
        }
        val jvmTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation(kotlin("test-junit"))
                implementation("io.kotest:kotest-runner-junit5-jvm:4.0.6")
                implementation("io.kotest:kotest-assertions-core-jvm:4.0.6")
                implementation("io.kotest:kotest-property-jvm:4.0.6")
            }
        }
    }
}

val run by tasks.creating(JavaExec::class) {
    group = "application"
    main = "com.gianmarcodavid.sudoku.MainKt"
    kotlin {
        val main = targets["jvm"].compilations["main"]
        dependsOn(main.compileAllTaskName)
        classpath(
            { main.output.allOutputs.files },
            { configurations["jvmRuntimeClasspath"] }
        )
    }
    // disable app icon on macOS
    systemProperty("java.awt.headless", "true")
}