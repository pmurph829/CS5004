package bank;

/** Class for representing a checking bank account. */
public class CheckingAccount extends AbstractAccount {
  /** fee is the amount that monthly maintenance will charge if there is an outstanding penalty. */
  private final double fee;

  /**
   * Construct a CheckingAccount object with a given starting balance. If the starting balance is
   * less than 100, a penalty will be applied during monthly maintenance.
   *
   * @param starterAmount the initial amount to deposit into the account.
   * @throws IllegalArgumentException If the starting amount is less than $0.01.
   */
  public CheckingAccount(double starterAmount) throws IllegalArgumentException {
    if (starterAmount <= 0.01) {
      throw new IllegalArgumentException("Starting amount cannot be below one cent.");
    }
    this.balance = starterAmount;
    if (this.balance < 100) {
      this.penalty = true;
    }
    this.fee = 5.00;
  }

  @Override
  public boolean withdraw(double amount) throws IllegalArgumentException {
    if (amount < 0) {
      return false;
    } else if (amount > this.balance) {
      return false;
    } else {
      this.balance -= amount;
      if (this.balance < 100) {
        this.penalty = true;
      }
      return true;
    }
  }

  @Override
  public void performMonthlyMaintenance() {

    if (this.penalty) {
      this.balance -= this.fee;
    }
    this.penalty = this.balance < 100;
  }
}
