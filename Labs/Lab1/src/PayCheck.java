/**
 * The PayCheck class represents a weekly paycheck for an employee and can calculate the total
 * payment owed.
 */
public class PayCheck {
  private final double payRate;
  private final double hours;
  private final double totalPay;

  /**
   * Creates a PayCheck instance.
   *
   * @param employee the employee object the PayCheck is associated with.
   * @param hours the number of hours the employee worked.
   */
  public PayCheck(Employee employee, double hours) {
    String name = employee.toString();
    this.payRate = employee.getPayRate();
    this.hours = hours;
    this.totalPay = getTotalPay();
  }

  /**
   * Calcualtes the total pay for the number of hours worked. If the num hours is <= 40, calculate
   * pay normally. If the num hours is >40, add overtime.
   *
   * @return the total payment owed to the employee for this paycheck
   */
  private double getTotalPay() {
    double pay;
    double ot;
    if (this.hours <= 40) {
      pay = payRate * hours;
    } else {
      pay = payRate * 40;
      ot = (1.5 * payRate) * (hours - 40);
      pay += ot;
    }
    return pay;
  }

  /**
   * Create a string representation of the PayCheck.
   *
   * @return S
   * tring representation
   */
  public String toString() {
    return String.format("$%.2f", this.totalPay);
  }
}
