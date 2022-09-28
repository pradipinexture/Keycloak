package collection;

import java.util.*;

public class SetPractice {
    public static void setFunction(){
        hashSetFunction();
        linkedHashSetFunction();
        treeHashSetFunction();
    }

    public static void hashSetFunction(){
        /*
        => HashSet is dynamic
        => Duplicates elements are not allow in set.
        => order not preserve
         */

        System.out.println("\n\n\t\tHashSet Practice");
        System.out.println("\t\t------------------");

        Set<String> set = new HashSet<>();
        set.add("Pradip");
        set.add("Sandip");
        set.add("Rakesh");
        set.add("Haresh");
        set.add("Pradip"); // This pradip is not added
        System.out.println("\n=> HashSet is : "+set);
        System.out.println("\n=> HashSet is : "+set);
        System.out.println("=> HashSet size is : "+set.size());
        System.out.println("=> HashSet have a Pradip  : "+set.contains("Pradip"));
        set.remove("Bhavin");
        System.out.println("=> HashSet after removed bhavin is : "+set);
        System.out.println("=> Is HashSet empty : "+set.isEmpty());
        System.out.println("=> Is HashSet contains Pradip and Sandip : "+set.containsAll(Arrays.asList("Pradip", "Sandip")));
        System.out.println("=> HashSet is : "+set);
        set.clear();
        System.out.println("=> Use clear function HashSet is : "+set);


    }

    public static void linkedHashSetFunction(){
        /*
        => HashSet is dynamic
        => Duplicates elements are not allow in set.
        => order preserve
         */

        System.out.println("\n\n\t\tLinkedHashSet Practice");
        System.out.println("\t\t------------------");
        Set<String> set = new LinkedHashSet<>();
        set.add("Pradip");
        set.add("Sandip");
        set.add("Rakesh");
        set.add("Haresh");
        set.add("Pradip"); // This pradip is not added
        System.out.println("\n=> LinkedHashSet is : "+set);
        System.out.println("\n=> LinkedHashSet is : "+set);
        System.out.println("=> LinkedHashSet size is : "+set.size());
        System.out.println("=> LinkedHashSet have a Pradip  : "+set.contains("Pradip"));
        set.remove("Bhavin");
        System.out.println("=> LinkedHashSet after removed bhavin is : "+set);
        System.out.println("=> Is LinkedHashSet empty : "+set.isEmpty());
        System.out.println("=> Is LinkedHashSet contains Pradip and Sandip : "+set.containsAll(Arrays.asList("Pradip", "Sandip")));
        System.out.println("=> LinkedHashSet is : "+set);
        set.clear();
        System.out.println("=> Use clear function LinkedHashSet is : "+set);


    }

    public static void treeHashSetFunction(){
        /*
        => HashSet is dynamic
        => Duplicates elements are not allow in set.
        => order not preserve
        => Elements are sorted (string and integer)
         */

        System.out.println("\n\n\t\tTreeHashSet Practice");
        System.out.println("\t\t------------------");

        Set<Integer> set = new TreeSet<>();
        set.add(5);
        set.add(333);
        set.add(9980);
        set.add(666);
        set.add(55);
        set.add(11);
        set.add(5);
        System.out.println("\n=> TreeHashSet is : "+set);

    }
}
