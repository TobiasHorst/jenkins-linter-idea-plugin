rootProject.name = providers.gradleProperty("pluginName").get()

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.9.0"
}
