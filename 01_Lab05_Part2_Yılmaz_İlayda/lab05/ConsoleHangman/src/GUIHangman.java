import java.awt.*;
import cs102.*;

/**
 * GUIHangman - GUI based MVC test for cs102 Hangman & IHangmanSetup
 *
 * @author David
 * @version 1.00 2013/4/7
 */

public class GUIHangman
{
    public GUIHangman()
    {
        System.out.println( "Start of GUIHangman\n");

        HangmanModel		hangman;
        IHangmanSetup		MySetup;
        ConsoleHangmanView	consoleHangView;
        NewGameButtonControl newGame;
        TextFieldControlPanel textPanelControl;
        LabelsHangmanView labelsHangView;
        GallowsHangmanView gallowsHangView;
        HangmanButtonControls hangButControls;

        MySetup = new MySetup();
        hangman = new HangmanModel( MySetup );

        consoleHangView = new ConsoleHangmanView();
        gallowsHangView = new GallowsHangmanView( hangman );
        textPanelControl = new TextFieldControlPanel( hangman );
        newGame = new NewGameButtonControl( hangman );
        labelsHangView = new LabelsHangmanView();
        hangButControls = new LetterButtonControls( hangman, 13, 2 );
        hangButControls.addActionListener( new HangmanLetterButtonsController( hangman ) );



        hangman.addView( consoleHangView );
        hangman.addView( newGame );
        hangman.addView( labelsHangView );
        hangman.addView( gallowsHangView );
        hangman.addView( hangButControls );


        new SimpleJFrame( "GUIHangman", 	// title
                gallowsHangView,			// center
                textPanelControl, newGame,		// north, south
                hangButControls, labelsHangView );	// east, west

        // this is an infinite loop reading from the console... not clever!
        ConsoleControl.controlFor( hangman);
    }

    public static void main( String[] args)
    {
        GUIHangman guiHangman = new GUIHangman();

//		// This is the approved way to initialise GUIs
//		// but won't work with the ConsoleControl as is!
//		// --------------------------------------------
//		SwingUtilities.invokeLater(
//			new Runnable() {
//			    public void run() {
//	        		new GUIHangman();
//	        		new GUIHangman();
//	    		}
//			});
    }

} // end of class GUIHangman
