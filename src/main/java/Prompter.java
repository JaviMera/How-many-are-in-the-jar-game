import java.io.Console;

/**
 * Created by Javier on 8/21/2016.
 */
public class Prompter {

    private static final int MIN_ITEMS_NUMBER = 1;

    private Console mConsole;
    private NumberGenerator mNumberGenerator;
    private Player mPlayer;

    public Prompter()
    {
        mConsole = System.console();
        mNumberGenerator = new NumberGenerator();
        mPlayer = new Player();
    }

    public void play()
    {
        showAdminMessage();
        Jar jar = createJar();

        showPlayerMessage(jar);
        showObjective(jar);

        int numberToGuess = mNumberGenerator.generate(jar.getMaxNumberOfItems());
        mPlayer.startGuessing(mConsole, numberToGuess);

        showWinningMessage(mPlayer);

        getStringFromConsole("Press any key to exit...");
    }

    private void showAdminMessage()
    {
        print("\nADMINISTRATOR SETUP\n");
        print("*******************\n");
    }

    private void showPlayerMessage(Jar jar)
    {
        print("\nPLAYER\n");
        print("*******************\n");
    }

    private String getStringFromConsole(String message)
    {
        return mConsole.readLine(message);
    }

    private int getIntFromConsole(String message)
    {
        String numberOfItems = mConsole.readLine(message);

        return Integer.parseInt(numberOfItems);
    }

    private void print(String message)
    {
        mConsole.printf(message);
    }

    private void showObjective(Jar jar)
    {
        mConsole.printf("To win, you must guess how many %s are in the jar. Guess between %d and %d.\n\n",
                jar.getItemsName(), MIN_ITEMS_NUMBER, jar.getMaxNumberOfItems());
    }

    private void showWinningMessage(Player player)
    {
        int attempts = player.getAttempts();
        
        String message = attempts == 1
                ? "\nYou got it in %d attempt\n"
                : "\nYou got it in %d attempt(s)\n";

        mConsole.printf(message, attempts);
    }

    private Jar createJar()
    {
        String itemName = getStringFromConsole("Enter the name of the item(s) in the jar: ");
        int maxItemAmount = getIntFromConsole("Enter max amount of items: ");

        return new Jar(itemName, maxItemAmount);
    }
}
