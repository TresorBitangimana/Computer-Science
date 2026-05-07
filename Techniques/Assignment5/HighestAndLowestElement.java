package Assignment5;

public class HighestAndLowestElement <T extends Comparable<T>> {
    
    private T[] list; 

    public HighestAndLowestElement(T[] array){
        list = array;
    } 

    public T highest(){
        if(list.length > 0){

            T highest = list[0];

            for(int i = 0; i < list.length; i++){
                if(highest.compareTo(list[i]) < 0){
                    highest = list[i];
                }
            }
            return highest;
        }
        else{
            return null;
        }
    }

    public T lowest(){


        if(list.length > 0){

            T lowest = list[0]; 

            for(int i = 0; i < list.length; i++){
                if(lowest.compareTo(list[i]) > 0){
                    lowest = list[i];
                }
            }

            return lowest;
        }
        else{
            return null;
        }
    }


    //demo

    public static void main(String[] args){

        Integer[] numbers = {1,2,3,75,2,86,23,93,25,66,83,2,5};

        HighestAndLowestElement<Integer> data = new HighestAndLowestElement<>(numbers);

        System.out.println(data.highest());
        System.out.println(data.lowest());

        String[] strings = {"Hello", "World", "Code", "code", "hello", "word"};

        HighestAndLowestElement<String> Sdata = new HighestAndLowestElement<>(strings);

        System.out.println(Sdata.highest());
        System.out.println(Sdata.lowest());

    }
}
