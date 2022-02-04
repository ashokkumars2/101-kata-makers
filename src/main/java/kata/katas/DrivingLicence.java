package kata.katas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DrivingLicence {

  public static String driver(final String[] data) throws ParseException {

    String [] date = data[3].split("-");
//    The first five characters of the surname (padded with 9s if less than 5 characters)
    String firstFive = (data[2] + "99999").substring(0, 5).toUpperCase();

//    The decade digit from the year of birth (e.g. for 1987 it would be 8)
//    String decadeDigit = data[3].substring(data[3].length()-2);
    String decadeDigit = String.valueOf(data[3].charAt(data[3].length()-2));

//    The month of birth (7th character incremented by 5 if driver is female i.e. 51–62 instead of 01–12)
//    1. using String.format and substring
    String monthOfBirth = String.format("%02d",
        getMonth(date[1].substring(0, 3)) + (Objects.equals(data[4].strip(), "F") ? 50 : 0));
//    2. using SimpleDateFormat library
//    String monthOfBirth = convertDateUsingSimpleDateFormat(data);
//    3. using calendar library
//    String monthOfBirth = convertDateUsingCalendar(data);
//    4. using if
//    String monthOfBirth = convertDateUsingIf(data);
//    5. using switch
//    String monthOfBirth = convertDateUsingSwitch(data);
//    6. using hash map
//    String monthOfBirth = convertDateUsingMap(data);

//    The date within the month of birth
    String dayOfBirth = date[0];

//    The year digit from the year of birth (e.g. for 1987 it would be 7)
    String yearDigit = date[2].substring(3, 4);

// The first two initials of the first name and middle name, padded with a 9 if no middle name
    String initials = getNamesInitials(data);

//     Arbitrary digit – usually 9, but decremented to differentiate drivers with the first 13 characters in common. We will always use 9
    String arbitraryDigit = "9";

//    Two computer check digits. We will always use "AA"
    String computerCheck = "AA";
    return firstFive + decadeDigit + monthOfBirth + dayOfBirth + yearDigit + initials + arbitraryDigit + computerCheck;

  }

  private static final String[] months = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun",
      "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

  private static Map<String, Integer> monthsMap = new HashMap<>();

  public static String getNamesInitials(final String[] data) {
    String firstName = data[0].substring(0, 1);
    String secondName;
    if (!Objects.equals(data[1], "")) {
      secondName = data[1].substring(0, 1);
    } else {
      secondName = "9";
    }
    return firstName + secondName;
  }

  public static int getMonth(final String m) {

    for (int i = 0; i < months.length; i++) {
      if ( m.equals(months[i])) {
        return i +1;
      }
    }
    return 0;
  }

  public static String convertDateUsingCalendar(final String[] data) {

    Date date = new Date(data[3]);
    LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    int month = localDate.getMonthValue();

    if (Objects.equals(data[4].strip(), "F")) {
      month += 50;
    }
    if (month < 10) {
      return "0" + month;
    }
    return String.valueOf(month);
  }


  public static String convertDateUsingSimpleDateFormat(final String[] data) throws ParseException {

    int month = new SimpleDateFormat("dd-MMM-yyyy").parse(data[3]).getMonth() + 1;

    if (Objects.equals(data[4].strip(), "F")) {
      month += 50;
    }
    if (month < 10) {
      return "0" + month;
    }
    return String.valueOf(month);
  }

  public static Map createHashMap() {
    monthsMap.put("Jan", 1);
    monthsMap.put("Feb", 2);
    monthsMap.put("Mar", 3);
    monthsMap.put("Apr", 4);
    monthsMap.put("May", 5);
    monthsMap.put("Jun", 6);
    monthsMap.put("Jul", 7);
    monthsMap.put("Aug", 8);
    monthsMap.put("Sep", 9);
    monthsMap.put("Oct", 10);
    monthsMap.put("Nov", 11);
    monthsMap.put("Dec", 12);
    return monthsMap;
  }


  public static String convertDateUsingMap(final String[] data) {
    createHashMap();
    int month;
    String [] date = data[3].split("-");

    month = monthsMap.get(date[1].substring(0,2));
    if (Objects.equals(data[4].strip(), "F")) {
      month += 50;
    }
    if (month < 10) {
      return "0" + month;
    }
    return String.valueOf(month);
  }

  public static String convertDateUsingIf(final String[] data) {
    int month;
    if (data[3].contains("Jan") || data[3].contains("January")) {
      month = 1;
    } else if (data[3].contains("Feb") || data[3].contains("February")) {
      month = 2;
    } else if (data[3].contains("Mar") || data[3].contains("March")) {
      month = 3;
    } else if (data[3].contains("Apr") || data[3].contains("April")) {
      month = 4;
    } else if (data[3].contains("May")) {
      month = 5;
    } else if (data[3].contains("Jun") || data[3].contains("June")) {
      month = 6;
    } else if (data[3].contains("Jul") || data[3].contains("July")) {
      month = 7;
    } else if (data[3].contains("Aug") || data[3].contains("August")) {
      month = 8;
    } else if (data[3].contains("Sep") || data[3].contains("September")) {
      month = 9;
    } else if (data[3].contains("Oct") || data[3].contains("October")) {
      month = 10;
    } else if (data[3].contains("Nov") || data[3].contains("November")) {
      month = 11;
    } else {
      month = 12;
    }

    if (Objects.equals(data[4].strip(), "F")) {
      month += 50;
      return String.valueOf(month);
    }
    if (month < 10) {
      return "0" + month;
    }

    return String.valueOf(month);
  }

  public static String convertDateUsingSwitch(final String[] data) {
    String [] date = data[3].split("-");
    int month = 0;
    switch (date[1]) {
      case "Jan":
      case "January":
        month = 1;
        break;
      case "Feb":
      case "February":
        month = 2;
        break;
      case "Mar":
      case "March":
        month = 3;
        break;
      case "Apr":
      case "April":
        month = 4;
        break;
      case "May":
        month = 5;
        break;
      case "Jun":
      case "June":
        month = 6;
        break;
      case "Jul":
      case "July":
        month = 7;
        break;
      case "Aug":
      case "August":
        month = 8;
        break;
      case "Sep":
      case "September":
        month = 9;
        break;
      case "Oct":
      case "October":
        month = 10;
        break;
      case "Nov":
      case "November":
        month = 11;
        break;
      case "Dec":
      case "December":
        month = 12;
        break;
    }

    if (Objects.equals(data[4], "F")) {
      month += 50;
    }
    if (month < 10) {
      return "0" + month;
    }
    return String.valueOf(month);
  }

}

// month in four ways: dateTime library, if, case, map
//7–8: The month of birth (7th character incremented by 5 if driver is female i.e. 51–62 instead of 01–12)

//data = {"John","James","Smith","01-Jan-2000","M"};