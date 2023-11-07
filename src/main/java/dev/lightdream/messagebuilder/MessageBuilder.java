package dev.lightdream.messagebuilder;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class MessageBuilder extends GenericMessageBuilder<String> {

    public MessageBuilder(String base) {
        super(base);
    }

    protected MessageBuilder(String base, List<Object> placeholders, List<Object> values) {
        super(base, placeholders, values);
    }

    public static void init(MessageBuilderManager.Settings settings) {
        MessageBuilderManager.init(settings);
    }

    @Override
    protected boolean equals(String o1, String o2) {
        if (o1 == null) {
            return o2 == null;
        }
        return o1.equals(o2);
    }

    @Override
    protected String convertToString() {
        return parse();
    }

    @Override
    protected String parsePlaceholder(String base, String placeholder, String value) {
        if (base == null) {
            return null;
        }
        return base.replace(placeholder, value);
    }

    @Override
    public GenericMessageBuilder<String> clone() {
        return new MessageBuilder(base, new ArrayList<>(placeholders), new ArrayList<>(values));
    }
}
