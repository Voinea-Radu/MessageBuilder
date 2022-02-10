package dev.lightdream.messagebuilder;

import dev.lightdream.libs.fasterxml.core.JsonGenerator;
import dev.lightdream.libs.fasterxml.databind.JsonSerializer;
import dev.lightdream.libs.fasterxml.databind.SerializerProvider;

import java.io.IOException;

public class MessageBuilderSerializer extends JsonSerializer<MessageBuilder> {

    @SuppressWarnings("ConstantConditions")
    @Override
    public void serialize(MessageBuilder messageBuilder, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();

        if (messageBuilder.isList()) {
            jsonGenerator.writeArrayFieldStart("text");
            for (String line : messageBuilder.getBaseList()) {
                jsonGenerator.writeString(line);
            }
            jsonGenerator.writeEndArray();
        } else {
            jsonGenerator.writeFieldName("text");
            jsonGenerator.writeString(messageBuilder.getBaseString());
        }

        jsonGenerator.writeEndObject();

    }
}
