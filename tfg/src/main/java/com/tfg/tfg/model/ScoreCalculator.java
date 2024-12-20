package com.tfg.tfg.model;

import com.tfg.tfg.model.enums.AnswerPoints;
import com.tfg.tfg.model.enums.Option;

public class ScoreCalculator {
    private double totalScore = 0.0;

    public double calculateScore(Question question, Option selectedOption) {
        double score;
        if (selectedOption == null) {
            score = AnswerPoints.UNANSWERED.getPoints();
        } else if (question.checkAnswer(selectedOption)) {
            score = AnswerPoints.CORRECT.getPoints();
        } else {
            score = AnswerPoints.WRONG.getPoints();
        }
        totalScore += score;
        return score;
    }

    public double getTotalScore() {
        return totalScore;
    }
}
