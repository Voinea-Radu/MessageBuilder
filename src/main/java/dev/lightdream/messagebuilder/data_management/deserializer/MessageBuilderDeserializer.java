package dev.lightdream.messagebuilder.data_management.deserializer;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import dev.lightdream.messagebuilder.MessageBuilder;

import java.lang.reflect.Type;

public class MessageBuilderDeserializer implements JsonDeserializer<MessageBuilder> {

    @Override
    public MessageBuilder deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext deserializationContext) {
        return new MessageBuilder(jsonElement.getAsString());
    }
}
