package dev.lightdream.messagebuilder;

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
