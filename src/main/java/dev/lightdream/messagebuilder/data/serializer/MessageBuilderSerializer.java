package dev.lightdream.messagebuilder.data.serializer;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import dev.lightdream.messagebuilder.MessageBuilder;

import java.lang.reflect.Type;

public class MessageBuilderSerializer implements Serializer<MessageBuilder> {

    @SuppressWarnings("ConstantConditions")
    @Override
    public JsonElement serialize(MessageBuilder messageBuilder, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(messageBuilder.getBase());
    }


    @Override
    public Class<MessageBuilder> getClazz() {
        return MessageBuilder.class;
    }
}
