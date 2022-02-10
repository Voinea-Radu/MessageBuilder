package dev.lightdream.messagebuilder;

import dev.lightdream.filemanager.FileManager;
import dev.lightdream.libs.fasterxml.databind.module.SimpleModule;

@SuppressWarnings("unused")
public class MessageBuilderManager {

    public static void registerFileManagerModule(FileManager fileManager) {
        SimpleModule messageBuilderModule = new SimpleModule();
        messageBuilderModule.addSerializer(MessageBuilder.class, new MessageBuilderSerializer());
        messageBuilderModule.addDeserializer(MessageBuilder.class, new MessageBuilderDeserializer());
        fileManager.registerModule(messageBuilderModule);
    }
}
