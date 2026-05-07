package Assignment5.Algorithm_Workbench;

public class MyType <T extends Number> {



    
    public static <T extends Comparable<T>> T max(T a, T b){

        if (a.compareTo(b) > 0)
            return a;
        else
        return b;
    }



}
