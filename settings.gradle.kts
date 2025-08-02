rootProject.name = providers.gradleProperty("pluginName").get()

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}
