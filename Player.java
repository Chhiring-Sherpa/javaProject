import java.util.Scanner;

// The Player class represents the player in the adventure game
class Player {
    private boolean alive; // Boolean variable to track if the player is alive

    // Constructor to initialize the player as alive
    public Player() {
        alive = true;
    }

    // Constructor with parameter to set player's initial state
    public Player(boolean alive) {
        this.alive = alive;
    }

    // Method to check if the player is alive
    public boolean isAlive() {
        return alive;
    }

    // Method to set player's alive status
    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    // Method to begin the player's journey
    public void beginJourney(Scanner scanner) {
        // Start of the story
        System.out.println("As you journey through the forest, you encounter a fork in the road. Do you go left, right, or forward? (type 'left', 'right', or 'forward'):");
        String command = scanner.nextLine().toLowerCase();

        // First decision point
        if (command.equals("left")) {
            chooseLeftPath(scanner);
        } else if (command.equals("right")) {
            chooseRightPath(scanner);
        } else if (command.equals("forward")) {
            chooseForwardPath(scanner);
        } else {
            System.out.println("Invalid command. You hesitate and lose your way. Game Over!");
            alive = false;
        }
    }

    // Method to handle the player choosing the left path
    public void chooseLeftPath(Scanner scanner) {
        System.out.println("You chose the left path. You stumble upon a peaceful village. Do you stay or continue your journey? (type 'stay' or 'continue'):");
        String command = scanner.nextLine().toLowerCase();
        if (command.equals("stay")) {
            System.out.println("You decide to stay in the village and live peacefully. Congratulations, you have survived!");
        } else if (command.equals("continue")) {
            System.out.println("You continue your journey deeper into the forest.");
        } else {
            System.out.println("Invalid command. You hesitate and lose your way. Game Over!");
            alive = false;
        }
    }

    // Method to handle the player choosing the right path
    public void chooseRightPath(Scanner scanner) {
        System.out.println("You chose the right path. You encounter a pack of wolves. Do you try to scare them away, sneak past them, or climb a tree? (type 'scare', 'sneak', or 'climb'):");
        String command = scanner.nextLine().toLowerCase();
        if (command.equals("scare")) {
            System.out.println("You try to scare the wolves away, but they attack you. Game Over!");
            alive = false;
        } else if (command.equals("sneak")) {
            System.out.println("You manage to sneak past the wolves and continue deeper into the forest.");
        } else if (command.equals("climb")) {
            System.out.println("You climb a tree to avoid the wolves. After waiting for a while, they leave. You continue your journey.");
        } else {
            System.out.println("Invalid command. The wolves sense your hesitation and attack you. Game Over!");
            alive = false;
        }
    }

    // Method to handle the player choosing the forward path
    public void chooseForwardPath(Scanner scanner) {
        System.out.println("You chose the forward path. You encounter a rushing river. Do you swim across, look for a bridge, or try to build a raft? (type 'swim', 'bridge', or 'raft'):");
        String command = scanner.nextLine().toLowerCase();
        if (command.equals("swim")) {
            System.out.println("You attempt to swim across the river, but the current is too strong. Game Over!");
            alive = false;
        } else if (command.equals("bridge")) {
            System.out.println("You search for a bridge and find one. You cross the river safely.");
        } else if (command.equals("raft")) {
            System.out.println("You gather some materials and build a raft. With careful navigation, you manage to cross the river.");
        } else {
            System.out.println("Invalid command. You hesitate and lose your way. Game Over!");
            alive = false;
        }
    }

    // Method to handle the player choosing the continue path
    public void continueJourney(Scanner scanner) {
        // Continue the story
        System.out.println("As you venture further into the forest, you encounter a cave. Do you enter the cave or continue forward? (type 'enter' or 'continue'):");
        String command = scanner.nextLine().toLowerCase();

        // Second decision point
        if (command.equals("enter")) {
            System.out.println("You enter the cave and find a sleeping bear. Do you try to sneak past it or retreat quietly? (type 'sneak' or 'retreat'):");
            command = scanner.nextLine().toLowerCase();
            if (command.equals("sneak")) {
                System.out.println("You attempt to sneak past the bear, but it wakes up and attacks you. Game Over!");
                alive = false;
            } else if (command.equals("retreat")) {
                System.out.println("You retreat quietly from the cave and continue forward.");
            } else {
                System.out.println("Invalid command. The bear senses your hesitation and attacks you. Game Over!");
                alive = false;
            }
        } else if (!command.equals("continue")) {
            System.out.println("Invalid command. You hesitate and lose your way. Game Over!");
            alive = false;
        }
    }

    // Method to continue the player's journey
    public void finalEncounter(Scanner scanner) {
        // Prompt the player to decide whether to open the treasure chest
        System.out.println("You reach the end of the forest and find a treasure chest. Do you wish to try and open it? (type 'yes' or 'no'):");
        String command = scanner.nextLine().toLowerCase();

        // If the player chooses to open the chest
        if ("yes".equals(command)) {
            // Display options for riddles
            System.out.println("The chest is locked with a riddle. Choose a number (1-5) to select a riddle:");

            // Get the player's choice
            int choice = Integer.parseInt(scanner.nextLine());

            // Based on the player's choice, assign the selected riddle and its correct answer
            String currentRiddle;
            String correctAnswer;
            switch (choice) {
                case 1:
                    currentRiddle = "I speak without a mouth and hear without ears. I have no body, but I come alive with the wind. What am I?";
                    correctAnswer = "echo";
                    break;
                case 2:
                    currentRiddle = "The more you take, the more you leave behind. What am I?";
                    correctAnswer = "footsteps";
                    break;
                case 3:
                    currentRiddle = "I’m tall when I’m young, and I’m short when I’m old. What am I?";
                    correctAnswer = "candle";
                    break;
                case 4:
                    currentRiddle = "I’m light as a feather, but even the world’s strongest man couldn’t hold me for long. What am I?";
                    correctAnswer = "breath";
                    break;
                case 5:
                    currentRiddle = "What can run but never walks, has a mouth but never talks, has a head but never weeps, has a bed but never sleeps?";
                    correctAnswer = "river";
                    break;
                default:
                    // Invalid choice
                    System.out.println("Invalid choice. The chest remains locked, and the opportunity to uncover its secrets slips away. Game Over!");
                    alive = false;
                    return;
            }

            // Display the selected riddle to the player
            System.out.println("The chest is locked with a riddle: '" + currentRiddle + "'");
            System.out.println("What is the answer?");

            // Check if the player's answer is correct
            String answer = scanner.nextLine().toLowerCase();
            if (answer.equals(correctAnswer)) {
                // Player's answer is correct
                System.out.println("Correct! The chest opens to reveal gold coins and precious gems. Congratulations, you've unraveled the secret of the treasure and completed your quest!");
            } else {
                // Player's answer is incorrect
                System.out.println("Incorrect. The chest remains locked, sealing its secrets perhaps forever. You've come this far only to fall at the last hurdle. Game Over.");
                alive = false;
            }

            // If the player chooses not to open the chest
        } else if ("no".equals(command)) {
            // Player decides not to open the chest
            System.out.println("You decide to leave the treasure chest untouched and continue on your journey.");
            System.out.println("You emerge from the forest alive, having successfully navigated through its dangers, but the treasure remains a mystery.");
        } else {
            // Invalid command
            System.out.println("Invalid command. You hesitate and lose your way. Game Over!");
            alive = false;
        }
    }
}
