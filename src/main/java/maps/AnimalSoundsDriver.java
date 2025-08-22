package maps;

public class AnimalSoundsDriver {
    public static void main(String[] args) {
        AnimalSounds animalSounds = new AnimalSounds();
        // Add three animals & sounds to it (say, "cat" ->"meow", "dog"->"woof", "mouse"->"squeak").
        // Call / Test getSound and getAnimal methods
        // FILL IN CODE
        animalSounds.addAnimalSound("cat", "meow");
        animalSounds.addAnimalSound("dog", "woof");
        animalSounds.addAnimalSound("cow", "moo");
        String sound1 =  animalSounds.getSound("dog");
        if (sound1 != null)
            System.out.println(sound1);

        String animal =  animalSounds.getAnimal("moo");
        if (animal != null)
            System.out.println(animal);
    }
}
