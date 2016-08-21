import java.io.Console;

public class Game {
    public static void main(String[] args) {

        Console console = System.console();
        String itemType = console.readLine("Enter the type of item: ");
        int maxItemAmount = Integer.parseInt(console.readLine("Enter max amount of items: "));

        console.printf("The maximum amount of %s, is %d", itemType, maxItemAmount);
    }
}
