package ru.otus.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;


@RequiredArgsConstructor
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
public final class Question {

    private final String name;

    private final List<Answer> answers;

}
