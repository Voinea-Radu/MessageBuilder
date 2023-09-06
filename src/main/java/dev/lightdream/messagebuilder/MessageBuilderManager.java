package dev.lightdream.messagebuilder;

import dev.lightdream.messagebuilder.data.deserializer.MessageBuilderDeserializer;
import dev.lightdream.messagebuilder.data.deserializer.MessageBuilderListDeserializer;
import dev.lightdream.messagebuilder.data.serializer.MessageBuilderListSerializer;
import dev.lightdream.messagebuilder.data.serializer.MessageBuilderSerializer;
import lombok.Getter;

@SuppressWarnings({"unused", "LombokGetterMayBeUsed"})
public class MessageBuilderManager {

    private static @Getter String colorChar = "&";
    private static @Getter String colorCharReplace = "§";
    private static @Getter boolean initialized = false;
    private static @Getter boolean chatColor = false;

    public static void setColorChar(String colorChar) {
        MessageBuilderManager.colorChar = colorChar;
    }

    public static void setColorCharReplace(String colorCharReplace) {
        MessageBuilderManager.colorCharReplace = colorCharReplace;
    }

    public static void setupSpigot() {
        setColorChar("&");
        setColorCharReplace("§");
    }

    public static void setupForge() {
        setColorChar("&");
        //noinspection UnnecessaryUnicodeEscape
        setColorCharReplace("\u00a7");
    }

    public static void init() {
        new MessageBuilderSerializer().register();
        new MessageBuilderListSerializer().register();
        new MessageBuilderDeserializer().register();
        new MessageBuilderListDeserializer().register();

        initialized = true;
    }

    public static void disableChatColor() {
        chatColor = false;
    }

    public static void enableChatColor() {
        chatColor = true;
    }

}
