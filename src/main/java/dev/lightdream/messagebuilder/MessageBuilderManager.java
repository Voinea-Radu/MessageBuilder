package dev.lightdream.messagebuilder;

import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;
import dev.lightdream.filemanager.FileManager;

@SuppressWarnings("unused")
public class MessageBuilderManager {

    public static void init(FileManager fileManager) {
        JsonSerializer<MessageBuilder> serializer = new MessageBuilderSerializer();
        JsonDeserializer<MessageBuilder> deserializer = new MessageBuilderDeserializer();

        fileManager.setGsonBuilder(
                fileManager.getGsonBuilder()
                        .registerTypeAdapter(MessageBuilder.class, deserializer)
                        .registerTypeAdapter(MessageBuilder.class, serializer)
        );
        fileManager.reload();

        MessageBuilder.init();
    }
}
