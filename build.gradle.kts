buildscript {
    extra.apply {
        set("koinVersion", "3.4.2")
        set("koinVersionCompose", "3.4.2")
        set("ktorVersion", "2.3.1")
        set("kotlinxSerialization", "1.5.1")
        set("accompanistSystemuicontroller", "0.30.1")
        set("logback", "1.2.11")
        set("composeBom", "2023.05.01")
        set("coilCompose", "2.4.0")
        set("navigationCompose", "2.6.0")
        set("progressLib", "0.2.0")
    }
}//// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.0.2" apply false
    id("com.android.library") version "8.0.2" apply false
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
    id("org.jetbrains.kotlin.plugin.serialization") version "1.8.10" apply false
}