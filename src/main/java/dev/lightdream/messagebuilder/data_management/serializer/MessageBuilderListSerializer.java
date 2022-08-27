package dev.lightdream.messagebuilder.data_management.serializer;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import dev.lightdream.messagebuilder.MessageBuilderList;

import java.lang.reflect.Type;

public class MessageBuilderListSerializer implements JsonSerializer<MessageBuilderList> {

    @Override
    public JsonElement serialize(MessageBuilderList messageBuilder, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(messageBuilder.getAsStorageString());
    }
}
