package InClass.Generics;

public class Point <T> {
    
    T x;
    T y;

    Point(T x, T y){
        this.x = x;
        this.y = y;
    }

    public void setX(T x){
        this.x = x;
    }
    public T getX(){
        return x;
    }

    public void setY(T y){
        this.y = y;
    }
    public T getY(){
        return y;
    }

    static String sqLength(Point<? extends Number> p){

        Number nx =  p.getX();
        Number ny =  p.getY();

        double x = nx.doubleValue();
        double y = ny.doubleValue();

        return "Coordinates: "+ x*x +", " + y*y;
    }

    @Override
    public String toString() {
        return "Coordinates: "+ x+", "+y;
    }

    public static void main(String[] args) {
        
        Point<? extends Number> p = new Point<>(3, 4);
        System.out.println(p.toString());
        System.out.println(sqLength(p));
    }
}
