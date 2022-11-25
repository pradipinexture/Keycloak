import java.util.Arrays;
import java.util.stream.Collectors;

class FunctionClass{
    public String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";

        smallest=s.substring(0,k);
        largest=s.substring(0,k);

        for (int i=0;i <= s.length()-k; i++){
            String newString = s.substring(i,k+i);
            if (smallest.compareTo(newString) > 0){
                smallest=newString;
            }
            if (largest.compareTo(newString) < 0){
                largest=newString;
            }
//            System.out.println(newString);
        }

        return smallest + "\n" + largest;
    }

    String palindrome(String s){
        int n=s.length()-1;
        for(int i=0;i<n/2;i++){
            if(s.charAt(i) != s.charAt(n-i)){
                return "No";
            }
        }
        return "Yes";
    }

    String isAnagram(String firstString, String secondString){
        char[] firstArr=firstString.toLowerCase().toCharArray();
        char[] secondArr=secondString.toLowerCase().toCharArray();

        if(Arrays.equals(firstArr,secondArr)){
            return  "Anagrams";
        }
        return "Not Anagrams";
    }

    void  stringTokens(String s){
        String[] split = s.split("[!,?._'@ ]");
        split = Arrays.asList(split).stream().filter(str -> !str.isEmpty()).collect(Collectors.toList()).toArray(new String[0]);
        System.out.println(split.length);
        for(String ss:split){
                System.out.println(ss);
        }
    }
}

public class LexicographicalOrder {
    public static void main(String[] args) {
        FunctionClass functionClass=new FunctionClass();
        System.out.println(functionClass.getSmallestAndLargest("Pradip",3));
        System.out.println("\n\n=> Is String palindrome : "+functionClass.palindrome("madamk"));
        System.out.println("\n\n=> Strings are : "+functionClass.isAnagram("hfllo","Hello"));
        functionClass.stringTokens("He is a very very  good boy, isn't he?");
    }
}
