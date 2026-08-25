import java.io.File

plugins {
    id("dev.kikugie.loom-back-compat")
    id("maven-publish")
}

val modId = "hyperperformance"
val mcVersion = sc.current.version

group = "com.hyperperformance"
version = "0.1.0+mc$mcVersion"

repositories {
    maven("https://maven.fabricmc.net/")
    mavenCentral()
}

val fabricApiVersions = mapOf(
    "1.20.1" to "0.92.6+1.20.1",
    "1.20.4" to "0.97.3+1.20.4",
    "1.20.6" to "0.100.8+1.20.6",
    "1.21.1" to "0.116.14+1.21.1",
    "1.21.4" to "0.119.4+1.21.4",
    "1.21.8" to "0.136.1+1.21.8",
    "26.1.2" to "0.155.2+26.1.2",
    "26.2" to "0.156.0+26.2",
)

val minecraftDependencyRanges = mapOf(
    "1.20.1" to ">=1.20 <=1.20.3",
    "1.20.4" to "1.20.4",
    "1.20.6" to ">=1.20.5 <=1.20.6",
    "1.21.1" to ">=1.21 <=1.21.1",
    "1.21.4" to ">=1.21.2 <=1.21.4",
    "1.21.8" to ">=1.21.5 <=1.21.11",
    "26.1.2" to ">=26.1 <=26.1.2",
    "26.2" to "26.2",
)

val javaVersion = when {
    sc.current.parsed >= "26.1" -> 25
    sc.current.parsed >= "1.20.5" -> 21
    sc.current.parsed >= "1.18" -> 17
    else -> 21
}

base {
    archivesName.set("$modId-$mcVersion")
}

loom {
    mods {
        create(modId) {
            sourceSet(sourceSets["main"])
        }
    }
}

dependencies {
    minecraft("com.mojang:minecraft:$mcVersion")
    loomx.applyMojangMappings()
    modImplementation("net.fabricmc:fabric-loader:0.19.3")
    modImplementation("net.fabricmc.fabric-api:fabric-api:${fabricApiVersions[mcVersion] ?: "0.156.0+26.2"}")
}

tasks.processResources {
    val mcRange = minecraftDependencyRanges[mcVersion] ?: mcVersion
    inputs.property("version", project.version)
    inputs.property("minecraft_version", mcRange)
    filesMatching("fabric.mod.json") {
        expand(
            "version" to project.version,
            "minecraft_version" to mcRange
        )
    }
}

tasks.withType<JavaCompile>().configureEach {
    options.release.set(javaVersion)
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(javaVersion))
    withSourcesJar()
}

tasks.register<Copy>("copyBuiltJarToOutputs") {
    dependsOn(loomx.modJar)
    from(loomx.modJar.flatMap { it.archiveFile })
    into(rootProject.layout.projectDirectory.dir("outputs"))
}
