package bank;

/** Class for representing a savings bank account. */
public class SavingsAccount extends AbstractAccount {
  /**
   * fee is the amount of money to be subtracted from the balance if there is an outstanding
   * penalty. transactionCounter is the number of withdrawals from the account.
   */
  private final double fee;

  private int transactionCounter;

  /**
   * Create a new SavingsAccount object.
   *
   * @param starterAmount the starting amount to deposit into the account.
   * @throws IllegalArgumentException If the starting amount is less than $0.01.
   */
  public SavingsAccount(double starterAmount) throws IllegalArgumentException {
    if (starterAmount <= 0.01) {
      throw new IllegalArgumentException("Starting amount cannot be below one cent");
    }
    this.balance = starterAmount;
    this.fee = 14.00;
  }

  @Override
  public boolean withdraw(double amount) throws IllegalArgumentException {
    if (amount < 0) {
      return false;
    } else if (amount > this.balance) {
      return false;
    } else {
      this.balance -= amount;
      this.transactionCounter += 1;
      if (this.transactionCounter > 6) {
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
    this.penalty = false;
    this.transactionCounter = 0;
  }
}
