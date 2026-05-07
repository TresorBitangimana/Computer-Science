package Assignment5;

public class NumberAnalyzer <T extends Number> {
    
    private T[] list;

    public NumberAnalyzer(T[] array){
        list = array;
    }

    public T highest(){
        // if(list.length > 0){

            T highest = list[0];

            for(int i = 1; i < list.length; i++){
                if(highest.doubleValue() < list[i].doubleValue()){
                    highest = list[i];
                }
            }
            return highest;
        // }
        // else{
        //     return null;
        // }
    }

    public T lowest(){


        // if(list.length > 0){

            T lowest = list[0]; 

            for(int i = 1; i < list.length; i++){
                if(lowest.doubleValue() > list[i].doubleValue()){
                    lowest = list[i];
                }
            }

            return lowest;
        // }
        // else{
        //     return null;
        // }
    }

    public double total(){

        double total = 0;
        if(list.length > 0){
            for(int i = 0; i < list.length; i++){
                total = total + list[i].doubleValue();
            }
            return total;
        }
        else{
            return 0;
        }
    }

    public double average(){
        if(list.length > 0){

            int counter = 0;
            double sum = 0;

            for(int i = 0; i < list.length; i++){
                sum = sum + list[i].doubleValue();
                counter++;
            }
            sum = sum/counter;
            return sum;
        }
        else{
            return 0;
        }
    }

    //demo
    public static void main(String[] args) {
        
                Integer[] numbers = {1,2,3,75,2,86,23,93,25,66,83,2,5};

        NumberAnalyzer<Integer> data = new NumberAnalyzer<>(numbers);

        System.out.println("Highest: "+data.highest());
        System.out.println("Lowest: "+data.lowest());
        System.out.println("Total: "+data.total());
        System.out.println("Average: "+data.average());



    }

}
