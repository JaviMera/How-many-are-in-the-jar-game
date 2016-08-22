import java.io.Console;

/**
 * Created by Javier on 8/21/2016.
 */
public class Player {

    private int mGuess;
    private int mAttempts;

    public Player()
    {
        mGuess = 0;
        mAttempts = 1;
    }

    public void setGuess(int guess)
    {
        mGuess = guess;
    }

    public boolean isGuessCorrect(int numberToGuess)
    {
        return mGuess == numberToGuess;
    }

    public int getAttempts()
    {
        return mAttempts;
    }

    public boolean isGuessTooHigh(int numberToGuess) {
        return mGuess > numberToGuess;
    }

    public boolean isGuessTooLow(int numberToGuess)
    {
        return mGuess < numberToGuess;
    }

    public void compareGuess(int numberToGuess) {

        if(mGuess != numberToGuess)
        {
            mAttempts++;
        }
    }
}
