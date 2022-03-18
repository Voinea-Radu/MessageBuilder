package dev.lightdream.messagebuilder;

import com.google.gson.*;

import java.lang.reflect.Type;

public class MessageBuilderDeserializer implements JsonDeserializer<MessageBuilder> {

    @Override
    public MessageBuilder deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext deserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        if (jsonObject.isJsonArray()) {
            return new MessageBuilder(jsonObject.getAsJsonArray());
        }
        return new MessageBuilder(jsonObject.getAsString());
    }
}
