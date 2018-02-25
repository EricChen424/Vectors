package model;

/**
 * Created by Eric on 01/10/2015.
 */
public class ThreeDimensionalVector {

    double x;
    double y;
    double z;

    /**
     * Constructor
     * Constructs a 0 vector
     */
    public ThreeDimensionalVector(){
        x = 0;
        y = 0;
        z = 0;
    }

    /**
     * Constructor
     * Constructs a 3D vector with the given x, y, and z components
     * @param x the x component
     * @param y the y component
     * @param z the z component
     */
    public ThreeDimensionalVector(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * calculates the dot product between v1 and v2
     * @param v1 the first vector
     * @param v2 the second vector
     * @return dot product between v1 and v2
     */
    public static double dotProduct(ThreeDimensionalVector v1, ThreeDimensionalVector v2){
        double xProduct = v1.getX() * v2.getX();
        double yProduct = v1.getY() * v2.getY();
        double zProduct = v1.getZ() * v2.getZ();
        return xProduct + yProduct + zProduct;
    }

    /**
     * calculates the cross product between v1 and v2
     * @param v1 the first vector
     * @param v2 the second vector
     * @return cross product between v1 and v2
     */
    public static ThreeDimensionalVector crossProduct(ThreeDimensionalVector v1, ThreeDimensionalVector v2){
        // <a2b3 - a3b2, a3b1 - a1b3, a1b2 - a2b1>
        double xComponent = (v1.getY() * v2.getZ()) - (v1.getZ() * v2.getY());
        double yComponent = (v1.getZ() * v2.getX()) - (v1.getX() * v2.getZ());
        double zComponent = (v1.getX() * v2.getY()) - (v1.getY() * v2.getX());
        return new ThreeDimensionalVector(xComponent, yComponent, zComponent);
    }

    /**
     * finds the angle between v1 and v2 in radians
     * @param v1 the first vector
     * @param v2 the second vector
     * @return angle between v1 and v2 in radians
     */
    public static double angleBetweenRadians(ThreeDimensionalVector v1, ThreeDimensionalVector v2){
        // dotProduct = |v1||v2|cos(theta)
        double dotProduct = ThreeDimensionalVector.dotProduct(v1, v2);
        double cosTheta = dotProduct/(v1.magnitude() * v2.magnitude());
        return Math.acos(cosTheta);
    }

    /**
     * finds the angle between v1 and v2 in degrees
     * @param v1 the first vector
     * @param v2 the second vector
     * @return angle between v1 and v2 in degrees
     */
    public static double angleBetweenDegrees(ThreeDimensionalVector v1, ThreeDimensionalVector v2){
        double angleRadians = ThreeDimensionalVector.angleBetweenRadians(v1, v2);
        return (angleRadians/(Math.PI * 2)) * 360;
    }

    // setters
    public void setX(double x){
        this.x = x;
    }

    public void setY(double y){
        this.y = y;
    }

    public void setZ(double z){
        this.z = z;
    }

    // getters
    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public double getZ(){
        return z;
    }

    /**
     * calculates the length of this vector
     * @return the length of this
     */
    public double magnitude(){
        return Math.sqrt((x*x) + (y*y) + (z*z));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ThreeDimensionalVector that = (ThreeDimensionalVector) o;

        if (Double.compare(that.x, x) != 0) return false;
        if (Double.compare(that.y, y) != 0) return false;
        return Double.compare(that.z, z) == 0;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(z);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString(){
        return "<" + x + ", " + y + ", " + z + ">";
    }
}
