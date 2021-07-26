import cs102.Hangman;

import java.awt.*;

public class HangmanButtonControls extends LetterButtonControls implements IHangmanView {

    private static final Font MY_FONT = new Font( Font.SERIF, Font.BOLD, 10);

    public HangmanLetterButtonControls(Hangman hangman, int rows, int coloumns)
    {
        super(hangman.getAllLetters(), rows, coloumns);
        this.setPreferredSize(new Dimension(300, 250));
        this.setFont(MY_FONT);
    }

    @Override
    public void updateView(Hangman hangmanModel) {
        if ( !hangmanModel.getUsedLetters().equals("") )
            this.setDisabled( hangmanModel.getUsedLetters() );

        if ( hangmanModel.isGameOver() )
            setEnabledAll( true );
    }

}
