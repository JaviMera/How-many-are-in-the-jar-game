import java.io.Console;

/**
 * Created by Javier on 8/21/2016.
 */
public class Player {

    private int mNumberToGuess;
    private int mGuess;
    private int mAttempts;

    public Player(int numberToGuess)
    {
        mNumberToGuess = numberToGuess;
        mGuess = 0;
        mAttempts = 1;
    }

    public void setGuess(int guess)
    {
        mGuess = guess;
    }

    public boolean isGuessCorrect()
    {
        if(mGuess != mNumberToGuess)
        {
            mAttempts++;
            return false;
        }

        return true;
    }

    public int getAttempts()
    {
        return mAttempts;
    }
}
