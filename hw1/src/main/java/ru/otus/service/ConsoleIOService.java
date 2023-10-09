package ru.otus.service;

public class ConsoleIOService implements IOService {
    @Override
    public void printLine(String value) {
        System.out.println(value);
    }

    @Override
    public void printBlankLine() {
        System.out.println();
    }
}
