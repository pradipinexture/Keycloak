package collection;

import java.util.ArrayList;
import java.util.List;
/*
* NOTE : (Capital word is interface and camel case word are Implementation of parent interface)
*                                 ITERABLE
*                                   |
*                               COLLECTION
*                     --------------------------------------
*                     |                                    |
*                   LIST                                  SET
*         ---------------------                --------------------------
*         |         |         |                |                        |
*   ArrayList   LinkedList  Vector          HashSet                 SORTEDSET
*                             |                |                        |
*                           Stack           LinkedHashSet           TreeHashSet
*
*
*
* */
public class Collection {
    public static void main(String[] args) {
        ListPractice.listFunction();
        SetPractice.setFunction();
    }
}