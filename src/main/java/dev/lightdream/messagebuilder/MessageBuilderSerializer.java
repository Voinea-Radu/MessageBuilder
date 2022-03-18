package dev.lightdream.messagebuilder;

import com.google.gson.*;

import java.lang.reflect.Type;

public class MessageBuilderSerializer implements JsonSerializer<MessageBuilder> {

    @SuppressWarnings("ConstantConditions")
    @Override
    public JsonElement serialize(MessageBuilder messageBuilder, Type type, JsonSerializationContext jsonSerializationContext) {
        if (messageBuilder.isList()) {
            JsonArray jsonArray = new JsonArray();

            messageBuilder.getBaseList().forEach(jsonArray::add);
            return jsonArray;
        }
        return new JsonPrimitive(messageBuilder.getBaseString());
    }
}
