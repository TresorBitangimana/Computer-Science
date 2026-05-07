package Assignment5;

import java.util.ArrayList;

public class MyList <T extends Comparable<T>> {
    
    //the list field
    private ArrayList<T> list = new ArrayList<>();

    /**
     * add method, adds the value from method perimeter to the list.
     */
    public void add(T value){
        list.add(value);
    }

    /**
     * largest method of return type T
     * iterate through the list find the largest value
     * @return largest value
     */
    public T largest(){

        if(!(list.isEmpty())){
            T largest =  list.get(0);

            //loops through the list to find the largest value
            for(int i = 0; i < list.size(); i++){
                if(list.get(i).compareTo(largest) > 0){
                    largest = list.get(i);
                }
            }
            return largest;
        }
        else{
            return null;
        }
    }

    /**
     * smallest method of return type T
     * iterate through the list find the smallest value
     * @return smallest value
     */
    public T smallest(){
        if(!(list.isEmpty())){
            T smallest = list.get(0);

            //loops through the list to find the smallest value
            for(int i = 0; i < list.size(); i++){
                if(list.get(i).compareTo(smallest) < 0){
                    smallest = list.get(i);
                }
            }

            return smallest;

        }else{
            return null;
        }
    }

    /**
     * main method for testing.
     * @param args
     */
    public static void main(String[] args) {
        
        MyList<Integer> integerList = new MyList<>();

        integerList.add(1);
        integerList.add(5);
        integerList.add(8);
        integerList.add(2);
        integerList.add(3);
        integerList.add(10);

        System.out.println(integerList.largest());
        System.out.println(integerList.smallest());

        MyList<String> stringList = new MyList<>();

        stringList.add("Hello");
        stringList.add("hello");
        stringList.add("World");
        stringList.add("word");
        stringList.add("math");
        stringList.add("code");

        System.out.println(stringList.largest());
        System.out.println(stringList.smallest());
    }

}
