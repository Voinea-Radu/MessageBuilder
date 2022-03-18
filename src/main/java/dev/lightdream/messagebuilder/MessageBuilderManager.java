package dev.lightdream.messagebuilder;

import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;
import dev.lightdream.filemanager.FileManager;
import dev.lightdream.filemanager.FileManagerMain;

@SuppressWarnings("unused")
public class MessageBuilderManager {

    @SuppressWarnings({"unused", "StringConcatenationInLoop"})
    public static String getVersion(int tabs) {
        String output = "MessageBuilder 2.0.3\n";

        String prepend = "";

        for (int i = 0; i < tabs; ++i) {
            prepend += "    ";
        }

        output = output + prepend + "    -> " + FileManagerMain.getVersion(tabs + 1);
        return output;
    }

    public static void registerFileManagerModule(FileManager fileManager) {
        JsonSerializer<MessageBuilder> serializer = new MessageBuilderSerializer();
        JsonDeserializer<MessageBuilder> deserializer = new MessageBuilderDeserializer();

        fileManager.setGsonBuilder(
                fileManager.getGsonBuilder()
                        .registerTypeAdapter(MessageBuilder.class, deserializer)
                        .registerTypeAdapter(MessageBuilder.class, serializer)
        );

        MessageBuilder.init();
    }
}
