public class Node{
 private Integer data;
 private Node next,prev;
 public Node(Integer n){
   data = n;
 }
 public void setData(Integer n){
   data = n;
 }
 public Node next(){
   return next;
 }
 public Node prev(){
   return prev;
 }
 public void setNext(Node n){
   next = n;
 }
 public void setPrev(Node n){
   prev = n;
 }
 public Integer getData(){
   return data;
 }
 public String toString(){
   return "" + data;
 }
}
