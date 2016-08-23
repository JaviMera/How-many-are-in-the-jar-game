import java.util.Scanner;

/**
 * Created by Javier on 8/22/2016.
 */
public class GameIO {

    private Scanner mScanner;

    public GameIO()
    {
        mScanner = new Scanner(System.in);
    }

    public Jar setupAdmin()
    {
        print("\nADMINISTRATOR SETUP\n" + "*******************\n");
        print("Enter What type of item: ");
        String itemName = getStringFromInput();

        print("Enter maximum amount of %s: ", itemName);
        int maxItemAmount = getIntFromInput();

        return new Jar(itemName, maxItemAmount);
    }

    public void showHintMessage(String miss, int attempts)
    {
        print("Hint: Guess is too %s. %d attempts.\n", miss, attempts);
    }

    public void showWarning(Jar jar)
    {
        print("\nYour guess must be between %d and %d\n",jar.getMinNumberOfItems(), jar.getMaxNumberOfItems());
    }

    public String getStringFromInput()
    {
        return mScanner.next();
    }

    public int getIntFromInput()
    {
        return mScanner.nextInt();
    }

    public void showObjective(Jar jar)
    {
        print("To win, you must guess how many %s are in the jar. Guess between %d and %d.\n\n",
                jar.getItemsName(), jar.getMinNumberOfItems(), jar.getMaxNumberOfItems());
    }

    public void showWinningMessage(Player player)
    {
        int attempts = player.getAttempts();

        String message = attempts == 1
                ? "\nYou got it in %d attempt\n"
                : "\nYou got it in %d attempts\n";

        print(message, attempts);
    }

    public void close() {
        mScanner.close();
    }

    public void setupPlayer()
    {
        print("name: ");
        String name = getStringFromInput();
        print("\nPlayer: %s\n", name);
    }

    public void showGuessMessage(Jar jar)
    {
        print("How many %s: ", jar.getItemsName());
    }

    private void print(String message, Object...args)
    {
        System.out.printf(message, args);
    }

    private void print(String message)
    {
        System.out.printf(message);
    }
}
