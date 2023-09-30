
plugins {
    application
}

repositories {
    mavenCentral()
}

dependencies {
	implementation("org.apache.logging.log4j:log4j-api:2.20.0")
	implementation("org.apache.logging.log4j:log4j-core:2.20.0")
}

java.toolchain.languageVersion.set(JavaLanguageVersion.of(17))

application {
    mainClass.set("com.blockypenguin.overlord.Overlord")
}