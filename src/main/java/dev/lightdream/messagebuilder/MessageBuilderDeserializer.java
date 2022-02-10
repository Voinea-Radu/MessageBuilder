package dev.lightdream.messagebuilder;

import dev.lightdream.libs.fasterxml.core.JsonParser;
import dev.lightdream.libs.fasterxml.databind.DeserializationContext;
import dev.lightdream.libs.fasterxml.databind.JsonDeserializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class MessageBuilderDeserializer extends JsonDeserializer<MessageBuilder> {
    @SuppressWarnings("unchecked")
    @Override
    public MessageBuilder deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        LinkedHashMap<String, Object> obj = (LinkedHashMap<String, Object>) jsonParser.readValueAs(Object.class);

        if (obj.get("text") instanceof ArrayList) {
            return new MessageBuilder((ArrayList<String>) obj.get("text"));
        } else if (obj.get("text") instanceof String) {
            return new MessageBuilder((String) obj.get("text"));
        } else {
            return null;
        }
    }
}
