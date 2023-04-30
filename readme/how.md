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