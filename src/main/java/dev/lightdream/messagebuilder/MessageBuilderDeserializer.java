package dev.lightdream.messagebuilder;

import com.google.gson.*;

import java.lang.reflect.Type;

public class MessageBuilderDeserializer implements JsonDeserializer<MessageBuilder> {

    @Override
    public MessageBuilder deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext deserializationContext) {
        if (jsonElement.isJsonArray()) {
            return new MessageBuilder(jsonElement.getAsJsonArray());
        }
        return new MessageBuilder(jsonElement.getAsString());
    }
}
