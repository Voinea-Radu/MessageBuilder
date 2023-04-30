package dev.lightdream.messagebuilder;

import dev.lightdream.filemanager.FileManager;
import dev.lightdream.messagebuilder.data.deserializer.MessageBuilderDeserializer;
import dev.lightdream.messagebuilder.data.deserializer.MessageBuilderListDeserializer;
import dev.lightdream.messagebuilder.data.serializer.MessageBuilderListSerializer;
import dev.lightdream.messagebuilder.data.serializer.MessageBuilderSerializer;

@SuppressWarnings("unused")
public class MessageBuilderManager {

    public static String colorChar = "&";
    public static String colorCharReplace = "§";
    private static boolean initialized = false;
    private static boolean chatColor = false;

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

    public static boolean isInitialized() {
        return initialized;
    }

    public static void init(FileManager fileManager) {
        new MessageBuilderSerializer().register(fileManager);
        new MessageBuilderListSerializer().register(fileManager);
        new MessageBuilderDeserializer().register(fileManager);
        new MessageBuilderListDeserializer().register(fileManager);

        initialized = true;
    }

    public static void init() {
        if (FileManager.get() != null) {
            init(FileManager.get());
            return;
        }
        initialized = true;
    }

    public static void disableChatColor() {
        chatColor = false;
    }

    public static void enableChatColor() {
        chatColor = true;
    }

    public static boolean isChatColor() {
        return chatColor;
    }
}
