package ru.otus.util;

import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
public class CsvDataReader implements DataReader<List<String>> {

    private final String fileName;


    @Override
    public List<String> read() {
        var contents = getFileContents();
        return Arrays.stream(contents.split(";")).toList();
    }

    private String getFileContents() {
        try (var resource = getClass().getClassLoader().getResourceAsStream(fileName)) {
            return new String(Objects.requireNonNull(resource).readAllBytes());
        } catch (IOException e) {
            throw new RuntimeException("Cannot find given file: " + fileName);
        }
    }
}
