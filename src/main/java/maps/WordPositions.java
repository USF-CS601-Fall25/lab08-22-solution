package maps;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/** A class that keeps track of the word positions in the text */
public class WordPositions {
    // FILL IN CODE: declare and initialize a map where
    /* Each key is word, and the value is the list of positions of this word in the text file
       Example: suppose the text file contains: mouse chased mouse
       Then "mouse" should be mapped to {0, 2}, "chased" to {1}.
     */

    /**
     * Read words from the file and create or update the list of positions for each word
     * @param filepath filepath
     */
    public void computeWordPositions(Path filepath) {
        // Read a given file, and fill in the map declared above
        // For instance, for the file in resources/quotes.txt,
        // for the word "happy", the value should be [2, 9, 17, 22]
        // because "happy" occurs in positions 2, 9, 17, 22 in resources/quotes.txt

        // The try block shown below is called "try with resources" - Java will automatically close the "resource" - BufferedReader,
        // regardless of whether an exception occurs
        // Documentation: https://docs.oracle.com/javase/8/docs/api/java/nio/file/Files.html#newBufferedReader-java.nio.file.Path-
        try(BufferedReader br = Files.newBufferedReader(filepath)) {
            // FILL IN CODE: use readLine method from class BufferedReader to reach each line of the file

        }
        catch (IOException e) {
            System.out.println(e);
        }


    }

    /**
     * Given the word, print all the positions where it occurs
     * @param word input word
     */
    public void printPositions(String word) {
        // Using a map created in the previous method, print positions where the given word occurs
        // Ex: for the word "happy", you should get [2, 9, 17, 22]
        // If the word is not in the map, print nothing.
        // FILL IN CODE

    }
}
