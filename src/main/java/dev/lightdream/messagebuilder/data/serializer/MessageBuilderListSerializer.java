package dev.lightdream.messagebuilder.data.serializer;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import dev.lightdream.messagebuilder.MessageBuilderList;

import java.lang.reflect.Type;

public class MessageBuilderListSerializer implements Serializer<MessageBuilderList> {

    @Override
    public JsonElement serialize(MessageBuilderList messageBuilder, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonArray array = new JsonArray();

        for (String line : messageBuilder.getBase()) {
            array.add(line);
        }

        return array;
    }

    @Override
    public Class<MessageBuilderList> getClazz() {
        return MessageBuilderList.class;
    }
}
