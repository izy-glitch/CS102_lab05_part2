import cs102.*;
import java.util.ArrayList;

public class HangmanModel extends Hangman{
    private ArrayList<IHangmanView> views;

    public HangmanModel( IHangmanSetup hangmanSetup){
        super( hangmanSetup );
        this.views = new ArrayList<IHangmanView>();
    }

    public void addView( IHangmanView hangmanView ){
        views.add( hangmanView );
    }

    public void update(){
        if ( views != null){
            for( int i = 0; i < views.size(); i++ ){
                views.get( i ).updateView(this);
            }
        }
    }

    @Override
    public int tryThis( char letter ){
        int tryThis = super.tryThis( letter );
        update();
        return tryThis;
    }
    @Override
    public void initNewGame(){
        super.initNewGame();
        update();
    }
}
