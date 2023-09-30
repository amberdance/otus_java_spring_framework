package ru.otus.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;


@RequiredArgsConstructor
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
public final class Question {

    private final String name;

}
