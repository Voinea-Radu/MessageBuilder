package dev.lightdream.messagebuilder;

import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;
import dev.lightdream.filemanager.FileManager;
import dev.lightdream.filemanager.FileManagerMain;

@SuppressWarnings("unused")
public class MessageBuilderManager {

    @SuppressWarnings("unused")
    static String getVersion() {
        return "MessageBuilder " + MessageBuilder.class.getPackage().getImplementationVersion() +
                "    -> " + FileManagerMain.getVersion();
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
