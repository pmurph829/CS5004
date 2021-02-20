/**
 * The Vector3D class represents a vector in three dimensions. Can be used to perform simple
 * calculations on one or more vector objects.
 */
public class Vector3D {
  private final double x;
  private final double y;
  private final double z;
  private final double magnitude;

  /**
   * Creates a new Vector3D object.
   *
   * @param x the magnitude of the x component of the vector.
   * @param y the magnitude of the y component of the vector.
   * @param z the magnitude of the z component of the vector.
   */
  public Vector3D(double x, double y, double z) {
    this.x = x;
    this.y = y;
    this.z = z;
    this.magnitude = this.getMagnitude();
  }

  /**
   * Creates a string representation of a Vector3D object.
   *
   * @return string representation.
   */
  public String toString() {
    return String.format("(%.2f,%.2f,%.2f)", this.x, this.y, this.z);
  }

  /**
   * Get the x component of the Vector3D object.
   *
   * @return the x component.
   */
  public double getX() {
    return this.x;
  }

  /**
   * Get the y component of the Vector3D object.
   *
   * @return the y component.
   */
  public double getY() {
    return this.y;
  }

  /**
   * Get the z component of the Vector3D object.
   *
   * @return the z component.
   */
  public double getZ() {
    return this.z;
  }

  /**
   * Calculate the magnitude of the entire vector.
   *
   * @return the overall magnitude of the vector.
   */
  public double getMagnitude() {
    double a = Math.pow(this.x, 2);
    double b = Math.pow(this.y, 2);
    double c = Math.pow(this.z, 2);
    return Math.sqrt(a + b + c);
  }

  /**
   * Return a version of the Vector3D object normalized by its magnitude.
   *
   * @return normalized vector.
   * @throws IllegalStateException If the operation is performed on a zero vector.
   */
  public Vector3D normalize() throws IllegalStateException {
    if (this.magnitude == 0) {
      throw new IllegalStateException("Cannot divide by zero");
    }
    return new Vector3D(this.x / this.magnitude, this.y / this.magnitude, this.z / this.magnitude);
  }

  /**
   * Add two vectors together and return the resultant vector.
   *
   * @param other the other vector to add.
   * @return the resultant vector.
   */
  public Vector3D add(Vector3D other) {
    return new Vector3D(this.x + other.x, this.y + other.y, this.z + other.z);
  }

  /**
   * Multiply the vector by a scalar factor.
   *
   * @param factor the scalar value to multiply the vector by.
   * @return the result of multiplying the vector.
   */
  public Vector3D multiply(double factor) {
    return new Vector3D(this.x * factor, this.y * factor, this.z * factor);
  }

  /**
   * Calculates the dot product of two Vector3D objects.
   *
   * @param other the other vector.
   * @return the dot product of the two vectors.
   */
  public double dotProduct(Vector3D other) {
    return (this.x * other.x) + (this.y * other.y) + (this.z * other.z);
  }

  /**
   * Calculate the angle between two Vector3D objects.
   *
   * @param other the other vector used to calculate the angle.
   * @return the angle between the two vectors in degrees.
   * @throws IllegalStateException if the operation is called on a zero vector.
   */
  public double angleBetween(Vector3D other) throws IllegalStateException {
    if (this.magnitude == 0 || other.getMagnitude() == 0) {
      throw new IllegalStateException("Cannot calculate angle of zero vector");
    }
    double a = dotProduct(other);
    double h = (this.getMagnitude() * other.getMagnitude());
    double theta = Math.acos(a / h);
    return Math.toDegrees(theta);
  }
}
