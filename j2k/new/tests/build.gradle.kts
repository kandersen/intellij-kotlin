// GENERATED build.gradle.kts
// GENERATED BY kotlin.j2k.new.tests.iml
// USE `./gradlew generateIdeaGradleFiles` TO REGENERATE THIS FILE

plugins {
    kotlin("jvm")
    `java-library` // Add `compileOnlyApi` configuration
    id("jps-compatible")
}

repositories {
    maven { setUrl("https://cache-redirector.jetbrains.com/maven-central") }
    maven { setUrl("https://cache-redirector.jetbrains.com/intellij-third-party-dependencies") }
    maven { setUrl("https://cache-redirector.jetbrains.com/jcenter") }
    maven { setUrl("https://cache-redirector.jetbrains.com/dl.google.com/dl/android/maven2") }
    maven { setUrl("https://cache-redirector.jetbrains.com/repo.jenkins-ci.org/releases") }
    maven { setUrl("https://cache-redirector.jetbrains.com/dl.bintray.com/groovy/maven/") }
    maven { setUrl("https://cache-redirector.jetbrains.com/jetbrains.bintray.com/jediterm/") }
    maven { setUrl("https://cache-redirector.jetbrains.com/jetbrains.bintray.com/markdown") }
    maven { setUrl("https://cache-redirector.jetbrains.com/www.myget.org/F/rd-snapshots/maven") }
    maven { setUrl("https://cache-redirector.jetbrains.com/download.jetbrains.com/teamcity-repository") }
    maven { setUrl("https://cache-redirector.jetbrains.com/kotlin.bintray.com/kotlin-plugin/") }
    maven { setUrl("https://cache-redirector.jetbrains.com/jetbrains.bintray.com/space") }
    maven { setUrl("https://cache-redirector.jetbrains.com/kotlin.bintray.com/kotlin-ide-plugin-dependencies") }
    maven { setUrl("https://cache-redirector.jetbrains.com/maven.pkg.jetbrains.space/kotlin/p/kotlin/kotlin-ide") }
    maven { setUrl("https://cache-redirector.jetbrains.com/kotlin.bintray.com/kotlin-ide-plugin-dependencies") }
}

dependencies {
    implementation(toolsJarApi())
    runtimeOnly(intellijDep(forIde = true))
    testRuntimeOnly(intellijDep(forIde = true))
    jpsLikeJarDependency(kotlinStdlib(), JpsDepScope.COMPILE)
    jpsLikeJarDependency(project(":kotlin-stdlib-jdk7"), JpsDepScope.COMPILE)
    jpsLikeJarDependency(project(":prepare:ide-plugin-dependencies:kotlin-compiler-for-ide"), JpsDepScope.COMPILE)
    jpsLikeModuleDependency(":kotlin-ide.kotlin.j2k.old.tests", JpsDepScope.TEST)
    jpsLikeModuleDependency(":kotlin-ide.kotlin.j2k.services", JpsDepScope.TEST)
    jpsLikeModuleDependency(":kotlin-ide.kotlin.j2k.new", JpsDepScope.TEST)
    jpsLikeModuleDependency(":kotlin-ide.kotlin.j2k.old", JpsDepScope.TEST)
    jpsLikeModuleDependency(":kotlin-ide.kotlin.j2k.idea", JpsDepScope.TEST)
    jpsLikeModuleDependency(":kotlin-ide.kotlin.tests-common", JpsDepScope.TEST)
    jpsLikeModuleDependency(":kotlin-ide.kotlin.idea", JpsDepScope.TEST)
    jpsLikeModuleDependency(":kotlin-ide.kotlin.common", JpsDepScope.TEST)
    jpsLikeModuleDependency(":kotlin-ide.kotlin.core", JpsDepScope.TEST)
    jpsLikeModuleDependency(":kotlin-ide.kotlin.idea.tests", JpsDepScope.TEST)
    jpsLikeModuleDependency(":kotlin-ide.kotlin.fir.frontend-independent", JpsDepScope.TEST)
    jpsLikeJarDependency(intellijDep(forIde = true), JpsDepScope.TEST, { includeJars("platform-api") }) // 'intellij.platform.core' dependency
    jpsLikeJarDependency(intellijDep(forIde = true), JpsDepScope.TEST, { includeJars("resources_en") }) // 'intellij.platform.core' dependency
    jpsLikeJarDependency(intellijCoreDep(), JpsDepScope.TEST) // 'intellij.platform.core' dependency
    jpsLikeJarDependency(intellijDep(forIde = true), JpsDepScope.TEST, { includeJars("intellij-core-analysis-deprecated") }) // 'intellij.platform.core' dependency
    jpsLikeJarDependency(intellijDep(forIde = true), JpsDepScope.TEST, { includeJars("extensions") }) // 'intellij.platform.core' dependency
    jpsLikeJarDependency(intellijDep(forIde = true), JpsDepScope.TEST, { includeJars("util") }) // 'intellij.platform.core' dependency
    jpsLikeJarDependency("org.jetbrains:annotations:20.1.0", JpsDepScope.TEST) // 'intellij.platform.core' dependency
    jpsLikeJarDependency(intellijPluginDep("java", forIde = true), JpsDepScope.TEST) // 'intellij.java.psi' dependency
    jpsLikeModuleDependency(":kotlin-ide.kotlin.test-framework", JpsDepScope.TEST)
}

configurations.all {
    exclude(module = "tests-common") // Avoid classes with same FQN clashing
}

sourceSets {
    "main" {
        
    }
    "test" {
        java.srcDir("test")
    }
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(11))
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.dsl.KotlinJvmCompile> {
    kotlinOptions.freeCompilerArgs = listOf("-version", "-Xstrict-java-nullability-assertions", "-Xjvm-default=enable", "-Xskip-prerelease-check")
    kotlinOptions.jdkHome = rootProject.extra["JDK_11"] as String
    kotlinOptions.useOldBackend = true // KT-45697
}

testsJar()
projectTest()