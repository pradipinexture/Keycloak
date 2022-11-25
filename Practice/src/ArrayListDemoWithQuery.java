import sun.plugin2.message.JavaScriptCallMessage;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListDemoWithQuery {
    public static void main(String args[]){
        Scanner scanner=new Scanner(System.in);
        ArrayList<ArrayList> numLines=new ArrayList<>();
        // get number of raws
        System.out.print("\nPlease enter number of rows : ");
        int row=scanner.nextInt();

        for(int i=0; i< row ; i++){
            System.out.print("\nPlease enter number of elements in "+(i+1)+"  row : ");
            int numOfElements=scanner.nextInt();
            ArrayList<Integer> rowElements=new ArrayList<>();
            System.out.println("\nPlease enter all elements one by one : ");
            for (int element=0 ; element < numOfElements ; element ++){
                rowElements.add(scanner.nextInt());
            }
            numLines.add(rowElements);
        }

        for(int i=0; i< numLines.size() ; i++){
            System.out.println();
            for (int element=0 ; element < numLines.get(i).size() ; element ++){
                System.out.print(" "+numLines.get(i).get(element));
            }
        }

        // Now query logic
        System.out.print("\nPlease enter number of queries : ");
        int querys=scanner.nextInt();

        for(int i=0; i< querys ; i++){
            System.out.print("\nPlease enter x value : ");
            int x=scanner.nextInt()-1;
            System.out.print("\nPlease enter y value : ");
            int y=scanner.nextInt()-1;

            if(x < numLines.size() && y < numLines.get(x).size()){
                System.out.println("\n=> yth position at xth line element is : "+numLines.get(x).get(y));
            }
            else {
                System.out.println("\n=> Eroor of index out of bound.");
            }
        }
    }
}
