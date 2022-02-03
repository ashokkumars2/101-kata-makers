package kata.katas;


import static org.junit.jupiter.api.Assertions.assertEquals;

import kata.katas.BuildingBlocks;
import org.junit.jupiter.api.Test;

public class BuildingBlocksTest {
  @Test
  public void testBasicBlock() throws Exception {
    BuildingBlocks b = new BuildingBlocks(new int[]{2,2,2});
    assertEquals(2,b.getWidth());
    assertEquals(2,b.getLength());
    assertEquals(2,b.getHeight());
    assertEquals(8,b.getVolume());
    assertEquals(24,b.getSurfaceArea());
  }
}