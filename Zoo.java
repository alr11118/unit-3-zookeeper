import java.util.Random;

public class Zoo {
   
   /*
    *
    *
    * ZOO CLASS (35, 7 points each)
    *  1) Three private instance variables of type Cage declared (not instantiated inline)
    *  2) No-arg constructor: instantiates ALL cages; each starts with a random Animal
    *  3) Two-arg/overloaded constructor(s): demonstrates constructor overloading
    *  4) howManyAnimals(): returns the total number of Animal objects ever created using Animal class data
    *  5) putAnimalInCage(Cage, Animal): replaces the cage’s animal ONLY if that Cage belongs to this Zoo; returns boolean
    *
    * CAGE CLASS (35, 7 points each)
    *  6) Private instance variable of type Animal
    *  7) No-arg constructor: puts a random Animal in the cage
    *  8) Constructor with Animal parameter: puts that Animal in the cage
    *  9) Accessors/mutators for the Animal field, using this where appropriate
    * 10) toString(): friendly Cage description that includes the Animal’s toString
    *
    * ANIMAL CLASS (30 points, 5 points each )
    * 11) Private instance variable animalType (String)
    * 12) Static counter that tracks how many Animals have been instantiated; incremented in constructors
    * 13) Constructors: no-arg random type, and parameterized type; uses this(...) constructor chaining
    * 14) Getter and setter for animalType
    * 15) speak(): returns a sound based on animalType
    * 16) speakBackward(): returns reversed version of speak() (loop or StringBuilder)
    *
    * NOTE: Style/readability (meaningful names, consistent indentation, no magic numbers) can be used
    * as a tie-breaker if scores are close.
    */

    // Create 3 private instance variables of type Cage.
    // Only DECLARE them here (do not instantiate them in the declaration).
    private Cage cage1;
    private Cage cage2;
    private Cage cage3;
    // CONSTRUCTORS
    // 1) No-arg constructor:
    //    - instantiate all 3 cages
    //    - each cage should start with a random Animal
    //    Hint: Cage() can create a random Animal by calling new Animal()
    public Zoo() {
      this.cage1 = new Cage();
      this.cage2 = new Cage();
      this.cage3 = new Cage();
    }
    // 2) Overloaded constructor:
    //    - takes 3 Animal parameters and places them into the 3 cages
    //    - must demonstrate constructor overloading and use "this." at least once
    public Zoo(Animal a1, Animal a2, Animal a3) 
    {
      this.cage1 = new Cage(new Animal(a1.getAnimalType()));
      this.cage2 = new Cage(new Animal(a2.getAnimalType()));
      this.cage3 = new Cage(new Animal(a3.getAnimalType()));
    }
    
    public Cage getCage1()
    {
      return this.cage1;
    }

    // howManyAnimals():
    // Returns the number of Animal objects that have been created so far.
    // Hint: use a static/class variable (and likely a static accessor) in Animal.
    public static int howManyAnimals() {
      /*total += this.cage1.getAnimal().getAnimalsCreated();
      total += this.cage2.getAnimal().getAnimalsCreated();
      total += this.cage3.getAnimal().getAnimalsCreated();*/
      return Animal.getAnimalsCreated();
    }

    // putAnimalInCage(Cage cage, Animal animal):
    // - If the Cage passed in is one of THIS Zoo's cages, replace the Animal inside it and return true.
    // - If the Cage does NOT belong to this Zoo, do nothing and return false.
    // Note: do NOT create any new cages here.
    public boolean putAnimalInCage(Cage cage, Animal animal) {
    // check if the cage belongs to this zoo
    if (cage == this.cage1 || cage == this.cage2 || cage == this.cage3)
    {
      cage.setAnimal(animal); // = new Cage(new Animal(animal.getAnimalType()));
      return true;
    }
    // if so replace the animal and return true 
    // if not return false
      return false;
    }


    // toString():
    // Return a multi-line description of the Zoo including each cage (and the animal inside).
    public String toString()
    {
      return("Cage 1: " + this.cage1 + "\n" + "cage 2: " + this.cage2 + "\n" + "Cage 3: " + this.cage3);
    }
    
    
    
    public static void main(String[] args)
    {
      // Testing Animal class
      System.out.println("Animals created: " + Animal.getAnimalsCreated()); // Print the number of animals created
      Animal animal1 = new Animal();                                        // Make new animal with random animal type
      Animal animal2 = new Animal("Duck");                                  // Make new animal of Duck animal typw
      System.out.println("Animals created: " + Animal.getAnimalsCreated()); // Print the number of animals created
      System.out.println("Animal 1 speaks: " + animal1.speak());            // Make animal 1 speak and print the returned string
      System.out.println("Animal 2 speakes: " + animal2.speak());           // Make animal 2 speak and print the returned string
      animal2.setAnimalType("Cow");                                         // Set Animal 2 to cow
      System.out.println("Animal 2 after being changed to Cow speaks backwards: " + animal2.speadBackward()); // Make animal 1 speak backwards after changing its type to Cow
      System.out.println("ANIMAL1  " + animal1);                            // Print Animal 1
      System.out.println("ANIMAL2  " + animal2);                            // Print Animal 2
      
      System.out.println("");
      
      // Testing Cage Class 
      Cage cage1 = new Cage();                                              // Make a Cage with a random animal in it
      Cage cage2 = new Cage(new Animal("Duck"));                            // Make a cage with a duck anmal in it
      System.out.println("CAGE1  " + cage1);                                // Print out cage1
      System.out.println("CAGE2  " + cage2);                                // Print out cage2
      System.out.println("The animal in cage two: " + cage2.getAnimal());   // Print the animal in cage2
      cage2.setAnimal(new Animal("Cow"));                                   // Cahnge the animal in cage2 to a Cow
      System.out.println("The animal in cage two: " + cage2.getAnimal());   // Print the animal in cage2
      
      System.out.println("");
      
      // Testing the Zoo class
      Zoo zoo1 = new Zoo();                                                                                                        // Zoo with random animals and 3 cages
      Zoo zoo2 = new Zoo(new Animal("Cow"), new Animal(), new Animal());                                                           // Zoo with 3 cages one has a cow and the other two cages have random animals
      System.out.println("ZOO1  \n" + zoo1);                                                                                       // Prints zoo 1
      System.out.println("ZOO2  \n" + zoo2);                                                                                       // Prints zoo2
      System.out.println("Animals created so far: " + Zoo.howManyAnimals());                                                       // Prints the number of animals created so far
      System.out.println("Changing cage 1 in zoo2: " + zoo2.putAnimalInCage(zoo2.getCage1(), new Animal("Elephant")));             // Changes the animal in cage1 for zoo2 using the same cage
      System.out.println("ZOO2  \n" + zoo2);                                                                                       // Prints zoo2
      System.out.println("Changing cage 1 in zoo2 using a new cage: " + zoo2.putAnimalInCage(new Cage(), new Animal("Elephant"))); // Changes the animal in cage1 for zoo2 using a ne cage 
      System.out.println("ZOO2  \n" + zoo2);                                                                                       // Prints zoo2
    }
}
