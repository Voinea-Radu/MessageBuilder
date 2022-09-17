# LightDream Message Builder

![Build](https://github.com/L1ghtDream/MessageBuilder/actions/workflows/build.yml/badge.svg)
![Version](https://img.shields.io/badge/Version-3.0.3-red.svg)

A string manipulation library that allows you to create messages with placeholders.
Serializes to a string / list using GSON and [FileManager](https://github.com/L1ghtDream/FileManager).

## Use

### Maven

```xml

<repositories>
    <repository>
        <id>lightdream-repo</id>
        <url>https://repo.lightdream.dev/repository/LightDream-API/</url>
    </repository>
    <!-- Other repositories -->
</repositories>
```

```xml

<dependencies>
    <dependencies>
        <dependency>
            <groupId>dev.lightdream</groupId>
            <artifactId>MessageBuilder</artifactId>
            <version>3.0.3</version>
        </dependency>
        <!-- Other dependencies -->
    </dependencies>
    <!-- Other dependencies -->
</dependencies>
```

### Gradle

```gradle
repositories {
    maven { url "https://repo.lightdream.dev/repository/LightDream-API/" }
    
    // Other repositories
}

dependencies {
    implementation "dev.lightdream:MessageBuilder:3.0.3"
    
    // Other dependencies
}
```

## Example

```java
import dev.lightdream.filemanager.FileManager;
import dev.lightdream.messagebuilder.MessageBuilder;
import dev.lightdream.messagebuilder.MessageBuilderList;
import dev.lightdream.messagebuilder.MessageBuilderManager;

public class Example {

    public void parse(FileManager fileManager) {
        MessageBuilderManager.init(fileManager); // FileManager argument is optional
        MessageBuilderManager.setupForge(); // or setupSpigot()

        MessageBuilder builderString = new MessageBuilder("Hello %name%!");
        MessageBuilderList builderList = new MessageBuilderList("Hello %names%!");

        String name = "LightDream";
        String[] names = {"LightDream", "Foo", "Bar"};

        builderString.parse("%name%", name);
        builderList.parse("%names%", names);
    }

}
```


