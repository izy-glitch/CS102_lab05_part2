import java.util.Scanner;
import cs102.*;

/**
 * ConsoleHangman
 *
 * @author
 * @version 1.00 2013/4/7
 */

public class ConsoleHangman
{
    public static void main( String[] args)
	{
    	Scanner scan = new Scanner( System.in );

    	System.out.println( "Start of ConsoleHangman\n");

		// VARIABLES
		HangmanModel		hangman;

		// PROGRAM CODE
		hangman = new HangmanModel( new BasicSetup() );

		System.out.println( hangman.getKnownSoFar() );

		// ToDo - allow user to repeatedly enter a letter and tryThis letter
		//		  then show game status, until gameover. Finally report win/lose.


		hangman.addView( new ConsoleHangmanView() );
		hangman.addView( new ConsoleHangmanView() );

		do {
			System.out.print("Please enter a letter: ");
			char letter = scan.next().charAt( 0 );

			int gameStatus = hangman.tryThis( letter );

			if ( gameStatus < 0 ) {
				System.out.println("You already tried this letter!");
			} else if ( gameStatus == 0 ) {
				System.out.println("Your letter isn't in the word.");
			} else {
				System.out.println("Your letter is in the word " + gameStatus + " times.");
			}

		} while ( !hangman.isGameOver() );

		System.out.println( "\nEnd of ConsoleHangman\n" );
	}

} // end of class ConsoleHangman
