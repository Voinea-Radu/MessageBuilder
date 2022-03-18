package dev.lightdream.messagebuilder;

import com.google.gson.JsonArray;
import dev.lightdream.logger.Logger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

@SuppressWarnings("unused")
public class MessageBuilder {

    public static boolean chatColor = true;
    private static boolean managerInitialized = false;
    private String base;
    private List<String> baseList;
    private List<String> placeholders = new ArrayList<>();
    private List<String> values = new ArrayList<>();

    public MessageBuilder(String base) {
        this.base = base;
    }

    @SuppressWarnings("unused")
    public MessageBuilder(List<String> baseList) {
        this.baseList = baseList;
    }

    public MessageBuilder(JsonArray baseList) {
        this.baseList = new ArrayList<>();
        baseList.forEach(line -> this.baseList.add(line.getAsString()));
    }

    private MessageBuilder(String base, List<String> placeholders, List<String> values) {
        this.base = base;
        this.placeholders = placeholders;
        this.values = values;
    }

    public static void setChatColor(boolean chatColor) {
        MessageBuilder.chatColor = chatColor;
    }

    public static void init() {
        managerInitialized = true;
    }

    @SuppressWarnings("unused")
    public MessageBuilder addPlaceholders(String... placeholders) {
        this.placeholders.addAll(Arrays.asList(placeholders));
        return this;
    }

    public MessageBuilder addPlaceholders(HashMap<String, String> placeholders) {
        placeholders.forEach((placeholder, value) -> {
            this.placeholders.add(placeholder);
            this.values.add(value);
        });

        return this;
    }

    @SuppressWarnings("unused")
    public MessageBuilder addValues(String... values) {
        this.values.addAll(Arrays.asList(values));
        return this;
    }

    public MessageBuilder addPlaceholders(String placeholder, String value) {
        this.placeholders.add(placeholder);
        this.values.add(value);
        return this;
    }

    public boolean isList() {
        return baseList != null;
    }

    public Object parse() {
        if (!MessageBuilder.managerInitialized) {
            Logger.warn("MessageBuilder manager has not been initialized!");
        }
        if (isList()) {
            List<String> parsedList = new ArrayList<>();

            baseList.forEach(line -> {
                String parsed = line;

                for (int i = 0; i < Math.min(placeholders.size(), values.size()); i++) {
                    parsed = parsed.replace("%" + placeholders.get(i) + "%", values.get(i));
                }

                if (chatColor) {
                    parsed = parsed.replace("&", "§");
                }

                parsedList.add(parsed);
            });

            this.baseList = parsedList;
            return parsedList;
        }
        String parsed = base;

        for (int i = 0; i < Math.min(placeholders.size(), values.size()); i++) {
            parsed = parsed.replace("%" + placeholders.get(i) + "%", values.get(i));
        }

        if (chatColor) {
            parsed = parsed.replace("&", "§");
        }

        this.base = parsed;
        return parsed;
    }

    public Object getBase() {
        return isList() ? baseList : base;
    }

    @SuppressWarnings("UnusedReturnValue")
    public MessageBuilder changeBase(String base) {
        this.base = base;
        this.baseList = null;
        return this;
    }

    @SuppressWarnings("unchecked")
    public MessageBuilder changeBase(Object base) {
        if (base instanceof String) {
            return changeBase((String) base);
        } else if (base instanceof List) {
            return changeBase((List<String>) base);
        }
        return this;
    }

    @SuppressWarnings("unused")
    public MessageBuilder changeBase(List<String> baseList) {
        this.baseList = baseList;
        this.base = null;
        return this;
    }

    @SuppressWarnings("MethodDoesntCallSuperMethod")
    public MessageBuilder clone() {
        return new MessageBuilder(this.base, this.placeholders, this.values);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageBuilder that = (MessageBuilder) o;
        return Objects.equals(base, that.base);
    }

    @Override
    public int hashCode() {
        return Objects.hash(base);
    }

    @SuppressWarnings("unused")
    public MessageBuilder parseAndGet() {
        parse();
        return this;
    }

    @SuppressWarnings("unused")
    public List<String> split(String separator) {
        List<String> parts = new ArrayList<>();

        if (isList()) {
            baseList.forEach(line -> parts.addAll(Arrays.asList(line.split(separator))));

            return parts;
        }

        parts.addAll(Arrays.asList(base.split(separator)));
        return parts;
    }

    @SuppressWarnings("unused")
    public @Nullable String getBaseString() {
        if (isList()) {
            return null;
        }
        return (String) getBase();
    }

    @SuppressWarnings({"unchecked", "unused"})
    public @Nullable List<String> getBaseList() {
        if (isList()) {
            return (List<String>) getBase();
        }
        return null;
    }

    public @NotNull String parseString() {
        if (isList()) {
            StringBuilder output = new StringBuilder();
            for (String s : parseStringList()) {
                output.append(s).append("\n");
            }
            return output.toString();
        }
        return (String) parse();
    }

    @SuppressWarnings({"unchecked", "unused"})
    public @NotNull List<String> parseStringList() {
        if (isList()) {
            return (List<String>) parse();
        }
        return Collections.singletonList((String) parse());
    }
}
