package maps;

import java.nio.file.Path;

public class WordPositionsDriver {
    public static void main(String[] args) {
        Path filepath = Path.of("src/main/resources/quotes.txt");
        WordPositions wp = new WordPositions();
        wp.computeWordPositions(filepath);
        wp.printPositions("happy");
        wp.printPositions("I");

        // FILL IN CODE:
        // Create WordPositions for resources/quotes.txt

        // print the position of the word in the file, using class WordPositions


    }
}
