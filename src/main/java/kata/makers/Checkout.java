package kata.makers;

public class Checkout {

  public boolean isValidInput(String input, String delimiter){
    int lastIndex = input.lastIndexOf(delimiter);
    String[] split = input.split(delimiter);

    return split.length>1 && split.length == lastIndex-1;
  }

  public int sum(String input, String delimiter){
    int sum =0;
    if(isValidInput(input, delimiter)){
      String[] split = input.split(delimiter);
      for(String splitChar : split){
        sum += Integer.parseInt(splitChar);
      }
    }
    return sum;
  }
}
