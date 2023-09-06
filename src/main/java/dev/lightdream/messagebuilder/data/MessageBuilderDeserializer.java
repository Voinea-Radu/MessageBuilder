package dev.lightdream.messagebuilder.data;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import dev.lightdream.filemanager.GsonSerializer;
import dev.lightdream.messagebuilder.MessageBuilder;

import java.lang.reflect.Type;

public class MessageBuilderDeserializer implements GsonSerializer<MessageBuilder> {

    @Override
    public MessageBuilder deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext deserializationContext) {
        return new MessageBuilder(jsonElement.getAsString());
    }


    @Override
    public JsonElement serialize(MessageBuilder src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(src.getBase());
    }

    @Override
    public Class<MessageBuilder> getClazz() {
        return MessageBuilder.class;
    }

}
