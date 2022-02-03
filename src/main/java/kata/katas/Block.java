package kata.katas;

public class Block implements Shape {

  private final int width;
  private final int length;
  private final int height;

  public Block(int[] input) {
    this.width = input[0];
    this.length = input[1];
    this.height = input[2];
  }

  public int getWidth() {
    return width;
  }

  public int getLength() {
    return length;
  }

  public int getHeight() {
    return height;
  }

  public int getVolume() {
    return width * length * height;
  }

  public int getSurfaceArea() {
    return (2 * length * width) + (2 * length * height) + (2 * height * width);
  }

}
