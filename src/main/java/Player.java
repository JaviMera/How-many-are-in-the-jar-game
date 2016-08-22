import java.io.Console;

/**
 * Created by Javier on 8/21/2016.
 */
public class Player {

    private int mGuess;

    public Player(){}

    public void startGuessing(Console console, int numberToGuess)
    {
        do
        {
            String guessAsString = console.readLine("Guess: ");
            mGuess = Integer.parseInt(guessAsString);

        }while(mGuess != numberToGuess);
    }
}
