public class Game {
    public static void main(String[] args) {

        Prompter prompter = new Prompter();

        String itemName = prompter.getString("Enter the name of the item(s) in the jar: ");
        int maxItemAmount = prompter.getInt("Enter max amount of items: ");

        prompter.print("The maximum amount of %s, is %d", new Object[]{itemName, maxItemAmount});
    }
}
