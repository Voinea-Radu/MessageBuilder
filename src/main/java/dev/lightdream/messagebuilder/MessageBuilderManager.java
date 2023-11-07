package dev.lightdream.messagebuilder;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings({"unused"})

public class MessageBuilderManager {

    private static @Getter Settings settings;

    static {
        init(new Settings());
    }

    public static void init(Settings settings) {
        MessageBuilderManager.settings = settings;
    }

    @Getter
    @Setter
    @Accessors(fluent = true)
    @NoArgsConstructor
    public static class Settings {
        private @NotNull String colorChar = "&";
        private @NotNull String colorCharReplace = "§";
        private boolean chatColor = false;

        public static Settings spigotPreset() {
            return new Settings()
                    .colorChar("&")
                    .colorCharReplace("§")
                    .chatColor(true);
        }

        public static Settings forgePreset() {
            //noinspection UnnecessaryUnicodeEscape
            return new Settings()
                    .colorChar("&")
                    .colorCharReplace("\u00a7")
                    .chatColor(true);
        }
    }

}
