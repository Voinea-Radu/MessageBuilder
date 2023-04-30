package dev.lightdream.messagebuilder.data.serializer;

import com.google.gson.JsonSerializer;
import dev.lightdream.messagebuilder.data.DataManager;

public interface Serializer<T> extends JsonSerializer<T>, DataManager<T> {


}
