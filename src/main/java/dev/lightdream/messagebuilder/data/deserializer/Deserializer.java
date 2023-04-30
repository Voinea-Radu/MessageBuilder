package dev.lightdream.messagebuilder.data.deserializer;

import com.google.gson.JsonDeserializer;
import dev.lightdream.messagebuilder.data.DataManager;

public interface Deserializer<T> extends JsonDeserializer<T>, DataManager<T> {

}
