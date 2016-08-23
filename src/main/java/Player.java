/**
 * Created by Javier on 8/21/2016.
 */
public class Player {

    private int mAttempts;

    public Player()
    {
        mAttempts = 0;
    }

    public int getAttempts()
    {
        return mAttempts;
    }

    public boolean isGuessTooHigh(int guess, int numberToGuess) {
        return guess > numberToGuess;
    }

    public boolean isGuessTooLow(int guess, int numberToGuess)
    {
        return guess < numberToGuess;
    }

    public boolean compareGuess(int guess, int numberToGuess) {

        mAttempts++;
        return guess == numberToGuess;
    }
}
