/**
 * The Employee class represents an employee that gets a paycheck each week. The total payment
 * depends on the number of hours worked, and the pay rate.
 */
public class Employee {
  private final String name;
  private double hours;
  private double payRate;

  /**
   * Creates an instance of the Employee class.
   *
   * @param name The name of the Employee.
   * @param payRate The hourly pay rate of the employee.
   */
  public Employee(String name, double payRate) {
    this.name = name;
    this.payRate = payRate;
    this.hours = 0;
  }

  /**
   * Adds a specified number of hours to the running total.
   *
   * @param hoursWorked Adds this number of hours to the total.
   */
  public void addHoursWorked(double hoursWorked) {
    this.hours += hoursWorked;
  }

  /** Resets the total number of hours worked to zero. */
  public void resetHoursWorked() {
    this.hours = 0;
  }

  /**
   * Creates a string representation of the object.
   *
   * @return string representation
   */
  public String toString() {
    return this.name;
  }

  /**
   * Gets the pay rate of the Employee instance.
   *
   * @return the pay rate of the employee
   */
  public double getPayRate() {
    return this.payRate;
  }

  /**
   * Gets the current total number of hours the employee has worked.
   *
   * @return the number of hours worked
   */
  public double getHours() {
    return this.hours;
  }

  /**
   * Create an instance of a PayCheck object that can calcualte how much the employee will be paid.
   *
   * @return PayCheck object for the nu
   *
   *
   * mber of hours worked.
   */
  public PayCheck getWeeklyCheck() {
    PayCheck check;
    check = new PayCheck(this, this.hours);
    this.resetHoursWorked(); // Reset the hours worked so the employee doesn't get double paid!
    return check;
  }
}
