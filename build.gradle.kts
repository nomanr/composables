val spotlessPluginId = libs.plugins.spotless.get().pluginId
val ktlintVersion = libs.versions.ktlint.get()

buildscript {
    repositories {
        google()
        mavenCentral()

    }
}
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.org.jetbrains.kotlin.jvm) apply false
    alias(libs.plugins.spotless) apply false
}

subprojects {
    apply {
        plugin(spotlessPluginId)
    }

    configure<com.diffplug.gradle.spotless.SpotlessExtension> {
        kotlin {
            target("**/*.kt")
            targetExclude("${layout.buildDirectory}/**/*.kt")
            targetExclude("bin/**/*.kt")

            ktlint(ktlintVersion).userData(
                mapOf(
                    "android" to "true",
                    "disabled_rules" to "no-wildcard-imports",
                    "max_line_length" to "off"
                )
            )
        }
    }

}


allprojects {
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
        kotlinOptions {
            freeCompilerArgs += listOf("-Xopt-in=androidx.compose.material3.ExperimentalMaterial3Api")
        }
    }


}

