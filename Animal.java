import java.util.Random;

public class Animal {

    // creat a private instance variable to store the animal type (e.g. "Tiger" or "Bear" or any other type of animal)
    private String animalType;
    // create Static/class variable to track how many Animal objects have been created
    private static int animalsCreated;
    // No-argument constructor:
    // - Creates a random animal type using the randomAnimalType() method you should write in this class
    public Animal()
    {
      this.animalType = randomAnimalType();
      this.animalsCreated += 1; 
    }
    // Write a constructor that takes an animal type parameter
    public Animal(String animalType)
    {
      this.animalType = animalType;
      this.animalsCreated += 1;
    }
    // Create a getter/accessor method that returns the static variable that counts how many
    // animals have been instatiated
    public static int getAnimalsCreated()
    {
      return animalsCreated;
    }
    // Create a getter/accessor method for returning the animal type
    public String getAnimalType()
    {
      return this.animalType;
    }
    // Create a getter/ accessor method for updating the animal type
    public void setAnimalType(String newAnimalType)
    {
      this.animalType = newAnimalType;
    }
    // Creat a speak() method that uses the animal type and returns
    // a sound based on the animal type. You can just return a String with the animal noise
    public String speak()
    {
      if (this.animalType == "Cow")
      {
         return("moo");
      }
      else if (this.animalType == "Duck")
      {
         return("quack");
      }
      else if (this.animalType == "Bird")
      {
         return("eek");
      }
      else 
      {
         return("shoosh");
      }
    }
    // Create the speakBackward() method that calls speak() and returns the reversed String
    public String speadBackward()
    {
      String sound = this.speak();
      String newSound = "";
      for (int i = sound.length(); i > 0; i--)
      {
         newSound += sound.substring(i-1, i);
      } 
      return newSound;
    }

    // Create the toString() method which returns friendly description of the animal
    public String toString()
    {
      return "Animal Type: " + this.animalType;
    }

    // Create a static method called "randomAnimalType" that returns a random
    // animale type
    // HINT: Decide how many animal types you want to be able to create, pick a random number
    // and then use if/else/if statements to determine what the animal should say
    public String randomAnimalType()
    {
      int randomNum = (int)(Math.random()*4);
      if (randomNum == 1)
      {
         return "Cow";
      }
      else if (randomNum == 2)
      {
         return "Duck";
      }
      else if (randomNum == 3)
      {
         return "Bird";
      }
      else
      {
         return "Elephant";
      }
    }
}
