import java.util.Random;

public class Game {
    public static void main(String[] args) {

        Prompter prompter = new Prompter();

        String itemName = prompter.getString("Enter the name of the item(s) in the jar: ");
        int maxItemAmount = prompter.getInt("Enter max amount of items: ");

        Jar jar = new Jar(itemName, maxItemAmount);
        prompter.print("To win, you must guess how many %s are in the jar. Guess between %d and %d.", new Object[]{jar.getItemsName(), 1, jar.getMaxNumberOfItems()});
    }
}
