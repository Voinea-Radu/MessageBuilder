# LightDream Message Builder

![Build](../../actions/workflows/build.yml/badge.svg)
![Version](https://img.shields.io/badge/Version-3.0.4-red.svg)

A string manipulation library that allows you to create messages with placeholders.
Serializes to a string / lists uing GSON and [FileManager](https://github.com/L1ghtDream/FileManager).

## Use

### Maven

```xml

<repositories>
    <repository>
        <id>lightdream-repo</id>
        <url>https://repo.lightdream.dev/</url>
    </repository>
    <!-- Other repositories -->
</repositories>
```

```xml

<dependencies>
    <dependency>
        <groupId>dev.lightdream</groupId>
        <artifactId>MessageBuilder</artifactId>
        <version>3.0.4</version>
    </dependency>
    <!-- Other dependencies -->
</dependencies>
```

### Gradle

```groovy
repositories {
    maven { url "https://repo.lightdream.dev/" }

    // Other repositories
}

dependencies {
    implementation "dev.lightdream:MessageBuilder:3.0.4"

    // Other dependencies
}
```

## Example

Can be found in the [source code](/src/main/java/dev/lightdream/messagebuilder/example)



