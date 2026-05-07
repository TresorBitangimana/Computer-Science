package Assignment5;

import java.util.ArrayList;

public class PointList<T extends Point<?>> extends Point<T> {

    private ArrayList<T> pointList;

    public PointList() {
        super();
        pointList = new ArrayList<>();
    }

    public void add(T value) {
        pointList.add(value);
    }

    public T get(int index) {

        if (index < 0 || index >= pointList.size()) {
            // System.out.println("Out of Bounds");
            return null;
        } else {
            return pointList.get(index);
        }
    }

    @Override
    public String toString() {
        return pointList.toString();
    }

    // demo
    public static void main(String[] args) {

        PointList<Point<Number>> points = new PointList<>();

        points.add(new Point<Number>(10, 5));
        points.add(new Point<Number>(1, 9));
        points.add(new Point<Number>(2, 8));
        points.add(new Point<Number>(3, 7));
        points.add(new Point<Number>(4, 6));
        points.add(new Point<Number>(5, 5));

        System.out.println(points.get(0));
        System.out.println(points.get(1));
        System.out.println(points.get(2));
        System.out.println(points.get(3));

        System.out.println(points.toString());

    }

}
