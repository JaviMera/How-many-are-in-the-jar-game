import java.io.Console;
/**
 * Created by Javier on 8/21/2016.
 */
public class Prompter {

    private Console mConsole;

    public Prompter()
    {
        mConsole = System.console();
    }

    public void showAdminMessage()
    {
        print("ADMINISTRATOR SETUP");
        print("*******************");
        print("\n");
    }

    public void showPlayerMessage(Jar jar)
    {
        print("\n");
        print("PLAYER");
        print("\n");
        print("*******************");
        print("\n");
        print("To win, you must guess how many %s are in the jar. Guess between %d and %d.", new Object[]{jar.getItemsName(), 1, jar.getMaxNumberOfItems()});
        print("\n\n");
    }

    public String getString(String message)
    {
        return mConsole.readLine(message);
    }

    public int getInt(String message)
    {
        String numberOfItems = mConsole.readLine(message);

        return Integer.parseInt(numberOfItems);
    }

    public void newLine()
    {
        print("\n");
    }

    public void showWinningMessage()
    {
        print("Excelent Job! You've won.");
    }

    private void print(String message, Object[] messageParams)
    {
        mConsole.printf(message, messageParams);
    }

    private void print(String message)
    {
        mConsole.printf(message);
    }
}
