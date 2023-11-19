package dev.lightdream.messagebuilder;

import dev.lightdream.filemanager.FileManager;
import dev.lightdream.messagebuilder.data.MessageBuilderDeserializer;
import dev.lightdream.messagebuilder.data.MessageBuilderListDeserializer;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Builder(builderClassName = "Builder", toBuilder = true)
@Getter
@Setter
@Accessors(chain = true, fluent = true)
public class MessageBuilderManager {

    private static @Getter MessageBuilderManager instance;

    static {
        builder().build();
    }

    private boolean chatColor;

    public MessageBuilderManager(boolean chatColor) {
        instance = this;
        this.chatColor = chatColor;
        new MessageBuilderDeserializer().register(FileManager.instance().gsonSettings());
        new MessageBuilderListDeserializer().register(FileManager.instance().gsonSettings());
    }

    public static Builder builder() {
        return new Builder()
                .chatColor(false);
    }

    @SuppressWarnings("unused")
    public static Builder minecraftBuilder() {
        return new Builder()
                .chatColor(true);
    }
}
