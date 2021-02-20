package bank;

/** Abstract "Bank Account" class that implements IAccount. */
public abstract class AbstractAccount implements IAccount {
  protected double balance;
  protected boolean penalty;

  /**
   * Return a string representation of the object.
   *
   * @return string representation
   */
  public String toString() {
    return String.format("$%.2f", this.balance);
  }

  @Override
  public double getBalance() {
    return this.balance;
  }

  @Override
  public void deposit(double amount) throws IllegalArgumentException {
    if (amount < 0) {
      throw new IllegalArgumentException("Deposit amount cannot be negative.");
    }
    this.balance += amount;
  }
}
