package com.example.n1.tic_tac_toe;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

//  Steps as of now what we did for the game:
//        1) Grid Layout with all 3*3 images with dropin function as onClick
//       2) OnClick we need one by one red and yellow appearance on board. with the ActivePlayer name.
//     3) we create a memory state named gamestate during lect.
//   4) Added Andriod tag for all 3*3 images
//    5) Update the gamestate onClick with the tag number.
//        6) Add winning State to code
//      7) Add linear Vertical Layout to code with Visibility: Invisible. and many other settings (please look at .xml file)

//    Next part what we have to do:
//  1) Write code for winning condition : ( Make linear layout visible, write text in a text field for winning message )
//   2) Code for "Play Again" Button which will appear with a linear layout
//  3) After winning make all cells of the board (Inactive) means after winning, the player can't click.
// 4) Condition if match "Draw"
public class MainActivity extends AppCompatActivity {
    int Aplayer = 0;
    // 0 = player 0 RED and 1 = player 1 Yellow
    int gamestate[]= {2,2,2,2,2,2,2,2,2};
    //2 = unplayed
    int winning[][] = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    boolean gameactive = true;
    public void dropin(View view) {
        ImageView image = (ImageView) view;
        int tapped = Integer.parseInt(image.getTag().toString());
        if (gamestate[tapped] == 2 && gameactive == true) {
            gamestate[tapped] = Aplayer;
            if (Aplayer == 0) {
                image.setImageResource(R.drawable.red);
                Aplayer = 1;


            } else {
                image.setImageResource(R.drawable.yellow);
                Aplayer = 0;
            }
            for (int winningArray[]: winning) {
                if (gamestate[winningArray[0]] == gamestate[winningArray[1]] && gamestate[winningArray[1]] == gamestate[winningArray[2]] && gamestate[winningArray[0]] != 2) {
                    // winning decl
                    gameactive = false;
                    String winnername = "RED";
                    if (gamestate[winningArray[0]] == 1) {
                        winnername = "YELLOW";
                    }
                    Toast.makeText(MainActivity.this,winnername + " Player WON",Toast.LENGTH_LONG).show();
                    //TextView text = (TextView) findViewById(R.id.text);
                    // text.setText(winnername + " Player WON");
                    LinearLayout layout = (LinearLayout) findViewById(R.id.linearlayout);
                    layout.setVisibility(View.VISIBLE);
                } else {
                    boolean gameover = true;

                    for (int counterstate : gamestate) {
                        if (counterstate == 2) {
                            gameover = false;
                        }
                    }
                    if (gameover == true) {
                        //TextView text = (TextView) findViewById(R.id.text);
                        //text.setText("Its Draw");
                        Toast.makeText(MainActivity.this,"DRAW"+" !!!",Toast.LENGTH_LONG).show();
                        LinearLayout layout = (LinearLayout) findViewById(R.id.linearlayout);
                        layout.setVisibility(View.VISIBLE);
                    }

                }
            }
        }

    }

    public void playAgain(View view) {
        LinearLayout layout = (LinearLayout) findViewById(R.id.linearlayout);
        layout.setVisibility(View.INVISIBLE);
        gameactive = true;
        int Aplayer = 0; // 0 = player 0 RED and 1 = player 1 Yellow
        //gamestate= {2,2,2,2,2,2,2,2,2};
        for(int i = 0; i < gamestate.length ; i++) {

            gamestate[i] = 2;
        }
        GridLayout grid = (GridLayout) findViewById(R.id.gridlayout1);
        for (int i = 0; i<grid.getChildCount();i++) {
            ((ImageView) grid.getChildAt(i)).setImageResource(0);
        }
    }
    /*  public void playagain(View view) {
          LinearLayout layout = (LinearLayout) findViewById(R.id.linearlayout);
          layout.setVisibility(View.INVISIBLE);
          active = true;
          int Aplayer = 0;
          for(int i = 0; i < gamestate.length ; i++) {

              gamestate[i] = 2;
          }
          GridLayout grid = (GridLayout) findViewById(R.id.gridlayout1);
          for(int i = 0; i<grid.getChildCount();i++) {
              ((ImageView) grid.getChildAt(i)).setImageResource(0);

          }
      } */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}