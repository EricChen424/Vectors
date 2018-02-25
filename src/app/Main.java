package app;

import model.ThreeDimensionalVector;

/**
 * Created by Eric on 01/10/2015.
 */
public class Main {
    public static void main(String[] args) {
        ThreeDimensionalVector v1 = new ThreeDimensionalVector(1/Math.sqrt(2), -1/Math.sqrt(2), 1);
        ThreeDimensionalVector v2 = new ThreeDimensionalVector(-2*Math.sqrt(2), -2*Math.sqrt(2), 0);

        printProperties(v1, v2);
    }

    /**
     * prints the cross product, dot product, magnitudes, and angle between v1 and v2
     * @param v1 the first vector
     * @param v2 the second vector
     */
    private static void printProperties(ThreeDimensionalVector v1, ThreeDimensionalVector v2){
        System.out.println("First Vector Magnitude: " + v1.magnitude());
        System.out.println("Second Vector Magnitude: " + v2.magnitude());
        System.out.println("Cross Product: " + ThreeDimensionalVector.crossProduct(v1, v2));
        System.out.println("Dot Product: " + ThreeDimensionalVector.dotProduct(v1, v2));
        System.out.println("Angle (Radians): " + ThreeDimensionalVector.angleBetweenRadians(v1, v2));
        System.out.println("Angle (Degrees): " + ThreeDimensionalVector.angleBetweenDegrees(v1, v2));
    }
}
