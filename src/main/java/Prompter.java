import java.util.Scanner;

/**
 * Created by Javier on 8/21/2016.
 */
public class Prompter {

    private Player mPlayer;
    private Scanner mScanner;

    public Prompter()
    {
        mScanner = new Scanner(System.in);
    }

    public void play()
    {
        print("\nADMINISTRATOR SETUP\n" + "*******************\n");
        print("Enter What type of item: ");
        String itemName = getStringFromInput();

        print("Enter maximum amount of %s: ", itemName);
        int maxItemAmount = getIntFromInput();

        Jar jar = new Jar(itemName, maxItemAmount);

        print("name: ");
        String name = getStringFromInput();
        print("\nPlayer: %s\n", name);
        showObjective(jar);

        jar.fill();

        mPlayer = new Player();
        int numberToGuess = jar.getNumberOfItems();
        boolean rightAnswer = false;

        do {
            print("How many %s: ", jar.getItemsName());
            int guess = getIntFromInput();

            if(guess <= jar.getMaxNumberOfItems())
            {
                rightAnswer = mPlayer.compareGuess(guess, numberToGuess);

                if (mPlayer.isGuessTooHigh(guess, numberToGuess)) {
                    showWarning(jar);
                    showHintMessage("high", mPlayer.getAttempts());
                }
                else if (mPlayer.isGuessTooLow(guess, numberToGuess))
                {
                    showWarning(jar);
                    showHintMessage("low", mPlayer.getAttempts());
                }
            }
            else
            {
                showWarning(jar);
            }

        } while (!rightAnswer);

        showWinningMessage(mPlayer);
        mScanner.close();
    }

    private void showHintMessage(String miss, int attempts)
    {
        print("Hint: Guess is too %s. %d attempts.\n", miss, attempts);
    }

    private void showWarning(Jar jar)
    {
        print("\nYour guess must be between %d and %d\n",jar.getMinNumberOfItems(), jar.getMaxNumberOfItems());
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
                jar.getItemsName(), jar.getMinNumberOfItems(), jar.getMaxNumberOfItems());
    }

    private void showWinningMessage(Player player)
    {
        int attempts = player.getAttempts();

        String message = attempts == 1
                ? "\nYou got it in %d attempt\n"
                : "\nYou got it in %d attempts\n";

        print(message, attempts);
    }
}
