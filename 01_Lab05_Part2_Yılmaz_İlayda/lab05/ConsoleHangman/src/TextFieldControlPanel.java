import cs102.Hangman;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextFieldControlPanel extends JPanel implements ActionListener {

    Hangman hangman;
    JTextField textField;

    public TextFieldControlPanel(Hangman hangman) {
        super();
        this.hangman = hangman;
        textField = new JTextField(15);
        this.add( textField );
        textField.addActionListener( this );
    }

    public void actionPerformed( ActionEvent event ) {
        String text = textField.getText();

        for (int i = 0; i < text.length(); i++) {
            hangman.tryThis( text.charAt( i ) );
        }

        textField.setText("");
    }

}
