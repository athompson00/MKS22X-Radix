public class Radix{
  /*
  public static void radixsort(int[]data){
    MyLinkedList[] buckets = new MyLinkedList[20];
    for (int i = 0; i < data.length)

  }
  */

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
    System.out.println("125");
    System.out.println("" + getDigit(125, 1));
  }
}
