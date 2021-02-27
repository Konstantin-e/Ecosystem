package eco;



public class Bear extends Animal {

  private int id;
  public Bear(int position) {
    super(position);
    this.id = super.getAnimalId();
    System.out.println("Bear " + id + " created at position " + position);
  } 

  public int getId() {
    return this.id;
  }
}
