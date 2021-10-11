package fr.delcey.topquiz.controller;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import fr.delcey.topquiz.R;
import fr.delcey.topquiz.model.Question;
import fr.delcey.topquiz.model.QuestionBank;


public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mTextView;
    Button mGameButton1;
    Button mGameButton2;
    Button mGameButton3;
    Button mGameButton4;
    Question mCurrentQuestion;
    QuestionBank mQuestionBank = new QuestionBank();
    private int mRemainingQuestionCount;
    private int mScore;
    public static final String BUNDLE_EXTRA_SCORE = "BUNDLE_EXTRA_SCORE";
    private boolean mEnableTouchEvents;

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return mEnableTouchEvents && super.dispatchTouchEvent(ev);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        mTextView = findViewById((R.id.game_activity_textview_question));
        mGameButton1 = findViewById(R.id.game_activity_button_1);
        mGameButton2 = findViewById(R.id.game_activity_button_2);
        mGameButton3 = findViewById(R.id.game_activity_button_3);
        mGameButton4 = findViewById(R.id.game_activity_button_4);

        mGameButton1.setOnClickListener(this);
        mGameButton2.setOnClickListener(this);
        mGameButton3.setOnClickListener(this);
        mGameButton4.setOnClickListener(this);

        mCurrentQuestion = mQuestionBank.getCurrentQuestion();
        displayQuestion (mQuestionBank.getCurrentQuestion());

        mEnableTouchEvents = true;

        mRemainingQuestionCount = 5;
        mScore = 0;
    }

    private void displayQuestion(final Question q) {
        mTextView.setText(q.getQuestion());
        mGameButton1.setText(q.getChoiceList().get(0));
        mGameButton2.setText(q.getChoiceList().get(1));
        mGameButton3.setText(q.getChoiceList().get(2));
        mGameButton4.setText(q.getChoiceList().get(3));

    }

    @Override
    public void onClick(View v) {

        int index;

        if (v == mGameButton1) {
            index = 0;
        } else if (v == mGameButton2) {
            index = 1;
        } else if (v == mGameButton3) {
            index = 2;
        } else if (v == mGameButton4) {
            index = 3;
        }else {
            throw new IllegalStateException("Unknown clicked view : " + v);
        }

        if (mQuestionBank.getCurrentQuestion().getChoiceList().get(index).equals(mQuestionBank.getCurrentQuestion().getAnswer()) ) {
            Toast.makeText(this, "correct!", Toast.LENGTH_SHORT).show();
            mScore++;
        } else {
            Toast.makeText(this, "incorrect!", Toast.LENGTH_SHORT).show();
        }

        mEnableTouchEvents = false;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mRemainingQuestionCount--;
                if (mRemainingQuestionCount > 0) {
                    mCurrentQuestion = mQuestionBank.getNextQuestion();
                    displayQuestion(mCurrentQuestion);
                } else {
                    endGame ();

                }mEnableTouchEvents = true;
            }
        },1500);

    }
    private void endGame (){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        if (mScore == 0) {
            builder.setTitle("Pathetic !");
        }else if ( mScore == 5 ) {
            builder.setTitle("Perfect !!");
        }else{
            builder.setTitle("Well done");
        }
               builder.setMessage("Your score is " + mScore)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        Intent intent = new Intent();
                        intent.putExtra(BUNDLE_EXTRA_SCORE, mScore);
                        setResult(RESULT_OK, intent);
                        finish();
                    }
                }).create()
                .show();

    }

}