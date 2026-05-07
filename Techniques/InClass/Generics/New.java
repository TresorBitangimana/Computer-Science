package InClass.Generics;

public class New <T extends Number, S extends String>{

    T x;
    S y;
    
    New(T x, S y){
        this.x = x;
        this.y = y;
    }

    void printAll(){
        System.out.println(x  +" "+ ""+y);
    }

    public static void main(String[] args){

        New<Double,String> hello = new New<>(50.0, "Hello World");

        hello.printAll();

    }

}
