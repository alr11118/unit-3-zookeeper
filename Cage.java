public class Cage {

    // Create a private instance variable of type Animal. Don't instantiate the variable, only declare it
    private Animal animal;
    // No-arg constructor:
    // - Instantiates this cage with a random Animal.
    // Hint: Animal() can choose a random type.
    public Cage()
    {
      this.animal = new Animal();
    }
    // Constructor with Animal parameter:
    // - Places that Animal into the cage.
    // - Use this.animal to avoid shadowing confusion.
    public Cage(Animal animal)
    {
      this.animal = new Animal(animal.getAnimalType());
    }
    // Write a Getter/Accessor for returning the Animal instance variable
    public Animal getAnimal()
    {
      return this.animal;
    }
    // Write a Setter/Mutator for editing the Animal instance variable
    public void setAnimal(Animal newAnimal)
    {
      this.animal = newAnimal;
    }
    // toString():
    // - Friendly cage description including the animal.
    public String toString()
    {
      return ("Animal in the cage: " + this.animal);
    }
}
