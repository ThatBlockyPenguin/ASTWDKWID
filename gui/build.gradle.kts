plugins {
    id("com.blockypenguin.astwdkwid.java-application-conventions")
}

application {
    mainClass.set("com.blockypenguin.astwdkwid.gui.GUILauncher")
}

dependencies {
    implementation(project(":server"))
}