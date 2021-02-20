package test;

import org.junit.Before;
import org.junit.Test;

import bank.CheckingAccount;
import bank.IAccount;

import static org.junit.Assert.assertEquals;
// import static org.junit.Assert.assertFalse;
// import static org.junit.Assert.assertTrue;
// import static org.junit.jupiter.api.Assertions.assertThrows;

/** Tests for the checking account class. */
public class CheckingAccountTest {
  IAccount cA1;
  IAccount cA2;

  @Before
  public void setUp() {
    cA1 = new CheckingAccount(50);
    cA2 = new CheckingAccount(200);
  }

  /** Tests the toString method of the checking account class. */
  @Test
  public void testToString() {
    assertEquals("$50.00", cA1.toString());
    assertEquals("$200.00", cA2.toString());
  }

  /** Tests the getBalance method of the checking account class. */
  @Test
  public void testGetBalance() {
    assertEquals(50, cA1.getBalance(), 0.001);
    assertEquals(200, cA2.getBalance(), 0.001);
  }

  /** Tests the deposit method of the checking account class. */
  @Test
  public void testDeposit() {
    //    assertThrows(IllegalArgumentException.class, () -> cA1.deposit(-1));
    cA1.deposit(50);
    assertEquals(100, cA1.getBalance(), 0.001);
  }

  /** Tests the withdraw method of the checking account class. */
  @Test
  public void testCheckingWithdraw() {
    //    assertThrows(IllegalArgumentException.class, () -> cA2.withdraw(-1));

    //    assertFalse(cA2.withdraw(300));
    cA2.withdraw(50);
    assertEquals(150, cA2.getBalance(), 0.001);
    //    assertTrue(cA2.withdraw(1));
  }

  /** Tests the performMonthlyMaintenance method for the CheckingAccount class. */
  @Test
  public void testCheckingMM() {
    CheckingAccount cA3 = new CheckingAccount(50);
    CheckingAccount cA4 = new CheckingAccount(200);

    cA3.performMonthlyMaintenance();
    cA4.performMonthlyMaintenance();

    assertEquals(45, cA3.getBalance(), 0.001);
    assertEquals(200, cA4.getBalance(), 0.001);

    cA3.deposit(200);
    cA4.withdraw(150);

    cA3.performMonthlyMaintenance();
    cA4.performMonthlyMaintenance();

    assertEquals(240, cA3.getBalance(), 0.001);
    assertEquals(45, cA4.getBalance(), 0.001);

    cA3.withdraw(200);
    cA3.deposit(300);

    assertEquals(340, cA3.getBalance(), 0.001);
  }
}
