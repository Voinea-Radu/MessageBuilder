package dev.lightdream.messagebuilder.data;

import dev.lightdream.filemanager.FileManager;

public interface DataManager<T> {

    Class<T> getClazz();

    default void register() {
        if(FileManager.get()==null){
            return;
        }

        FileManager
                .get()
                .setGsonBuilder(
                        FileManager
                                .get()
                                .getGsonBuilder()
                                .registerTypeAdapter(getClazz(), this)
                );
    }

}
