import java.util.Scanner;

// The Game class represents the main logic of the adventure game
class Game {
    private Scanner scanner; // Scanner object for taking user input
    private Player player;   // Player object representing the player in the game

    // Constructor for the Game class
    public Game() {
        scanner = new Scanner(System.in); // Initialize the scanner to read user input from the console
        player = new Player();             // Initialize the player object
    }

    // Method to start the game
    public void start() {
        // Welcome message
        System.out.println("Welcome to the Adventure Game!");
        System.out.println("You find yourself in a mysterious forest. Your goal is to reach the end alive.");

        // Begin the player's journey
        player.beginJourney(scanner);

        // Check if the player is alive after the first phase of the journey
        if (!player.isAlive()) {
            System.out.println("Game Over! Try again."); // Display game over message if the player is not alive
            return; // Exit the game if the player is not alive
        }

        // Continue the player's journey
        player.continueJourney(scanner);

        // Check if the player is alive after the second phase of the journey
        if (!player.isAlive()) {
            System.out.println("Game Over! Try again."); // Display game over message if the player is not alive
            return; // Exit the game if the player is not alive
        }

        // Final encounter of the player's journey
        player.finalEncounter(scanner);

        // Check if the player is alive after the final encounter
        if (!player.isAlive()) {
            System.out.println("Game Over! Try again."); // Display game over message if the player is not alive
            return; // Exit the game if the player is not alive
        }

        // Congratulations message if the player survives until the end
        System.out.println("Congratulations! You've made it through the adventure!");

        scanner.close(); // Close the scanner to release system resources
    }
}
