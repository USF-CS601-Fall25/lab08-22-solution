package menu;

import java.nio.file.Path;

public class MenuDriver {
    public static void main(String[] args) {

        // Create three menu items
        // item1 and item2 are read from the file (see burrito.txt and fishTaco.txt.txt)
        MenuItem item1 = new MenuItem(Path.of("src/main/resources/burrito.txt"));
        MenuItem item2 = new MenuItem(Path.of("src/main/resources/fishTaco.txt"));
        System.out.println(item1);
        System.out.println(item2);
        // this item is created from scratch, without the text file
        MenuItem item3 = new MenuItem("Tofu Sandwich",  11.24f);

        // Test methods in class MenuItem
        item3.addIngredient("tofu");
        item3.addIngredient("avocado");
        item3.addIngredient("mayo");

        item1.increasePrice(0.10f);
        System.out.println(item1.getPrice());

        boolean res1 = item1.containsIngredient("lettuce");
        boolean res2 = item2.containsIngredient("salsa");
        boolean res3 = item3.containsIngredient("mayo");
        boolean res4 = item3.containsIngredient("onions");

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
        System.out.println(res4);

        item1.writeToFile("item1");
        item2.writeToFile("item2");
        item3.writeToFile("item3");

    }

}