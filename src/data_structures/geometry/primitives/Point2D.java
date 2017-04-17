package data_structures.geometry.primitives;

import java.util.Objects;

/**
 * Represents a point in two dimensional space.
 *
 * @author Alexandru Valeanu
 */
public class Point2D {
    /**
     * The "not a point" object.
     */
    public final static Point2D NaP = new Point2D(Double.NaN, Double.NaN);
    /**
     * The "zero" object.
     */
    public final static Point2D ZERO = new Point2D(0, 0);

    /**
     * Unit vectors
     */
    public final static Point2D oneX = new Point2D(1, 0);
    public final static Point2D oneY = new Point2D(0, 1);

    public final double x;
    public final double y;

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point2D(double x){
        this(x, 0);
    }

    public Point2D(){
        this(0, 0);
    }

    /**
     * Returns the Y coordinate of the point.
     *
     * @return The Y coordinate
     */
    public double getX() {
        return x;
    }

    /**
     * Returns the X coordinate of the point.
     *
     * @return The X coordinate
     */
    public double getY() {
        return y;
    }

    /**
     * Add two points in 2-dimensions
     * @param A first point
     * @param B second point
     * @return A + B
     */
    public static Point2D add(Point2D A, Point2D B){
        return new Point2D(A.x + B.x, A.y + B.y);
    }

    public Point2D add(Point2D other){
        return add(this, other);
    }

    /**
     * Subtract two points in 2-dimensions
     * @param A first point
     * @param B second point
     * @return A - B
     */
    public static Point2D subtract(Point2D A, Point2D B){
        return new Point2D(A.x - B.x, A.y - B.y);
    }

    public Point2D subtract(Point2D other){
        return subtract(this, other);
    }

    /**
     * Scale one point by some factor
     * @param A point to be scaled
     * @param factor scaling factor
     * @return A * factor
     */
    public static Point2D multiply(Point2D A, double factor){
        return new Point2D(A.x * factor, A.y * factor);
    }

    public Point2D multiply(double factor){
        return multiply(this, factor);
    }

    /**
     * Determines whether the point is equal to Point.NaP (not a point).
     *
     * @return true, if the point is NaP, false otherwise
     */
    public boolean isNaP() {
        return this == NaP;
    }

    /**
     * Computes the squared euclid distance between two points
     * @param A first point
     * @param B second point
     * @return a positive real number representing the squared euclid distance
     */
    public static double euclidDistanceSquared(Point2D A, Point2D B){
        return (A.x - B.x) * (A.x - B.x) + (A.y - B.y) * (A.y - B.y);
    }

    public double euclidDistanceSquared(Point2D other){
        return euclidDistanceSquared(this, other);
    }

    /**
     * Computes the euclid distance between two points
     * @param A first point
     * @param B second point
     * @return a positive real number representing the euclid distance
     */
    public static double euclidDistance(Point2D A, Point2D B){
        return Math.sqrt(euclidDistanceSquared(A, B));
    }

    public double euclidDistance(Point2D other){
        return euclidDistance(this, other);
    }

    /**
     * Computes the manhattan distance between two points
     * @param A first point
     * @param B second point
     * @return a positive real number representing the manhattan distance
     */
    public static double manhattanDistance(Point2D A, Point2D B){
        return Math.abs(A.x - B.x) + Math.abs(A.y - B.y);
    }

    public double manhattanDistance(Point2D other){
        return manhattanDistance(this, other);
    }

    /**
     * Computes the cross-product between three 2d points
     * The function returns:
     *  < 0 for counter-clockwise (trigonometric)
     *  = 0 for collinear
     *  > 0 for clockwise (anti-trigonometric)
     * @param A first point
     * @param B second point
     * @param C third point
     * @return a real number representing the cross-product between the three points
     */
    public static double crossProduct(Point2D A, Point2D B, Point2D C){
        return (C.x - A.x) * (B.y - A.y) - (C.y - A.y) * (B.x - A.x);
    }

    public static double ccw(Point2D A, Point2D B, Point2D C){
        return crossProduct(A, B, C);
    }

    public static boolean areCollinear(Point2D A, Point2D B, Point2D C){
        return Double.compare(crossProduct(A, B, C), 0) == 0;
    }

    /**
     * Create a new point by rotating A with alpha degrees
     * @param A point to be rotated
     * @param alpha angle in radians
     * @return a new point equal to A rotated by alpha degrees
     */
    public static Point2D rotateWithAngle(Point2D A, double alpha) {
        double cosA = Math.cos(alpha);
        double sinA = Math.sin(alpha);

        return new Point2D(cosA * A.x - sinA * A.y, sinA * A.x + cosA * A.y);
    }

    public Point2D rotateWithAngle(double alpha){
        return rotateWithAngle(this, alpha);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point2D)) return false;
        Point2D point2D = (Point2D) o;
        return Double.compare(point2D.x, this.x) == 0 &&
                Double.compare(point2D.y, this.y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Point2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    /**
     *
     * @param leftMarker left-hand marker
     * @param sep separator
     * @param rightMarker right-hand marker
     * @return formatted string representation of the point
     */
    public String formatToString(String leftMarker, String sep, String rightMarker){
        return leftMarker + x + sep + y + rightMarker;
    }
}
