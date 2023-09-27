
plugins {
    application
}

repositories {
    mavenCentral()
}

dependencies {
}

java.toolchain.languageVersion.set(JavaLanguageVersion.of(17))

application {
    mainClass.set("com.blockypenguin.overlord.Overlord")
}