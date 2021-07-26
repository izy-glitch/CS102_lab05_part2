import cs102.Hangman;

import javax.swing.*;
import java.awt.*;

public class GallowsHangmanView extends JPanel implements IHangmanView{

    private Hangman hangman;
    private String secretWord;
    private String usedLetters;
    private String tryNo;

    private static final Font myFont = new Font( Font.SERIF, Font.BOLD, 30);

    public GallowsHangmanView( Hangman hangman ){
        super();
        this.hangman = hangman;
        this.setBackground( Color.cyan );
        secretWord = "";
        tryNo = "";
        usedLetters = "";

    }

    @Override
    public void updateView( Hangman hangmanModel ) {
        if ( !hangmanModel.isGameOver() ) {
            secretWord = hangmanModel.getKnownSoFar();
            tryNo = "Tries left: " + ( hangmanModel.getMaxAllowedIncorrectTries() -
                    hangmanModel.getNumOfIncorrectTries() );
            usedLetters = "Used letters: " + hangmanModel.getUsedLetters();

        }
        else {
            if ( hangmanModel.hasLost() ){
                secretWord = "Sorry!";
                tryNo = "You lost!";
                usedLetters = "Letters used: " + hangmanModel.getUsedLetters();
            }
            else{
                secretWord = "Congratulations, you win!";
                tryNo = "Your tried " + hangmanModel.getNumOfIncorrectTries() + " many times.";
                usedLetters = " Letters used: " + hangmanModel.getUsedLetters();
            }
        }
        repaint();
    }


    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent( g );

        if ( hangman.getNumOfIncorrectTries() == 1 ){
            g.drawOval( 162, 150, 50, 50 );
        }
        else if ( hangman.getNumOfIncorrectTries() == 2 ){
            g.drawOval( 162, 150, 50, 50 );
            g.drawLine( 188, 200, 188, 275);

        }
        else if ( hangman.getNumOfIncorrectTries() == 3 ){
            g.drawOval( 162, 150, 50, 50 );
            g.drawLine( 188, 200, 188, 275);
            g.drawLine( 148, 235, 188, 215);
        }
        else if ( hangman.getNumOfIncorrectTries() == 4 ){
            g.drawOval( 162, 150, 50, 50 );
            g.drawLine( 188, 200, 188, 275);
            g.drawLine( 148, 235, 188, 215);
            g.drawLine( 188, 215, 228, 235);
        }
        else if ( hangman.getNumOfIncorrectTries() == 5 ){
            g.drawOval( 162, 150, 50, 50 );
            g.drawLine( 188, 200, 188, 275);
            g.drawLine( 148, 235, 188, 215);
            g.drawLine( 188, 215, 228, 235);
            g.drawLine( 188, 275, 228, 335);
        }
        else if ( hangman.getNumOfIncorrectTries() == 6 ){
            g.drawOval( 162, 150, 50, 50 );
            g.drawLine( 188, 200, 188, 275);
            g.drawLine( 148, 235, 188, 215);
            g.drawLine( 188, 215, 228, 235);
            g.drawLine( 188, 275, 228, 335);
            g.drawLine( 148, 335, 188, 275);
        }
    }
}

