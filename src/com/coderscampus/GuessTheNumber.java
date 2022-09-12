package com.coderscampus;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {

	public static void main(String[] args) {

		System.out.println("The program will randomly generate an integer between 1 and 100 (inclusive).");
		System.out.println("You will have 5 attempts to guess the number.");
		System.out.println("Any guesses that are not a whole number between 1 and 100 do not count.\n");

		int randomInt = randomNumberGenerator();
		int guessCount = 1;
		inputChecker(randomInt, guessCount);

	}

	private static int randomNumberGenerator() {
		Random random = new Random();
		int randomInt = random.nextInt(1, 101);
		return randomInt;
	}

	public static void inputChecker(int randomInt, int guessCount) {

		try {
			Scanner scanner = new Scanner(System.in);

			while (guessCount <= 5) {
				System.out.println("Guess number " + guessCount + ". Please enter a number from 1 to 100: ");
				String userInput = scanner.nextLine();
				Integer userInt = Integer.parseInt(userInput);

				if (userInt < 1 || userInt > 100) {
					System.out.println("Your guess is not an integer between 1 and 100, please try again.");
				} else if (userInt < randomInt) {
					if (guessCount < 5) {
						System.out.println("Incorrect. Please try a higher number.");
					}
					guessCount++;
				} else if (userInt > randomInt) {
					if (guessCount < 5) {
						System.out.println("Incorrect. Please try a lower number");
					}
					guessCount++;
				} else {
					System.out.println("Correct, the random number was " + randomInt);
					System.out.println("You win!");
					break;
				}
			}
			if (guessCount > 5) {
				System.out.println("No more guesses. You lose!");
				System.out.println("The number to guess was: " + randomInt);
			}

			System.out.println("Enter 'y' to play again, or any other key to exit: ");
			String userInput = scanner.nextLine();

			if (userInput.equalsIgnoreCase("y")) {
				int newRandomInt = randomNumberGenerator();
				guessCount = 1;
				inputChecker(newRandomInt, guessCount);
			} else {
				System.out.println("Game Over!");
			}
			scanner.close();
			return;
		} catch (Exception e) {
			System.out.println("Please input whole numbers only. Try again.");
			inputChecker(randomInt, guessCount);
		}

	}

}
