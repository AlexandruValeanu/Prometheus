package data_structures.geometry.primitives;

import java.util.Objects;

public class Vector2D {
    private final double x;
    private final double y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     *
     * @return the squared magnitude of current point (vector)
     */
    public double getNormSquared(){
        return x * x + y * y;
    }

    /**
     *
     * @return the magnitude of current point (vector)
     */
    public double getNorm(){
        return Math.sqrt(getNormSquared());
    }

    public static double dotProduct(Vector2D A, Vector2D B){
        return A.x * B.y - A.y * B.x;
    }

    public double dotProduct(Vector2D other){
        return dotProduct(this, other);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vector2D)) return false;
        Vector2D vector2D = (Vector2D) o;
        return Double.compare(vector2D.x, this.x) == 0 &&
                Double.compare(vector2D.y, this.y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Vector2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
