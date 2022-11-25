import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;


class HackerRankSolution {

    static Scanner sc = new Scanner(System.in);

    void currencyShower(){
        double currency=sc.nextDouble();
        NumberFormat china = NumberFormat.getCurrencyInstance(Locale.CHINA);
        NumberFormat us=NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat france=NumberFormat.getCurrencyInstance(Locale.FRANCE);
        NumberFormat india=NumberFormat.getCurrencyInstance(new Locale("en","IN"));

        System.out.println("US: "+us.format(currency));
        System.out.println("India: "+india.format(currency));
        System.out.println("China: "+china.format(currency));
        System.out.println("France: "+france.format(currency));

    }

    String dateToDay(int day, int month, int year){
//        Calendar calendar=Calendar.getInstance();
//        calendar.set(day,month,year);
        return LocalDate.of(year,month,day).getDayOfWeek().toString();
    }

    // Static block practice.
    static int h;
    static int b;
    static boolean boolVar;
    static {
        b= 3;
        h=-6;
        if(b >= -100 && b <= 100 && h >= -100 && h <= 100){
            if(b <= 0 || h <= 0){
                System.out.println("java.lang.Exception: Breadth and height must be positive");
                boolVar=true;
            }
            if(boolVar != true){
                System.out.println(b*h);
            }
        }
    }

    void endOfFile(){
        int i=0;
        while(sc.hasNext()){
            String line=sc.nextLine();
            System.out.println(++i +" "+line);
        }
    }

    void primitiveProgram(){
        /*
        * Java has 8 primitive data types; char, boolean, byte, short, int, long, float, and double.
        * For this exercise, we'll work with the primitives used to hold integer values (byte, short, int, and long):
            A byte is an 8-bit(1 byte) signed integer.
            A short is a 16-bit(2 byte) signed integer.
            An int is a 32-bit(4 byte) signed integer.
            A long is a 64-bit(8 byte) signed integer.
        * */

        int n=sc.nextInt();

        for (int num=0 ; num < n ; num ++){
            try{
                long input=sc.nextLong();
                // -128 to 127
                System.out.println("can be fitted in:");
                if(input >= -128 && input <= 127){
                    System.out.println("* byte");
                }
                //-32,768 to 32,767
                if(input >= -32768 && input <= 32767){
                    System.out.println("* short");
                }
                //  -2,147,483,648 to 2,147,483,647
                if(input >= -2147483648 && input <= 2147483647){
                    System.out.println("* int");
                }
                // -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
                if(input >= -9223372036854775808L && input <= 9223372036854775807L) {
                    System.out.println("* long");
                }

            }
            catch (Exception e){
                System.out.println(sc.next()+" can't be fitted anywhere.");
            }
        }
    }
    void ifElseProgram(){
        int N=29;
        if(N > 1 && N <= 100){
            if(N >= 6 && N <= 20){
                System.out.println("Weird"+N);
            }
            else {
                System.out.println("Not Weird"+N);
            }
        }
    }

    void  tableLogic() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int tableFactor = Integer.parseInt(bufferedReader.readLine().trim());
        System.out.println("Table\n");
        for(int i=1 ; i <= 10 ;i++){
            System.out.println(tableFactor+" x "+i+" = "+tableFactor*i);
        }
        bufferedReader.close();
    }

    void queryToSeries(){
        int querySize=sc.nextInt();
        for(int query=0 ; query < querySize ; query++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            int n=sc.nextInt();
            int queryCalc=a;
            for(int step = 0; step < n ; step ++){
                queryCalc+=Math.pow(2,step)*b;
                System.out.print(queryCalc+" ");
            }

            System.out.println();
        }
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        HackerRankSolution ans=new HackerRankSolution();
//        ans.ifElseProgram();
//        ans.tableLogic();
//        ans.queryToSeries();
//        ans.primitiveProgram();
//        ans.endOfFile();
//        System.out.println("Day is  "+ans.dateToDay(17,10,2022)+" on 17/10/2022 .");
        ans.currencyShower();
        // Use of nextLine() method
//        int i=sc.nextInt();
//        sc.nextLine();
//        String Input = sc.nextLine();
//        System.out.println(Input);

//        int B = sc.nextInt();
//        int H = sc.nextInt() ;
//
//        if(B >= -100 && B <= 100 && H >= -100 && H <= 100){
//            if(B > 0 && H > 0){
//                System.out.println(B*H);
//            }
//            else{
//                System.out.println("java.lang.Exception: Breadth and height must be positive");
//            }
//        }
//        Scanner sc= new Scanner(System.in);
//        int i=sc.nextInt();
//        double d=sc.nextDouble();
//        String s=sc.nextLine();
//
//        System.out.println("ffff"+s);

    }
}