package bank;

/**
 * This interface represents a bank account. It is the super-type for any other type of traditional
 * financial account a bank might offer.
 */
public interface IAccount {
  /**
   * Deposits a given amount of money into an account.
   *
   * @param amount the amount of money to deposit.
   */
  void deposit(double amount);

  /**
   * Withdraw a given amount of money from an account.
   *
   * @param amount The amount of money to withdraw.
   * @return true if the operation succeeds, false otherwise.
   */
  boolean withdraw(double amount);

  /**
   * Get the current balance of the bank account.
   *
   * @return the balance of the account.
   */
  double getBalance();

  /**
   * Assess the account and determine if any fees need to be applied. If so, apply the fees to the
   * account balance.
   */
  void performMonthlyMaintenance();
}
