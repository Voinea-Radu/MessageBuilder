package dev.lightdream.messagebuilder.data_management.serializer;

import com.google.gson.JsonSerializer;
import dev.lightdream.messagebuilder.data_management.DataManager;

public interface Serializer<T> extends JsonSerializer<T>, DataManager<T> {


}
