package InClass.Generics;

public class Point3D <T extends Number> extends Point<T>{

    T z;

    Point3D(T x, T y, T z){
        super(x, y);
        this.z  = z;
    }

    public void setZ(T z){
        this.z = z;
    }
    public T getZ(){
        return z;
    }

    double sqLength(){

        double x1 = x.doubleValue();
        double y1 = y.doubleValue();

        return x1 * y1;
    }

}
