package dev.lightdream.messagebuilder.data_management.deserializer;

import com.google.gson.JsonDeserializer;
import dev.lightdream.messagebuilder.data_management.DataManager;

public interface Deserializer<T> extends JsonDeserializer<T>, DataManager<T> {

}
