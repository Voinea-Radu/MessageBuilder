package dev.lightdream.messagebuilder;

import com.google.gson.*;

import java.lang.reflect.Type;

public class MessageBuilderSerializer implements JsonSerializer<MessageBuilder> {

    @SuppressWarnings("ConstantConditions")
    @Override
    public JsonElement serialize(MessageBuilder messageBuilder, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(messageBuilder.getBase());
    }
}
