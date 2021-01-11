package e.owner.caps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CapsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.caps_layout);
        ask();
    }
    private Game game;
    private String question;
    private String answer;
    private int score = 0;
    private int qNum = 1;

    public void ask()
    {
        this.game = new Game();
        String[] qAndA = game.qa().split("\n");
        this.question = qAndA[0];
        this.answer = qAndA[1];

        ((TextView) findViewById(R.id.question)).setText(this.question);
        ((TextView) findViewById(R.id.qNum)).setText("Q# " + this.qNum);
    }

    public void onDone(View v)
    {
        if (this.qNum == 10)
        {
            finish();
        }
        else {

            String userA = ((EditText) findViewById(R.id.answer)).getText().toString().toUpperCase();
            if(userA.equalsIgnoreCase(this.answer))
            {
                this.score++;

                String s = ((TextView) findViewById(R.id.log)).getText().toString();
                String s2 = s + "Q# " + this.qNum + ": " + this.question + "\n Your answer: " + userA + "\n" + "Correct Answer: " + this.answer + "\n \n";
                ((TextView) findViewById(R.id.log)).setText(s2);

            }
            else {
                ask();
                String s = ((TextView) findViewById(R.id.log)).getText().toString();
                String s2 = s + "Q# " + this.qNum + ": "
                        + this.question + "\n Your answer: " + userA + "\n" + "Correct Answer: " + this.answer + "\n \n";
                ((TextView) findViewById(R.id.log)).setText(s2);
            }

            this.qNum++;
            if (this.qNum == 10)
            {
                ((TextView) findViewById(R.id.qNum)).setText("Game Over");
                ((TextView) findViewById(R.id.score)).setText("SCORE = " + this.score);
            }
            else {
                ((TextView) findViewById(R.id.score)).setText("SCORE = " + this.score);
                ask();
            }
        }


    }
}

