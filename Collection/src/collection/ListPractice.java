package collection;

import java.util.*;
import java.util.stream.Collectors;

public class ListPractice {

    public static void listFunction(){
        arrayListFunction();
        linkedListFunction();
        vectorFunction();
    }
    public static void arrayListFunction(){

        /*
        => Arraylist is dynamic and non thread safe(two thread at a time acces arraylist)
        => Duplicates elements are allow in arraylist.
        => order preserve
         */

        System.out.println("\n\n\t\tArrayList Practice");
        System.out.println("\t\t------------------");

        // 1. Type safe collection
        List<String> stringList=new ArrayList<>();
        stringList.add("Sandip");
        stringList.add("Bhavin");
        stringList.add("Pradip");
        stringList.add("Sandip");
        stringList.add("Bhavin");
        System.out.println("=> ArrayList is : "+stringList);
        System.out.println("=> ArrayList size is : "+stringList.size());
        System.out.println("=> ArrayList have a Pradip  : "+stringList.contains("Pradip"));
        stringList.remove("Bhavin");
        System.out.println("=> ArrayList after removed bhavin is : "+stringList);
        System.out.println("=> Is arraylist empty : "+stringList.isEmpty());
        System.out.println("=> Is arraylist contains Pradip and Sandip : "+stringList.containsAll(Arrays.asList("Pradip", "Sandip")));
        System.out.println("=> ArrayList is : "+stringList);
        stringList.set(3,"Jignesh");
        System.out.println("=> Set at 3rd place Jingesh : "+stringList);
        stringList.add(2,"Nirav");
        System.out.println("=> Set at 2nd place Nirav : "+stringList);
        stringList.clear();
        System.out.println("=> Use clear function arraylist is : "+stringList);

        // 2. not Type safe collection
        List stringList1=new ArrayList<>();
        stringList1.add("Pradip");
        stringList1.add(22);
        stringList1.add(true);
        stringList1.add(100.66);
        System.out.println("=> Untype safe ArrayList is : "+stringList1);
    }

    public static void linkedListFunction(){

        /*
        => Linkedlist is doubly list
        => Duplicates elements are allow in arraylist.
        => order preserve
         */

        System.out.println("\n\n\t\tLinkedList Practice");
        System.out.println("\t\t--------------------");

        // 1. Type safe collection
        List<String> stringList=new LinkedList<>();
        stringList.add("Sandip");
        stringList.add("Bhavin");
        stringList.add("Pradip");
        stringList.add("Sandip");
        stringList.add("Bhavin");
        System.out.println("=> linkedlist is : "+stringList);
        System.out.println("=> linkedlist size is : "+stringList.size());
        System.out.println("=> linkedlist have a Pradip  : "+stringList.contains("Pradip"));
        stringList.remove("Bhavin");
        System.out.println("=> linkedlist after removed bhavin is : "+stringList);
        System.out.println("=> Is linkedlist empty : "+stringList.isEmpty());
        System.out.println("=> Is linkedlist contains Pradip and Sandip : "+stringList.containsAll(Arrays.asList("Pradip", "Sandip")));
        System.out.println("=> linkedlist is : "+stringList);
        stringList.set(3,"Jignesh");
        System.out.println("=> Set at 3rd place Jingesh : "+stringList);
        stringList.add(2,"Nirav");
        System.out.println("=> Set at 2nd place Nirav : "+stringList);
        stringList.clear();
        System.out.println("=> Use clear function linkedlist is : "+stringList);

        // 2. not Type safe collection
        List stringList1=new LinkedList<>();
        stringList1.add("Pradip");
        stringList1.add(22);
        stringList1.add(true);
        stringList1.add(100.66);
        System.out.println("=> Untype safe ArrayList is : "+stringList1);
    }

    public static void vectorFunction(){

        /*
        => Vector is dynamic array
        => Duplicates elements are allow in Vector.
        => order preserve
         */

        System.out.println("\n\n\t\tVector Practice");
        System.out.println("\t\t------------------");

        // 1. Type safe collection
        List<String> stringList=new Vector<>();
        stringList.add("Sandip");
        stringList.add("Bhavin");
        stringList.add("Pradip");
        stringList.add("Sandip");
        stringList.add("Bhavin");
        System.out.println("=> Vector is : "+stringList);
        System.out.println("=> Vector size is : "+stringList.size());
        System.out.println("=> Vector have a Pradip  : "+stringList.contains("Pradip"));
        stringList.remove("Bhavin");
        System.out.println("=> Vector after removed bhavin is : "+stringList);
        System.out.println("=> Is Vector empty : "+stringList.isEmpty());
        System.out.println("=> Is Vector contains Pradip and Sandip : "+stringList.containsAll(Arrays.asList("Pradip", "Sandip")));
        System.out.println("=> Vector is : "+stringList);
        stringList.set(3,"Jignesh");
        System.out.println("=> Set at 3rd place Jingesh : "+stringList);
        stringList.add(2,"Nirav");
        System.out.println("=> Set at 2nd place Nirav : "+stringList);
        stringList.clear();
        System.out.println("=> Use clear function vector is : "+stringList);
    }
}
