package dev.lightdream.messagebuilder;

import dev.lightdream.filemanager.FileManager;
import dev.lightdream.messagebuilder.data.MessageBuilderDeserializer;
import dev.lightdream.messagebuilder.data.MessageBuilderListDeserializer;
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
        if (FileManager.get() != null) {
            new MessageBuilderDeserializer().register(FileManager.get());
            new MessageBuilderListDeserializer().register(FileManager.get());
        }

        initialized = true;
    }

    public static void disableChatColor() {
        chatColor = false;
    }

    public static void enableChatColor() {
        chatColor = true;
    }

}
