// Client & Server

plugins {
    id("com.blockypenguin.astwdkwid.java-common-conventions")
    application
}

dependencies {
    implementation("org.apache.logging.log4j:log4j-api:2.20.0")
    implementation("org.apache.logging.log4j:log4j-core:2.20.0")
    implementation(project(":core"))
}