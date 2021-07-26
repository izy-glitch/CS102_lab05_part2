import cs102.*;

public class ConsoleHangmanView implements IHangmanView {

    @Override
    public void updateView( Hangman hangmanModel ){
        System.out.println( hangmanModel.getKnownSoFar() );

        if ( !hangmanModel.isGameOver() ) {
            int yourTries = hangmanModel.getMaxAllowedIncorrectTries() - hangmanModel.getNumOfIncorrectTries();

            System.out.println("You have " + yourTries + " tries left");
        }
        else if ( hangmanModel.hasLost() ) {
            System.out.println("Sorry, you lost!");
        }
        else if ( hangmanModel.isGameOver() ){
            System.out.println("Congratulations, you win!");
        }
        System.out.println();

    }
}

