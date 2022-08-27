package dev.lightdream.messagebuilder;

import java.util.Arrays;

public class Executor {

    public static void main(String[] args) {
        System.out.println(new MessageBuilder("Hello, %test%!")
                .parse("test", "World")
                .parse()
        );

        System.out.println(new MessageBuilderList("Hello, %test%!%%new-line%%Hello, %test%!")
                .parse("test", "World")
                .parse()
        );

        System.out.println(new MessageBuilderList(Arrays.asList(
                "Hello, %test%!",
                "Hello, %test%!"))
                .parse("test", "World")
                .parse()
        );
    }

}
