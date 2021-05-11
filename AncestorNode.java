import java.util.*;
public class AncestorNode{
   public static void main(String args[]){
      Scanner x = new Scanner(System.in);
      int[] a = {10,11,12,13,14,15};
      System.out.print("Enter the element whose Ancestor is to be found :");
      int num = x.nextInt();
      int k = -1;
      for(int i = 0; i<a.length; i++){
         if(a[i]==num){
            k = i;
         }
      }
      if(index!=-1){
         System.out.print("\nThe ancestor node of "+num+" is:");
         find_ancestor(a,k);
      }
      else{
         System.out.print("\nEntered number is not present");
      }
   }
   public static void find_ancestor(int[] a, int k){
          if(index==0){
            System.out.print("\nIt is the root node");
          }
          else if(index%2!=0){
            System.out.print(a[k/2]);
          }
          else if(index%2==0 && k!=0)
            System.out.print(a[k/2-1]);
   }
   
}