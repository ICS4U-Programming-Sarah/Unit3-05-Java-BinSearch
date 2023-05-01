import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

/**
 * This program uses recursion to reverse,
 * a set of strings.
 *
 * @author  Sarah Andrew
 * @version 1.0
 *
 * @since 2023-13-04.
 */

public final class RecBinSearch {

    /**
     * This is a private constructor used to satisfy the
     * style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private RecBinSearch() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This is the main method.
     *
     * @param args Unused.
     */
    public static void main(String[] args) {
        // Pass path to file as parameter.
        final File file = new File("input.txt");
        final File fileOut = new File("output.txt");

        // Create a list of strings.
        final List<String> listOfStrings =
                new ArrayList<String>();
        
        // Declare variable
        String stringList;

        // Usage of try catch to detect error.
        try {
            // Create FileWriter object to write to file.
            final FileWriter fW = new FileWriter(fileOut);
            // Create Scanner object to read from file.
            final Scanner sc = new Scanner(file);
            // Create PrintWriter object to write to file.
            final PrintWriter write = new PrintWriter(fW);

            while (sc.hasNextLine()) {
                // Read line as string.
                stringList = sc.nextLine();
                // Add to list.
                listOfStrings.add(stringList);
            }

            // Convert from list to array.
            final String[] arrayOfStr = listOfStrings.toArray(new String[0]);

            // Convert all elements in array to integers.
            // To do so, loop through each element & convert
            // each string.
            final String[] nums = arrayOfStr[0].split(" ");
            final int[] arrayNum = new int[nums.length];
            for (int counter = 0; counter < nums.length; counter++) {
                arrayNum[counter] = Integer.parseInt(nums[counter]);
            }

            // Read the number to be searched from the second line.
            final int numSearch = Integer.parseInt(arrayOfStr[1].trim());

            // Sort the array.
            java.util.Arrays.sort(arrayNum);

            // Call function.
            final int recSearch = recBinSearch(arrayNum, numSearch,
                    0, arrayNum.length - 1);
            
            // Display to user & write to console.
            System.out.print(recSearch);
            write.println(recSearch);

            // Closes scanner & writer.
            write.close();
            sc.close();
        
        } catch (IOException error) {
            // Displays error to user.
            System.out.println("An error occurred: "
                    + error.getMessage());
        }
    }

    /**
    * This function uses recursion to
    * find the search of number.
    *
    * @param aNum passed
    * @return recFactorial.
    */

    public static int recBinSearch(int[] listNum, int searchNum,
            int left, int right) {
            // Defines base case.
            if (left > right) {
                // Return -1 as left gets bigger than
                // right, meaning an error has occurred.
                return -1;
            }
            // Declare variable.
            int midNum = (left + right) / 2;

            // If element found, return searchNum.
            if (listNum[midNum] == searchNum) {
                return midNum;
            } else if (searchNum < listNum[midNum]) {
                // Calls function recursively, searching left side.
                return recBinSearch(listNum, searchNum, left, midNum - 1);
            } else {
                // Calls function recursively, searching the right side.
                return recBinSearch(listNum, searchNum, midNum + 1, right);
            }
    }

}