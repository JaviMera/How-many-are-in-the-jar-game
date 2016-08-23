public class Game {
    public static void main(String[] args) {

        Prompter prompter = new Prompter(System.in);
        Jar jar;
        Player player;
        String itemsName;
        int itemsMaxAmount;

        prompter.display("\nADMINISTRATOR SETUP\n" + "*******************\n");
        prompter.display("Enter What type of item: ");
        itemsName = prompter.getString();

        prompter.display("Enter maximum amount of %s: ", itemsName);
        itemsMaxAmount = prompter.getInt();

        prompter.display("Enter name: ");
        String name = prompter.getString();

        jar = new Jar(itemsName, itemsMaxAmount);
        jar.fill();

        prompter.display("\nPlayer: ", name);
        prompter.display("To win, you must guess how many %s are in the jar. Guess between %d and %d.\n\n",
                jar.getItemsName(), jar.getMinNumberOfItems(), jar.getMaxNumberOfItems());

        player = new Player();
        int numberToGuess = jar.getNumberOfItems();
        boolean rightAnswer = false;

        do
        {
            prompter.display("How many %s: ", jar.getItemsName());
            int guess = prompter.getInt();

            if(guess <= jar.getMaxNumberOfItems())
            {
                rightAnswer = player.compareGuess(guess, numberToGuess);

                if (player.isGuessTooHigh(guess, numberToGuess)) {
                    prompter.display("\nYour guess must be between %d and %d\n",jar.getMinNumberOfItems(), jar.getMaxNumberOfItems());
                    prompter.display("Hint: Guess is too high. %d attempts.\n", player.getAttempts());
                }
                else if (player.isGuessTooLow(guess, numberToGuess))
                {
                    prompter.display("\nYour guess must be between %d and %d\n",jar.getMinNumberOfItems(), jar.getMaxNumberOfItems());
                    prompter.display("Hint: Guess is too low. %d attempts.\n", player.getAttempts());
                }
            }
            else
            {
                prompter.display("\nYour guess must be between %d and %d\n",jar.getMinNumberOfItems(), jar.getMaxNumberOfItems());
            }

        }while(!rightAnswer);

        int attempts = player.getAttempts();
        String message = attempts == 1
                ? "\nYou got it in %d attempt\n"
                : "\nYou got it in %d attempts\n";

        prompter.display(message, attempts);
        prompter.close();
    }
}