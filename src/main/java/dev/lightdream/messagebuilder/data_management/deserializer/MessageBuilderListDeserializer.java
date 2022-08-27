package dev.lightdream.messagebuilder.data_management.deserializer;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import dev.lightdream.messagebuilder.MessageBuilderList;

import java.lang.reflect.Type;

public class MessageBuilderListDeserializer implements JsonDeserializer<MessageBuilderList> {

    @Override
    public MessageBuilderList deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext deserializationContext) {
        return new MessageBuilderList(jsonElement.getAsString());
    }
}
