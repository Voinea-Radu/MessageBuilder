package dev.lightdream.messagebuilder.data;

import dev.lightdream.filemanager.FileManager;

public interface DataManager<T> {

    Class<T> getClazz();

    default void register(FileManager fileManager) {
        fileManager.setGsonBuilder(fileManager.getGsonBuilder().registerTypeAdapter(getClazz(), this));
    }

}
