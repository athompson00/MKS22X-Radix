import java.util.*;
public class Radix{

  public static void radixsort(int[]data){
    if (data.length == 0){
      return;
    }
    MyLinkedList[] buckets = new MyLinkedList[20];
    MyLinkedList temp = new MyLinkedList();
    int max = data[0];
    for (int i = 0; i < data.length; i++){
      if (data[i] > max){
        max = data[i];
      }
    }

    for (int i = 0; i < buckets.length; i++){
      buckets[i] = new MyLinkedList();
    }
    int digit = 0;
    int maxDigits = countDigits(max);

    for (int i = 0; i < data.length; i++){
      temp.add(data[i]);
    }
    //System.out.println(temp.toString());

    while (digit < maxDigits){
      int otherSize = temp.size();
      for (int i = 0; i < otherSize; i++){
        int value = temp.remove(0);
        System.out.println("" + value);
        if (value <= 0){
          buckets[9 + getDigit(value, digit)].add(value);
        } else {
          buckets[10 + getDigit(value, digit)].add(value);
        }
      }
      System.out.println(Arrays.toString(buckets));
      for (int i = 0; i < buckets.length; i ++){
        int sizeler = buckets[i].size();
          while (sizeler > 0){
            int value = buckets[i].remove(0);
            temp.add(value);
            sizeler--;
        }
      }
      System.out.println(temp.toString());
      for (int i = 0; i < buckets.length; i++){
        buckets[i] = new MyLinkedList();
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
    if (!(number < 10 && number > -10)){
      return number % 10;
    } else {
      return number;
    }
  }

  public static void main(String[] args){
    int[] test = {92, -34, 21, -78, 34, 96, 28};

    System.out.println(Arrays.toString(test));

    radixsort(test);

    System.out.println(Arrays.toString(test));
    //System.out.println(getDigit(-91, 0));
  }
}
