/**
 * Created by Javier on 8/21/2016.
 */
public class Prompter {

    private Player mPlayer;
    private Jar mJar;
    private GameIO mGameIO;

    public Prompter()
    {
        mGameIO = new GameIO();
    }

    public void play()
    {
        mJar = mGameIO.setupAdmin();
        mGameIO.setupPlayer();
        mGameIO.showObjective(mJar);
        mJar.fill();

        mPlayer = new Player();
        int numberToGuess = mJar.getNumberOfItems();
        boolean rightAnswer = false;

        do {
            mGameIO.showGuessMessage(mJar);
            int guess = mGameIO.getIntFromInput();

            if(guess <= mJar.getMaxNumberOfItems())
            {
                rightAnswer = mPlayer.compareGuess(guess, numberToGuess);

                if (mPlayer.isGuessTooHigh(guess, numberToGuess)) {
                    mGameIO.showWarning(mJar);
                    mGameIO.showHintMessage("high", mPlayer.getAttempts());
                }
                else if (mPlayer.isGuessTooLow(guess, numberToGuess))
                {
                    mGameIO.showWarning(mJar);
                    mGameIO.showHintMessage("low", mPlayer.getAttempts());
                }
            }
            else
            {
                mGameIO.showWarning(mJar);
            }

        } while (!rightAnswer);

        mGameIO.showWinningMessage(mPlayer);
        mGameIO.close();
    }
}
