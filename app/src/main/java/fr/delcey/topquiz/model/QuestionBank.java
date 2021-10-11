package fr.delcey.topquiz.model;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class QuestionBank {
    private final List<Question> mQuestionList;
    private int mQuestionIndex;


    public QuestionBank() {
        mQuestionList = generateQuestions();

    }

    public Question getCurrentQuestion() {
        return mQuestionList.get(mQuestionIndex);

    }

    public Question getNextQuestion() {
        mQuestionIndex++;
        return getCurrentQuestion();
    }

    private List<Question> generateQuestions() {
        Question question1 = new Question(
                "What does the word dinosaur mean in Greek?",
                Arrays.asList(
                        "Fearful lizard",
                        "Big thunder lizard",
                        "king lizard",
                        "Bird lizard"
                ),
                "Fearful lizard"

        );
        Question question2 = new Question(
                "Mention the name of the dinosaur, which means “lizard-tyrant”:",
                Arrays.asList(
                        "Tyrantosaurus",
                        "Tyranysaurus",
                        "Tyrannosaurus",
                        "Dinosaurus Tyranus"
                ),
                "Tyrannosaurus"
        );
        Question question3 = new Question(
                "During which era did dinosaurs dominate the world?",
                Arrays.asList (
                        "Dinosoic era",
                        "Paleozoic era",
                        "Cenozoic era",
                        "Mesozoic era"
                ),
                "Mesozoic era"
        );
        Question question4 = new Question(
                "Ichtiosaurus was an ancient reptile. Which ability did it have?",
                 Arrays.asList(
                        "Abilty to climb",
                        "Ability to swim",
                        "Ability to fly",
                        "Ability to run"
                ),
                "Ability to swim"
        );

        Question question5 = new Question(
                "During which period did dinosaurs thrive?",
                Arrays.asList(
                        "Cretaceous period",
                        "Jurassic period",
                        "Triassic period",
                        "Quartenary period"
                ),
                "Jurassic period"

        );
        Question question6 = new Question(
                "The name of which dinosaur means “triple horned”?",
                Arrays.asList(
                        "Treserracorn",
                        "Triceratops",
                        "Trescornes",
                        "Troiscornes"
                ),
                "Triceratops"
        );
        Question question7 = new Question(
                "Which dinosaur was discovered in the Antarctic?",
                Arrays.asList(
                        "Arcticausaurus",
                        "Antarticausaurus",
                        "Ankylosaurus",
                        "Mammoth"
                ),
                "Ankylosaurus"
        );
        Question question8 = new Question(
                "Pterosaurus was an ancient reptile. Which ability did it have?",
                 Arrays.asList(
                       "Ability to climb",
                       "Ability to swim",
                       "Ability to fly",
                       "Ability to run"
                ),
                "Ability to fly"

        );

       /*Question question = new Question(
                "",
                Arrays.asList(
                        "",
                        "",
                        "",
                        ""
                ),

        );
        */

        List<Question> list = Arrays.asList(question1, question2, question3, question4,question5,question6,question7,question8);
        Collections.shuffle(list);
        return list;

    }

}
