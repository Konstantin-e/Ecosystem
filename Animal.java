package eco;

import java.lang.Math;

public abstract class Animal {
  
  private int position;
  protected static int id = 0;

  public Animal(int position) {
    this.position = position;
  }

  public  int getAnimalId() {
    int id = this.id++;
    return id;
  }

  public void move(int riverSize) {
    int random = (int) (Math.random() * 3);
    if (random == 0 && this.position != riverSize - 1) 
      this.position++;
    else if (random == 1 && this.position != 0)
      this.position--;
  } 
  
  public void attemptToMove() {
  
  }

  public int getPosition() {
    return this.position;
  }
    
    
}
