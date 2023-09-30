package ru.otus.util;

import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class CsvDataReader implements DataReader<List<String[]>> {

    private final String fileName;


    @Override
    public List<String[]> read() {
        try (InputStream resource = getClass().getClassLoader().getResourceAsStream(fileName)) {
            byte[] data = Objects.requireNonNull(resource).readAllBytes();

            return Arrays.stream(new String(data).split("\n"))
                    .map(s -> s.split(";"))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Cannot find given file: " + fileName);
        }
    }

}
