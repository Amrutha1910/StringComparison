package com.strings;

import java.util.Scanner;

public class StringComparison {
	
	// This method takes no of strings to be compared in the form of Integer.
	public static int getValidNumStrings(Scanner scanner) {
        int numStrings = 0;
        boolean validInput = false;
        while (!validInput) {
            System.out.print("How many strings would you like to compare? ");
            if (scanner.hasNextInt()) {
                numStrings = scanner.nextInt();
                validInput = true;
            } else {
                System.out.println("Please enter a valid integer");
                scanner.next();
            }
        }
        return numStrings;
    }

	// This method verifies given Comparison type is valid or not
    public static String getValidComparisonType(Scanner scanner) {
        String comparisonType = "";
        boolean validInput = false;
        while (!validInput) {
            System.out.print("Would you like to compare the strings by vowels or consonants? ");
            comparisonType = scanner.next().toLowerCase();
            if (comparisonType.equals("vowels") || comparisonType.equals("consonants")) {
                validInput = true;
            } else {
                System.out.println("Please enter a valid comparison type");
            }
        }
        return comparisonType;
    }
    
    // This method verifies entered strings are not Integers and special characters
    public static boolean isValidString(String str) {
        return str.matches("[a-zA-Z]+");
    }

    // This method calculates the no of characters occurs in which index based on Comparison type
    public static String countCharacters(String str, String comparisonType) {
        String characters;
        if (comparisonType.equals("vowels")) {
            characters = "aeiouAEIOU";
        } else if (comparisonType.equals("consonants")) {
            characters = "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ";
        } else {
            return "Invalid comparison type";
        }
        int count = 0;
        String positions = "";
        for (int i = 0; i < str.length(); i++) {
            if (characters.indexOf(str.charAt(i)) >= 0) {
                count++;
                positions += i + " ";
            }
        }
        if (count == 0) {
            return String.format("There are no %s in the string", comparisonType);
        } else {
            return String.format("There are %d %s in the string at positions %s", count, comparisonType, positions.trim());
        }
    }
    
    //This method validate the entered value is to take Strings and Calling the countCharacters method to get result
    public static void validateNumberOfStrings(int numStrings, String comparisonType) {
    	Scanner scanner = new Scanner(System.in);
    	if (numStrings < 2) {
            System.out.println("Please enter a valid number of strings (must be at least 2)");
            numStrings = StringComparison.getValidNumStrings(scanner);
        } else if (numStrings > 5) {
            System.out.println("Please enter a smaller number of strings (must be no more than 5)");
            numStrings = StringComparison.getValidNumStrings(scanner);
        }

        for (int i = 1; i <= numStrings; i++) {
            System.out.printf("Enter string %d: ", i);
            String str = scanner.next();
            while (!StringComparison.isValidString(str)) {
                System.out.println("Please enter a valid string (letters only)");
                str = scanner.next();
            }
            String result = StringComparison.countCharacters(str, comparisonType);
            System.out.println(result);
        }
    }
}
