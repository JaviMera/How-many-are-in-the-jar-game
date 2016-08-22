import java.io.Console;

/**
 * Created by Javier on 8/21/2016.
 */
public class Player {

    private int mGuess;
    private int mAttempts;

    public Player()
    {
        mAttempts = 1;
    }

    public void startGuessing(Console console, int numberToGuess)
    {
        do
        {
            String guessAsString = console.readLine("Guess: ");
            mGuess = Integer.parseInt(guessAsString);

            if(mGuess != numberToGuess)
            {
                mAttempts++;
            }

        }while(mGuess != numberToGuess);
    }

    public int getAttempts()
    {
        return mAttempts;
    }
}
