package dev.lightdream.messagebuilder;

import com.google.gson.*;

import java.lang.reflect.Type;

public class MessageBuilderSerializer implements JsonSerializer<MessageBuilder> {

    @SuppressWarnings("ConstantConditions")
    @Override
    public JsonElement serialize(MessageBuilder messageBuilder, Type type, JsonSerializationContext jsonSerializationContext) {

        JsonObject jsonObject = new JsonObject();

        if (messageBuilder.isList()) {
            JsonArray jsonArray = new JsonArray();

            messageBuilder.getBaseList().forEach(jsonArray::add);

            jsonObject.add("text", jsonArray);

        } else {
            jsonObject.addProperty("text", messageBuilder.getBaseString());
        }

        return jsonObject;
    }
}
