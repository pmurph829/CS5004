package bank;

/**
 * Class for representing a savings bank account.
 */
public class SavingsAccount extends AbstractAccount {
  /**
   * fee is the amount of money to be subtracted from the balance if there is an outstanding
   * penalty. transactionCounter is the number of withdrawals from the account.
   */
  private final double fee;
  private int transactionCounter;

  public SavingsAccount(double starterAmount) {
    this.balance = starterAmount;
    this.fee = 14.00;
  }

  @Override
  public boolean withdraw(double amount) throws IllegalArgumentException {
    if (amount < 0) {
      throw new IllegalArgumentException("Withdraw amount cannot be negative.");
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
