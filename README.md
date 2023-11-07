# MessageBuilder

![Build](../../actions/workflows/build.yml/badge.svg)
![Version](https://img.shields.io/badge/Version-4.0.1-red.svg)

# Table Of Contents

1. [Description](#description)
2. [How to add to your project](#how-to-add-to-your-project)
3. [How to use](#how-to-use)

## Description

A placeholder parser that hooks into FileManager for the best storage integration.

## How to add to your project

The artifact can be found at the repository https://repo.lightdream.dev or https://jitpack.io (under
com.github.L1ghtDream instead of dev.lightdream)

### Maven

```xml

<repositories>
    <repository>
        <id>lightdream-repo</id>
        <url>https://repo.lightdream.dev/</url>
    </repository>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

```xml

<dependencies>
    <dependency>
        <groupId>dev.lightdream</groupId>
        <artifactId>message-builder</artifactId>
        <version>4.0.1</version>
    </dependency>
    <dependency>
        <groupId>com.github.L1ghtDream</groupId>
        <artifactId>message-builder</artifactId>
        <version>4.0.1</version>
    </dependency>
</dependencies>
```

### Gradle - Groovy DSL

```groovy
repositories {
    maven { url "https://repo.lightdream.dev/" }
    maven { url "https://jitpack.io" }
}

dependencies {
    implementation "dev.lightdream:message-builder:4.0.1"
    implementation "com.github.L1ghtDream:message-builder:4.0.1"
}
```

### Gradle - Kotlin DSL

```kotlin
repositories {
    maven("https://repo.lightdream.dev/")
    maven("https://jitpack.io")
}

dependencies {
    implementation("dev.lightdream:message-builder:4.0.1")
    implementation("com.github.L1ghtDream:message-builder:4.0.1")
}
```

If you want to use an older version that is not available in https://repo.lightdream.dev you can try
using https://archive-repo.lightdream.dev

## How to use

### Main class

```java
public class ExampleMain {

    public ExampleMain(FileManager fileManager) {
        // You can call any of the option bellow, depending on whether you want to add compatibility with FileManager or not
        MessageBuilder.init(fileManager);
        // If FileManager#setStatic has been called. This call will automatically register itself with the static instance
        MessageBuilder.init();
    }


}
```

### Usage

```java
public class ExampleUse {
    public void use() {
        MessageBuilder builder = new MessageBuilder("This a text full of %placeholder%");
        String output = builder.parse("placeholder", "replacements")
                .parse();

        MessageBuilderList listBuilder = new MessageBuilderList(Arrays.asList(
                "This a text full of %placeholder%",
                "This is another line of the text full of%placeholder%"
        ));

        List<String> listOutput = listBuilder.parse("placeholder", "replacements")
                .parse();
    }
}
```
