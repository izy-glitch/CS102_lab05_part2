import cs102.Hangman;

import javax.swing.*;
import java.awt.*;

public class LabelsHangmanView extends JPanel implements IHangmanView{

    JLabel tryLeft;
    JLabel secretWord;
    JLabel usedLetters;
    JPanel panel;

    private static final Font myFont = new Font( Font.SERIF, Font.BOLD, 30);

    public LabelsHangmanView() {
        super();
        this.setPreferredSize( new Dimension( 500,250 ) );

        this.tryLeft = new JLabel("" );
        this.secretWord = new JLabel("" );
        this.usedLetters = new JLabel("" );
        this.panel = new JPanel();

        tryLeft.setFont( myFont );
        secretWord.setFont( myFont );
        usedLetters.setFont( myFont );

        this.setLayout( new BoxLayout(this, BoxLayout.Y_AXIS) );
        this.add( tryLeft );
        this.add( secretWord );
        this.add( usedLetters );

        this.setBackground(Color.gray);
    }


    @Override
    public void updateView( Hangman hangmanModel ) {
        if ( !hangmanModel.isGameOver() ) {
            secretWord.setText( hangmanModel.getKnownSoFar() );
            tryLeft.setText( "Tries left: " + ( hangmanModel.getMaxAllowedIncorrectTries() -
                    hangmanModel.getNumOfIncorrectTries() ) );
            usedLetters.setText("Used letters: " + hangmanModel.getUsedLetters());

        }
        else {
            if ( hangmanModel.hasLost() ){
                secretWord.setText( "Sorry!" );
                tryLeft.setText( "You lost!" );
                usedLetters.setText("Letters used: " + hangmanModel.getUsedLetters());
            }
            else{
                secretWord.setText("Congratulations, you win!");
                tryLeft.setText("Your tried " + hangmanModel.getNumOfIncorrectTries() + " many times.");
                usedLetters.setText(" Letters used: " + hangmanModel.getUsedLetters());
            }
        }
    }
}
