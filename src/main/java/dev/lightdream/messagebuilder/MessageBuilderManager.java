package dev.lightdream.messagebuilder;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Builder(builderClassName = "_Builder", toBuilder = true)
@Getter
@Setter
@Accessors(chain = true, fluent = true)
public class MessageBuilderManager {

    private static @Getter MessageBuilderManager instance;

    static {
        builder().build();
    }

    @lombok.Builder.Default
    private boolean chatColor = false;

    public static Builder builder() {
        return new Builder();
    }

    @SuppressWarnings("unused")
    public static Builder minecraftBuilder() {
        return (Builder) new Builder()
                .chatColor(true);
    }

    public MessageBuilderManager init() {
        instance = this;
        return this;
    }

    public static class Builder extends _Builder {
        @Override
        public MessageBuilderManager build() {
            return super.build().init();
        }
    }

}
