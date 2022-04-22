package dev.lightdream.messagebuilder;

import dev.lightdream.logger.Debugger;
import dev.lightdream.logger.Logger;
import org.jetbrains.annotations.Nullable;

import java.util.*;

@SuppressWarnings("unused")
public class MessageBuilder {

    private static boolean chatColor = true;
    private static boolean managerInitialized = false;
    private boolean cloned = false;
    private String base;
    private List<String> placeholders = new ArrayList<>();
    private List<String> values = new ArrayList<>();

    public MessageBuilder(String base) {
        this.base = base;
    }

    @SuppressWarnings("CopyConstructorMissesField")
    public MessageBuilder(MessageBuilder base) {
        this.base = base.getBase();
    }

    @SuppressWarnings("StringConcatenationInLoop")
    public MessageBuilder(String separator, String... base) {
        this.base = "";
        for (String s : base) {
            this.base += s;
            this.base += separator;
        }
    }

    public MessageBuilder(String... base) {
        this(" ", base);
    }

    @SuppressWarnings("StringConcatenationInLoop")
    public MessageBuilder(String separator, MessageBuilder... base) {
        this.base = "";
        for (MessageBuilder s : base) {
            this.base += s.getBase();
            this.base += separator;
        }
    }

    public MessageBuilder(MessageBuilder... base) {
        this(" ", base);
    }

    private MessageBuilder(String base, List<String> placeholders, List<String> values) {
        this.base = base;
        this.placeholders = placeholders;
        this.values = values;
    }

    public static void setChatColor(boolean chatColor) {
        MessageBuilder.chatColor = chatColor;
    }

    protected static void init() {
        managerInitialized = true;
    }

    @Deprecated
    public MessageBuilder addPlaceholders(HashMap<String, String> placeholders) {
        MessageBuilder working = this;
        for (String placeholder : placeholders.keySet()) {
            String value = placeholders.get(placeholder);
            working = working.addPlaceholders(placeholder, value);
        }
        return working;
    }

    public MessageBuilder parse(HashMap<String, String> placeholders) {
        MessageBuilder working = this;
        for (String placeholder : placeholders.keySet()) {
            String value = placeholders.get(placeholder);
            working = working.parse(placeholder, value);
        }
        return working;
    }

    @Deprecated
    public MessageBuilder addPlaceholders(String placeholder, String value) {
        MessageBuilder working = this;
        if (!cloned) {
            working = clone();
        }
        working.placeholders.add(placeholder);
        working.values.add(value);
        return working;
    }

    public MessageBuilder parse(String placeholder, String value) {
        MessageBuilder working = this;
        if (!cloned) {
            working = clone();
        }
        working.placeholders.add(placeholder);
        working.values.add(value);
        return working;
    }

    public String parse() {
        if (!MessageBuilder.managerInitialized) {
            Logger.warn("MessageBuilder manager has not been initialized!");
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

    @SuppressWarnings("MethodDoesntCallSuperMethod")
    public MessageBuilder clone() {
        MessageBuilder output = new MessageBuilder(this.base, new ArrayList<>(this.placeholders), new ArrayList<>(this.values));
        output.cloned = true;
        return output;
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
        return Objects.hash(cloned, getBase(), placeholders, values);
    }

    @SuppressWarnings("unused")
    public MessageBuilder parseAndGet() {
        parse();
        return this;
    }

    @SuppressWarnings("unused")
    public List<String> split(String separator) {
        return new ArrayList<>(Arrays.asList(base.split(separator)));
    }

    @SuppressWarnings("unused")
    public @Nullable String getBase() {
        return this.base;
    }

    @SuppressWarnings("UnusedReturnValue")
    public MessageBuilder setBase(String base) {
        this.base = base;
        return this;
    }

    @Override
    public String toString() {
        return parse();
    }

    public String toHexString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }


}
