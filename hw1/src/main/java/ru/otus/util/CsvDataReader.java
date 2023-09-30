package ru.otus.util;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CsvDataReader implements DataReader<List<String>> {

    private final String fileName;

    @Override
    public List<String> read() {
        return null;
    }
}
