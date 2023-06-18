buildscript {
    extra.apply {
        set("koinVersion", "3.4.2")
        set("koinVersionCompose", "3.4.2")
    }
}//// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.0.2" apply false
    id("com.android.library") version "8.0.2" apply false
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
}