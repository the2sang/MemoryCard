package com.memorycard.dto;

import com.memorycard.entity.MemoryCardEntity;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MemoryCardDto {

    private final Long id;
    private final String questionType;
    private final String question;
    private final String num1;
    private final String num2;
    private final String num3;
    private final String num4;
    private final String rightAnswer;
    private final Short learningCount;
    private final Short level;
    private final Short completed;

    @Builder
    public MemoryCardDto(Long id, String questionType, String question, String num1, String num2, String num3,
                         String num4, String rightAnswer, Short learningCount, Short level, Short completed) {
        this.id = id;
        this.questionType = questionType;
        this.question = question;
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;
        this.num4 = num4;
        this.rightAnswer = rightAnswer;
        this.learningCount = learningCount;
        this.level = level;
        this.completed = completed;
    }

    public MemoryCardEntity toEntity() {
        return MemoryCardEntity.builder()
                .id(id)
                .questionType(questionType)
                .question(question)
                .num1(num1)
                .num2(num2)
                .num3(num3)
                .num4(num4)
                .rightAnswer(rightAnswer)
                .learningCount(learningCount)
                .level(level)
                .completed(completed)
                .build();
    }
}
