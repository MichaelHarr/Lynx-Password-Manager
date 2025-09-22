plugins {
	kotlin("jvm") version "2.2.0"
	kotlin("plugin.spring") version "2.2.0"
  kotlin("plugin.allopen") version "2.2.20"
  kotlin("plugin.jpa") version "2.2.20"
	id("org.springframework.boot") version "3.5.5"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "com.autotrader"
version = "0.0.1-SNAPSHOT"
description = "Project to learn Kotlin"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
  implementation("com.squareup.okhttp3:okhttp:5.1.0")
  implementation("org.springframework.boot:spring-boot-starter")
  implementation("org.springframework.shell:spring-shell-starter")
  implementation("org.springframework.boot:spring-boot-starter-data-jpa")
  implementation("org.modelmapper:modelmapper:3.2.4")
  runtimeOnly("org.postgresql:postgresql:42.7.2")
  testImplementation("org.springframework.boot:spring-boot-starter-test")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

dependencyManagement {
  imports {
    mavenBom("org.springframework.shell:spring-shell-dependencies:3.3.4")
  }
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
