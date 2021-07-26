import cs102.Hangman;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGameButtonControl extends JButton implements ActionListener, IHangmanView{

    Hangman hangman;
    public NewGameButtonControl( Hangman hangman ) {
        super("New Game");
        this.hangman = hangman;
        this.addActionListener( (ActionListener) this );
        this.setEnabled( true );
    }

    public void actionPerformed( ActionEvent event )
    {
        hangman.initNewGame();
        this.setEnabled( false );
    }

    @Override
    public void updateView( Hangman hangmanModel ) {
        if ( hangman.isGameOver() ) {
            this.setEnabled( true );
        }
    }
}
