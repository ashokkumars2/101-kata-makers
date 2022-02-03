package kata.katas;

public class BuildingBlocks {

  private final Integer width;
  private final Integer length;
  private final Integer height;

  public BuildingBlocks(int[] input) {
    this.width = input[0];
    this.length = input[1];
    this.height = input[2];
  }

  public Integer getWidth() {
    return width;
  }

  public Integer getLength() {
    return length;
  }

  public Integer getHeight() {
    return height;
  }

  public Integer getVolume() {
    return width * length * height;
  }

  public Integer getSurfaceArea() {
    return (2 * length * width) + (2 * length * height) + (2 * height * width);
  }
}
