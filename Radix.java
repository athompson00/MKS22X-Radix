import java.util.*;
public class Radix{

  public static void radixsort(int[]data){
    MyLinkedList[] buckets = new MyLinkedList[20];
    MyLinkedList temp = new MyLinkedList();
    int max = data[0];
    for (int i = 0; i < data.length; i++){
      if (data[i] > max){
        max = data[i];
      }
    }
    int digit = 0;
    int maxDigits = countDigits(max);

    while (digit < maxDigits){
      for (int i = 0; i < temp.size(); i++){
        int value = temp.remove(0);
        if (value <= 0){
          buckets[9 - getDigit(value, digit)].add(value);
        } else {
          buckets[10 + getDigit(value, digit)].add(value);
        }
      }
      for (int i = 0; i < buckets.length; i ++){
        if (buckets[i] != null){
          while (buckets[i].size() > 0){
            temp.add(buckets[i].remove(0));
          }
        }
      }
      digit++;
      max = max / 10;
    }

    System.out.println(temp.toString());
    for (int i = 0; i < data.length; i++){
      data[i] = temp.remove(0);
    }

  }

  public static int countDigits(int n){
    int ans = 0;
    while (n >= 10){
      n = n / 10;
      ans++;
    }
    return ans + 1;
  }


  public static int getDigit(int number, int digit){
    for (int i = 0; i < digit; i++){
      number = number / 10;
    }
    if (!(number < 10)){
      return number % 10;
    } else {
      return number;
    }
  }

  public static void main(String[] args){
    int[] test = {92, 34, 21, 78, 34, 96, 28};

    System.out.println(Arrays.toString(test));

    radixsort(test);

    System.out.println(Arrays.toString(test));
  }
}
