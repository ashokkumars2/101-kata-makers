package kata.katas;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static kata.katas.DrivingLicence.driver;

import java.text.ParseException;
import org.junit.jupiter.api.Test;

public class DrivingLicenceTest
{
  @Test
  public void basicTests() throws ParseException {
    assertEquals("SMITH001010JJ9AA", driver(new String[]{"John",    "James",  "Smith", "01-Jan-2000",       "M"}));
    assertEquals("GIBBS862131J99AA", driver(new String[]{"Johanna", "",       "Gibbs", "13-Dec-1981",       "F"}));
    assertEquals("LEE99809021AR9AA", driver(new String[]{"Andrew",  "Robert", "Lee",   "02-September-1981", "M"}));
  }
}