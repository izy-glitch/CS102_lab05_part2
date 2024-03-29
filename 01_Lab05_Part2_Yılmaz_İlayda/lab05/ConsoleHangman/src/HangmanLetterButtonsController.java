import java.awt.event.*;
import cs102.*;
import javax.swing.*;


public class HangmanLetterButtonsController implements ActionListener {

    private Hangman hangman;

    public HangmanLetterButtonsController(Hangman hangman) {
        this.hangman = hangman;
    }

    public void actionPerformed( ActionEvent event ) {
        JButton button = (JButton) event.getSource();
        char ch = button.getText().charAt( 0 );
        hangman.tryThis( ch );
    }

} // end of class HangmanLetterButtonsController
