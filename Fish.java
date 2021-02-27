package eco;



public class Fish extends Animal{
  private static int id = 0;
    
  public Fish(int position) {
    super(position);
    System.out.println("Fish " + id++ + " created at position " + position);
  } 

  public void die() {
    
  }
}
