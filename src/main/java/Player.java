import java.io.Console;

/**
 * Created by Javier on 8/21/2016.
 */
public class Player {

    private int mMaxItemAmount;
    private int mNumberToGuess;
    private int mGuess;
    private int mAttempts;

    public Player(int maxItemAmount, int numberToGuess)
    {
        mMaxItemAmount = maxItemAmount;
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
        return mGuess == mNumberToGuess;
    }

    public int getAttempts()
    {
        return mAttempts;
    }

    public boolean isGuessTooHigh() {
        return mGuess > mNumberToGuess;
    }

    public boolean isGuessTooLow()
    {
        return mGuess < mNumberToGuess;
    }

    public void compareGuess() {

        if(mGuess != mNumberToGuess)
        {
            mAttempts++;
        }
    }

    public int getRemainingAttempts()
    {
        return mMaxItemAmount - mAttempts + 1;
    }
}
