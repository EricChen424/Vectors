package test;

import model.ThreeDimensionalVector;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Eric on 01/10/2015.
 */
public class ThreeDimensionalVectorTest {

    @Test
    public void testConstructor() throws Exception{
        ThreeDimensionalVector v1 = new ThreeDimensionalVector();
        ThreeDimensionalVector v2 = new ThreeDimensionalVector(1, 2, 3);

        assertEquals(0, v1.getX(), 1e-6);
        assertEquals(0, v1.getY(), 1e-6);
        assertEquals(0, v1.getZ(), 1e-6);
        assertEquals(1, v2.getX(), 1e-6);
        assertEquals(2, v2.getY(), 1e-6);
        assertEquals(3, v2.getZ(), 1e-6);
    }

    @Test
    public void testMagnitude() throws Exception {
        ThreeDimensionalVector v = new ThreeDimensionalVector(3, 4, 5);
        assertEquals(Math.sqrt(50), v.magnitude(), 1e-6);
    }

    @Test
    public void testDotProduct() throws Exception {
        assertEquals(32, ThreeDimensionalVector.dotProduct(new ThreeDimensionalVector(1, 2, 3),
                        new ThreeDimensionalVector(4, 5, 6)),
                1e-6);
    }

    @Test
    public void testCrossProduct() throws Exception {
        ThreeDimensionalVector v = new ThreeDimensionalVector();
        ThreeDimensionalVector v1 = new ThreeDimensionalVector(-3, 6, -3);

        assertEquals(v, ThreeDimensionalVector.crossProduct(new ThreeDimensionalVector(1, 2, 3),
                new ThreeDimensionalVector(1, 2, 3)));
        assertEquals(v1, ThreeDimensionalVector.crossProduct(new ThreeDimensionalVector(1, 2, 3),
                new ThreeDimensionalVector(4, 5, 6)));
    }

    @Test
    public void testAngleBetweenRadians() throws Exception {
        assertEquals(0, ThreeDimensionalVector.angleBetweenRadians(new ThreeDimensionalVector(1, 2, 3),
                new ThreeDimensionalVector(1, 2, 3)), 1e-5);
        assertEquals(Math.PI/2, ThreeDimensionalVector.angleBetweenRadians(new ThreeDimensionalVector(0, 5, 0),
                new ThreeDimensionalVector(5, 0, 0)), 1e-5);
    }

    @Test
    public void testAngleBetweenDegrees() throws Exception {
        assertEquals(0, ThreeDimensionalVector.angleBetweenDegrees(new ThreeDimensionalVector(1, 2, 3),
                new ThreeDimensionalVector(1, 2, 3)), 1e-5);
        assertEquals(90, ThreeDimensionalVector.angleBetweenDegrees(new ThreeDimensionalVector(0, 5, 0),
                new ThreeDimensionalVector(5, 0, 0)), 1e-5);
    }
}