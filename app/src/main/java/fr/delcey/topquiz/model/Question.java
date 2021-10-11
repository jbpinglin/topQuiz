package fr.delcey.topquiz.model;

import androidx.annotation.VisibleForTesting;

import java.util.Collections;
import java.util.List;

public class Question {
    private final String mQuestion;
    private final List<String> mChoiceList;
    private final String mAnswer;

    public Question(String Question, List<String> ChoiceList,String Answer) {
        this.mQuestion = Question;
        this.mChoiceList = ChoiceList;
        this.mAnswer = Answer;
        Collections.shuffle(mChoiceList);
    }

    public String getQuestion() {
        return mQuestion;
    }

    public List<String> getChoiceList() {
        return mChoiceList;
    }

    public String getAnswer() {
        return mAnswer;
    }

}

