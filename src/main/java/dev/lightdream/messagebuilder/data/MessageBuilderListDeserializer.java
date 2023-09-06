package dev.lightdream.messagebuilder.data;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import dev.lightdream.filemanager.GsonSerializer;
import dev.lightdream.messagebuilder.MessageBuilderList;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MessageBuilderListDeserializer implements GsonSerializer<MessageBuilderList> {

    @Override
    public MessageBuilderList deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext deserializationContext) {

        JsonArray array = jsonElement.getAsJsonArray();
        List<String> list = new ArrayList<>();

        for (JsonElement element : array) {
            list.add(element.getAsString());
        }

        return new MessageBuilderList(list);
    }


    @Override
    public JsonElement serialize(MessageBuilderList src, Type typeOfSrc, JsonSerializationContext context) {
        JsonArray array = new JsonArray();

        for (String line : src.getBase()) {
            array.add(line);
        }

        return array;
    }

    @Override
    public Class<MessageBuilderList> getClazz() {
        return MessageBuilderList.class;
    }
}
