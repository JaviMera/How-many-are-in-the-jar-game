import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Javier on 8/21/2016.
 */
public class Prompter {

    private static final int MIN_ITEMS_NUMBER = 1;

    private NumberGenerator mNumberGenerator;
    private Player mPlayer;
    private Scanner mScanner;
    private boolean mPlayAgain;

    public Prompter()
    {
        mNumberGenerator = new NumberGenerator();
        mScanner = new Scanner(System.in);
    }

    public void play() {
        showAdminTitle();

        print("Enter the name of the item(s) in the jar: ");
        String itemName = getStringFromInput();

        print("Enter max amount of items: ");
        int maxItemAmount = getIntFromInput();

        Jar jar = new Jar(itemName, maxItemAmount);

        showPlayerTitle(jar);
        showObjective(jar);

        int numberToGuess = mNumberGenerator.generate(jar.getMaxNumberOfItems());
        mPlayer = new Player(numberToGuess);

        do
        {
            print("Guess: ");
            int guess = getIntFromInput();
            mPlayer.setGuess(guess);

        } while (!mPlayer.isGuessCorrect());

        showWinningMessage(mPlayer);
        mScanner.close();
    }

    private void showAdminTitle()
    {
        print("\nADMINISTRATOR SETUP\n");
        print("*******************\n");
    }

    private void showPlayerTitle(Jar jar)
    {
        print("\nPLAYER\n");
        print("*******************\n");
    }

    private String getStringFromInput()
    {
        return mScanner.next();
    }

    private int getIntFromInput()
    {
        return mScanner.nextInt();
    }

    private void print(String message, Object...args)
    {
        System.out.printf(message, args);
    }

    private void print(String message)
    {
        System.out.printf(message);
    }

    private void showObjective(Jar jar)
    {
        print("To win, you must guess how many %s are in the jar. Guess between %d and %d.\n\n",
                jar.getItemsName(), MIN_ITEMS_NUMBER, jar.getMaxNumberOfItems());
    }

    private void showWinningMessage(Player player)
    {
        int attempts = player.getAttempts();

        String message = attempts == 1
                ? "\nYou got it in %d attempt\n"
                : "\nYou got it in %d attempt(s)\n";

        print(message, attempts);
    }

}
