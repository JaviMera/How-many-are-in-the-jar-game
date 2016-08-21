import java.util.Random;

public class Game {
    public static void main(String[] args) {

        Prompter prompter = new Prompter();
        int numberToGuess;
        int guess;
        Random random = new Random();

        prompter.showAdminMessage();

        String itemName = prompter.getString("Enter the name of the item(s) in the jar: ");
        int maxItemAmount = prompter.getInt("Enter max amount of items: ");

        Jar jar = new Jar(itemName, maxItemAmount);
        prompter.showPlayerMessage(jar);

        numberToGuess = random.nextInt(maxItemAmount) + 1;

        do
        {
            guess = prompter.getInt("Guess: ");
            prompter.newLine();

            if(guess == numberToGuess)
            {
                prompter.showWinningMessage();
            }

        }while(guess != numberToGuess);

        prompter.newLine();
        prompter.getString("Press any key to exit");
    }
}
