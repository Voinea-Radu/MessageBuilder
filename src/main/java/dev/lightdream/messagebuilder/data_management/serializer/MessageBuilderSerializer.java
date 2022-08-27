package dev.lightdream.messagebuilder.data_management.serializer;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import dev.lightdream.messagebuilder.MessageBuilder;

import java.lang.reflect.Type;

public class MessageBuilderSerializer implements JsonSerializer<MessageBuilder> {

    @SuppressWarnings("ConstantConditions")
    @Override
    public JsonElement serialize(MessageBuilder messageBuilder, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(messageBuilder.getBase());
    }
}
