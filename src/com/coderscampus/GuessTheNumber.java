package com.coderscampus;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {

	public static void main(String[] args) {
		// Explain game to user.
		System.out.println("The program will randomly generate an integer between 1 and 100 (inclusive).");
		System.out.println("You will have 5 attempts to guess the number.");
		System.out.println("Any guesses that are not a whole number between 1 and 100 do not count.\n");
		// Declare variables to store random number and track guesses.
		// Guess counter starting at 1 for first guess.
		// Method used to get random number so that a new number can be generated if
		// needed later.
		int randomInt = randomNumberGenerator();
		int guessCount = 1;
		// Pass random integer and guess count to input checking method.
		inputChecker(randomInt, guessCount);

	}

	// Method to generate and return random integer between 1 and 100 inclusive.
	private static int randomNumberGenerator() {
		Random random = new Random();
		int randomInt = random.nextInt(1, 101);
		return randomInt;
	}

	// Method to take user input and compare to random integer passed to it.
	public static void inputChecker(int randomInt, int guessCount) {

		// try-catch block to stop program crashing if non-int is entered by user.
		try {
			Scanner scanner = new Scanner(System.in);
			// Continue to allow attempts up to 5 valid guesses.
			while (guessCount <= 5) {
				System.out.println("Guess number " + guessCount + ". Please enter a number from 1 to 100: ");
				// Input taken as String and parsed to integer to manage invalid inputs.
				String userInput = scanner.nextLine();
				Integer userInt = Integer.parseInt(userInput);

				if (userInt < 1 || userInt > 100) {
					// Do not increment count if number is outside range.
					System.out.println("Your guess is not an integer between 1 and 100, please try again.");
				} else if (userInt < randomInt) {
					// Give hints for incorrect guess, unless it is the last guess.
					if (guessCount < 5) {
						System.out.println("Incorrect. Please try a higher number.");
					}
					// Increment count on valid guess.
					guessCount++;
				} else if (userInt > randomInt) {
					if (guessCount < 5) {
						System.out.println("Incorrect. Please try a lower number");
					}
					guessCount++;
				} else {
					// If guess is valid, and not < or >, then it must be correct.
					System.out.println("Correct, the random number was " + randomInt);
					System.out.println("You win!");
					// Exit while loop on correct guess.
					break;
				}
			}
			// Print message when all attempts are used, and confirm correct answer.
			if (guessCount > 5) {
				System.out.println("No more guesses. You lose!");
				System.out.println("The number to guess was: " + randomInt);
			}

			// Give player option to start again with a new random number.
			System.out.println("Enter 'y' to play again, or any other key to exit: ");
			String userInput = scanner.nextLine();
			// If user enters y or Y, generate new random number, and reset counter to 1.
			if (userInput.equalsIgnoreCase("y")) {
				int newRandomInt = randomNumberGenerator();
				guessCount = 1;
				inputChecker(newRandomInt, guessCount);
			} else {
				System.out.println("Game Over!");
			}
			// Close scanner and exit program if player chooses.
			scanner.close();
			return;
			// Catch Number Format Exception if user enters String that cannot be parsed to
			// integer.
		} catch (NumberFormatException e) {
			System.out.println("Please input whole numbers only! Try again.");
			// Call method again if exception is caught. Guess count remains at last valid
			// guess.
			inputChecker(randomInt, guessCount);
		}

	}

}
