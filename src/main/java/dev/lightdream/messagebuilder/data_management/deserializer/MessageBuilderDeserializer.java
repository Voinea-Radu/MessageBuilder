package dev.lightdream.messagebuilder.data_management.deserializer;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import dev.lightdream.messagebuilder.MessageBuilder;

import java.lang.reflect.Type;

public class MessageBuilderDeserializer implements Deserializer<MessageBuilder> {

    @Override
    public MessageBuilder deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext deserializationContext) {
        return new MessageBuilder(jsonElement.getAsString());
    }

    @Override
    public Class<MessageBuilder> getClazz() {
        return MessageBuilder.class;
    }
}
