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

    public String getString(String message)
    {
        return mConsole.readLine(message);
    }

    public int getInt(String message)
    {
        String numberOfItems = mConsole.readLine(message);

        return Integer.parseInt(numberOfItems);
    }

    public void print(String message, Object[] messageParams)
    {
        mConsole.printf(message, messageParams);
    }
}
