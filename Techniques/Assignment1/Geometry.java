/**
 * @author Tresor Bitangimana
 * @since Jan 16 /2026
 */

public class Geometry{

    /**
     *  solves for the area of the circle using the equation pi*r^2
     * @param r
     * @return circle area
     */
    public double circleArea(double r){
        return (Math.PI)*(Math.pow(r, 2));
    }

    /**
     *  solves fo rthe area of the rectangle using the equation length * width
     * @param len
     * @param w
     * @return rectangle area
     */
    public double reactangleArea(double len, double w){
        return len * w;
    }

    /**
     *  solves for the area of the triangle using the equation 1/2*b*h
     * @param base
     * @param h
     * @return triangle area
     */
    public double triangleArea(double base, double h){
        return .5*(base * h);
    }

    public static void main(String[] args){

        Geometry geometry = new Geometry();

        System.out.println(geometry.circleArea(5));
        System.out.println(geometry.reactangleArea(2, 2));
        System.out.println(geometry.triangleArea(2, 2));

    }

}