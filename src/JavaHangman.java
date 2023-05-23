import java.util.Scanner;

public class JavaHangman {
    private String[] words;
    private String[] hints;
    private int score;
    private int attempts;
    private Scanner scanner;

    public JavaHangman() {
        words = new String[] {
                "variable",
                "method",
                "class",
                "object",
                "inheritance",
                "polymorphism",
                "interface",
                "constructor",
                "array",
                "loop",
                "recursion",
                "string",
                "parameter",
                "static",
                "overloading",
                "overriding",
                "casting",
                "abstraction",
                "package",
                "constructor",
                "encapsulation",
                "conditional",
                "interface",
                "exception",
                "boolean",
                "byte",
                "double",
                "final"
        };

        hints = new String[] {
                "A container that holds a value.",
                "A set of code which performs a specific task.",
                "A blueprint or template for creating objects.",
                "An instance of a class.",
                "The mechanism of creating a new class from an existing class.",
                "The ability of an object to take on many forms.",
                "A contract specifying a set of methods that a class must implement.",
                "A special method used to initialize objects.",
                "A data structure that stores multiple values of the same type.",
                "A control structure for executing a block of code repeatedly.",
                "A function that calls itself.",
                "A sequence of characters.",
                "A value passed to a method.",
                "A keyword used to create variables and methods that belong to a class.",
                "Having multiple methods with the same name but different parameters.",
                "Replacing a method in a superclass with a new implementation in a subclass.",
                "Converting an object of one type to another type.",
                "A concept of exposing only necessary information and hiding the implementation details.",
                "A way to organize classes and interfaces into groups.",
                "A special method used to initialize objects.",
                "A mechanism of bundling data and methods together.",
                "A control structure for making decisions based on conditions.",
                "A contract specifying a set of methods that a class must implement.",
                "An event that occurs during the execution of a program.",
                "Refers to an expression or variable that can have only a true or false value. The Java programming language provides the boolean type and the literal values true and false.",
                "A sequence of eight bits. Java provides a corresponding byte type",
                "A Java keyword used to define a variable of type double.",
                "A Java keyword. You define an entity once and cannot change it or derive from it later. More specifically: a final class cannot be subclassed, a final method cannot be overridden and a final variable cannot change from its initialized value."

        };

        score = 0;
        attempts = 5;
        scanner = new Scanner(System.in);
    }

    public void play() {
        while (score < 20) {
            // Select a random word from the array
            int randomIndex = (int) (Math.random() * words.length);
            String word = words[randomIndex];
            String hint = hints[randomIndex];

            char[] guessedLetters = new char[word.length()]; // Array to store the correctly guessed letters
            for (int i = 0; i < guessedLetters.length; i++) {
                guessedLetters[i] = '_'; // Initialize the guessed letters array with underscores
            }

            while (attempts > 0) {
                System.out.println("Word: " + new String(guessedLetters));
                System.out.println("Hint: " + hint);
                System.out.println("Attempts remaining: " + attempts);
                System.out.print("Guess a letter: ");
                char guess = scanner.nextLine().charAt(0); // Read the user's guess

                boolean correctGuess = false;

                // Check if the guessed letter matches any character in the word
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == guess) {
                        guessedLetters[i] = guess; // Update the guessed letters array
                        correctGuess = true;
                    }
                }

                if (correctGuess) {
                    System.out.println("Correct guess!");

                    // Check if the word has been completely guessed
                    if (new String(guessedLetters).equals(word)) {
                        System.out.println("Congratulations! You guessed the word: " + word);
                        score += 2; // Add 2 points for guessing the word correctly
                        break;
                    }
                } else {
                    attempts--;
                    System.out.println("Incorrect guess!");

                    // Check if all attempts have been used up
                    if (attempts == 0) {
                        System.out.println("Game over! The word was: " + word);
                        score -= 2; // Deduct 2 points for using up all attempts
                    }
                }
            }

            System.out.println("Current score: " + score);

            // Check if the player has reached a score of 20 or more
            if (score >= 20) {
                System.out.println("Congratulations! You reached a score of 20 or more!");
                break;
            }

            attempts = 5; // Reset the number of attempts for the next round
        }

        scanner.close();
    }

}
