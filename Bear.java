package eco;



public class Bear extends Animal {

  private static int id = 0;

  public Bear(int position) {
    super(position);
    System.out.println("Bear " + id++ + " created at position " + position);
  } 


}
