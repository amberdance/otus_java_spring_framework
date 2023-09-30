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
        try (var resource = getClass().getClassLoader().getResourceAsStream(fileName)) {
            var data = Objects.requireNonNull(resource).readAllBytes();
            return Arrays.stream(new String(data).split(";")).toList();
        } catch (IOException e) {
            throw new RuntimeException("Cannot find given file: " + fileName);
        }
    }

}
