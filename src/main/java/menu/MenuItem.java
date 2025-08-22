package menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/** A class representing a menu item in the menu */
public class MenuItem {
    private String name; // name; example: "sesame chicken"
    private float price; // price; example: 10.95f
    private List<String> ingredients; // a list of ingredients; Example: "cubed chicken meat", "soy sauce", "oil", "flour"

    /** Constructor for class MenuItem. Takes the name and the price.
     *
     * @param name name of the item
     * @param price price of the item
     */
    public MenuItem(String name, float price) {
        // FILL IN CODE
        // Initialize this.name and this.price
        // initialize the ingredients ArrayList
        ingredients = new ArrayList<>();
        this.name = name;
        this.price = price;
    }

    /** Constructor that loads info about a single MenuItem from the file.
     * Must use the BufferedReader, not Scanner.
     * @param filepath to the file
     */
    public MenuItem(Path filepath) {

  		/* Reads info about a single menu item from the given file using the BufferedReader .
   		 The info about the menu item is in the following format:
    		name; price; ingredient1, ingredient2, ...

    		Example:
        	Cheese Pizza; 10.25; Flour, eggs, cheese, tomato sauce

       		It is okay to assume all ingredients fit in one line.
       		Use Float.parseFloat method to convert the price in String format
       		to a float. IOException should be caught in this method.
       		As you read info from the file, assign values to corresponding
	   		instance variables.
	   		See samples files in the resources folder - burrito.txt, fishTaco.txt.
	   	*/
        // FILL IN CODE
        // This syntax is called "try with resources" - Java will automatically close the "resource" - BufferedReader,
        // regardless of whether an exception occurs
        // Documentation: https://docs.oracle.com/javase/8/docs/api/java/nio/file/Files.html#newBufferedReader-java.nio.file.Path-
        ingredients = new ArrayList<>();
        try(BufferedReader br = Files.newBufferedReader(filepath)) {
            // FILL IN CODE: use readLine method from class BufferedReader to reach each line of the file
            String line = br.readLine();
            if (line != null) {
                String[] words = line.split("; ");
                if (words.length < 3)
                    throw new IllegalArgumentException();
                this.name = words[0];
                this.price = Float.parseFloat(words[1]);
                String[] ingrs = words[2].split(", ");
                for (String ing: ingrs) {
                    ingredients.add(ing);
                }
            }
        }
        catch (IOException e) {
            System.out.println(e);
        }

    }

    /** Return name of this menu item
     *  @return name
     */
    public String getName() {
        return name;
    }


    /** Return price of this menu item
     *  @return price
     */
    public float getPrice() {
        return price;
    }



    /** Increases the price of this menu item by the given price difference
     * @param priceDifference */
    public void increasePrice(float priceDifference) {
        // Update the price: increase it by priceDifference, assume it's >=0
        // FILL IN CODE
        if (priceDifference > 0)
            price += priceDifference;
        else
            throw new IllegalArgumentException();
    }

    // Adds a given ingredient to the list of ingredients
    public void addIngredient(String ingredient) {
        // FLL IN CODE
        ingredients.add(ingredient);


    }

    /** Returns true if this item contains a given ingredient
     *  @param ingredient
     *  @return true if this menu item contains this ingredient
     */
    public boolean containsIngredient(String ingredient) {
        // FILL IN CODE
        // You may NOT use the contains method
        return ingredients.contains(ingredient);

    }

    /** Return menu item info in the following format:
     *  name; price; ingredients separated by comma
     *  Example: Sesame chicken, 8.25; cubed chicken meat, soy sauce, oil, flour
     */
    public String toString() {
        // FILL IN CODE:

        StringBuilder sb = new StringBuilder();
        sb.append(name + "; " + price + "; ");
        for (String ingredient : ingredients) {
            sb.append(ingredient + ", ");
        }
        sb.setLength(sb.length() - 2);
        return sb.toString();
    }

    /** Writes the information about this menu item to a file with the given filename, using PrintWriter
     * @param filename Name of the file where to write the information
     */
    public void writeToFile(String filename) {
        // FILL IN CODE
        // Use Java documentation to see how to use a PrintWriter
        // Just like we did above, use try with resources
	 	/* Write the menu item to a file in the following format:
	 	   name; price; ingredient1, ingredient2, ingredient3
		*/
        Path path = Path.of(filename);
        try (var writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            writer.write(toString());
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }

    }
}

