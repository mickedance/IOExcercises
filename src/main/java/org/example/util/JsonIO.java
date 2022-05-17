package org.example.util;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonIO {
    public ObjectMapper objectMapper;

    public JsonIO() {
        objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        objectMapper.registerModule(new JavaTimeModule());
    }

    public <T> void toJson(File file, List<T> list) throws IOException {
        if (!file.exists())
            file.createNewFile();
        if (list != null && objectMapper != null)
            objectMapper.writeValue(file, list);
    }

    public <T> List<T> toList(File file) throws IOException {
        if (!file.exists()) file.createNewFile();
        List<T> list = new ArrayList<>();

        return objectMapper.readValue(file, new TypeReference<List<T>>() {});

    }
}
