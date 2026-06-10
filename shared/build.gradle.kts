plugins {
    alias(libs.plugins.kotlinMultiplatform)
}

kotlin {
    jvm()

    @OptIn(org.jetbrains.kotlin.gradle.ExperimentalWasmDsl::class)
    wasmJs {
        browser()
    }

    sourceSets {
        commonMain.dependencies {
            implementation(kotlin("stdlib")) // Явная зависимость от stdlib
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}