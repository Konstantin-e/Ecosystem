package eco;



public class Fish extends Animal{
  private int id;
  
  public Fish(int position) {
    super(position);
    this.id = super.getAnimalId();
    System.out.println("Fish " + id + " created at position " + position);
  } 

  public int getId() {
    return this.id;
  }
}
