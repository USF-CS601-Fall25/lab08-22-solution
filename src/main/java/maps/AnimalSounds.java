package maps;

import java.util.HashMap;

/** A class that stores a map of animal sounds, where the key is the animal, and the value is
 * the sound it makes.
 */
public class AnimalSounds {
    // FILL IN CODE: declare the HashMap
    private HashMap<String, String> soundMap;

    public AnimalSounds() {
        // FILL IN CODE: initialize the HashMap
        soundMap = new HashMap<>();
    }

    /**
     * Maps the animal name to the sound
     * @param animal animal name
     * @param sound sound the animal makes
     */
    public void addAnimalSound(String animal, String sound) {
        // FILL IN CODE: add animal as a key, and sound as a value
        soundMap.put(animal, sound);
    }

    /**
     * Return the sound given the animal
     * @param animal animal name
     * @return sound this animal makes
     */
    public String getSound(String animal) {
        // FILL IN CODE: return the sound for the given animal
        // This method must be efficient to get credit for it!!! You do NOT need a loop here
        return soundMap.get(animal);
    }

    /** Take the sound as a parameter, and return the animal that makes this sound or null if no animal in the HashMap makes this sound.
     * @param sound sound
     * @return animal making this sound
     */
    public String getAnimal(String sound) {
        // FILL IN CODE
        // Given the value, you need to search for the corresponding key  -
        for (String animal: soundMap.keySet()) {
            if (soundMap.get(animal).equals(sound))
                return animal;
        }
        return null; // change as needed
    }

}