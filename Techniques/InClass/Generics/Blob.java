//Generic class

package InClass.Generics;

public class Blob <T>{
    
    T value;

    void set(T value){
        this.value = value;
    }

    T get(){
        return value;
    }


    public static void main(String[] args) {
        
        Blob<String> b1 = new Blob<>();
        b1.set("Bob");
        System.out.println(b1.get());

        Blob<Integer> b2 = new Blob<>();
        b2.set(10);
        System.out.println(b2.get());

    }
}
