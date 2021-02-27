package eco;

import java.lang.Math;

public class Ecosystem {

  private Animal[] river;
  private int[] positions;
  private int riverSize;
  private Fish[] allFish;
  private Bear[] allBears;
  private int numberOfFish;
  private int numberOfBears;
  private int numberOfAnimals = 0;

  public Ecosystem(int size) {
    this.river = new Animal[size];
    this.riverSize = size;
    this.positions = new int[size];
    System.out.println("River of size " + size + " created");
  }  

  private void createFish(int howMany) {
    this.numberOfFish = howMany;
    this.numberOfAnimals += howMany;
    this.allFish = new Fish[howMany];
    for (int i = 0; i < howMany; i++) {
      //create fish with random position
      createRandomFish(i);     
    }
  }

  private void createRandomFish(int i) {
      allFish[i] = new Fish(this.getRandom());   
      this.putFishIn();
  }

  private void putFishIn() {
    for (int i = 0; i < numberOfFish && allFish[i] != null; i++) {
      river[allFish[i].getPosition()] = allFish[i];
    }
  }

  private void createBears(int howMany) {
    this.numberOfBears = howMany;
    this.numberOfAnimals += howMany;
    this.allBears = new Bear[howMany];
    for (int i = 0; i < howMany; i++) {
      //create bears with random position
      createRandomBear(i); 
    }
  }

  private void createRandomBear(int i) {
      allBears[i] = new Bear(this.getRandom());   
      this.putBearIn();
  }
  
  private void putBearIn() {
    for (int i = 0; i < numberOfBears && allBears[i] != null; i++) {
      river[allBears[i].getPosition()] = allBears[i];// puts a Bear in the river
    }
  }

  private int getRandom() {
    int random;
    do {
     random = (int) (Math.random() * this.riverSize);
    } while (river[random] != null);
    return random;
  }

  public void populateRiver(int numOfBears, int numOfFish) {
    this.createBears(numOfBears);
    this.createFish(numOfFish);
  }

  public void printRiver() {
    for (int i = 0; i < this.riverSize; i++) {
      if (river[i] instanceof Bear)
        System.out.print("-B");
      else if (river[i] instanceof Fish)
        System.out.print("-F");
      else
        System.out.print("-_");
    } 
    System.out.println("");
  }
  
  public void moveAnimals() {
    this.clearRiver();
    for (int i = 0; i < numberOfBears; i++) {
       allBears[i].move(this.riverSize);
    }  
    for (int i = 0; i < numberOfFish; i++) {
       allFish[i].move(this.riverSize);
    }  
  }

  public void clearRiver() {
    for (int i = 0; i < riverSize; i++) {
      river[i] = null;
    }
  }

  public void putAnimalsIn() {
    this.putFishIn();
    this.putBearIn();
  }

  public void ecoLoop(int numOfIterations) {
    for (int i = 0; i < numOfIterations; i++) {
      this.printRiver();
      this.moveAnimals();
      this.clearRiver();
      this.putAnimalsIn();
      try {
         Thread.sleep(1000);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    }
  }

  public static void main(String[] args) {
    Ecosystem eco = new Ecosystem(20);
    eco.populateRiver(2,2);
    eco.ecoLoop(20);
  }
}
