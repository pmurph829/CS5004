package test;

import org.junit.Before;
import org.junit.Test;

import bank.IAccount;
import bank.SavingsAccount;

import static org.junit.Assert.assertEquals;
// import static org.junit.Assert.assertFalse;
// import static org.junit.Assert.assertTrue;
// import static org.junit.jupiter.api.Assertions.assertThrows;

/** Tests for the savings account class. */
public class SavingsAccountTest {
  IAccount sA1;
  IAccount sA2;

  @Before
  public void setUp() {
    sA1 = new SavingsAccount(50);
    sA2 = new SavingsAccount(200);
  }

  /** Tests the to string method of the savings account class. */
  @Test
  public void testToString() {
    assertEquals("$50.00", sA1.toString());
    assertEquals("$200.00", sA2.toString());
  }

  /** Tests the getBalance method of the savings account class. */
  @Test
  public void testGetBalance() {
    assertEquals(50, sA1.getBalance(), 0.001);
    assertEquals(200, sA2.getBalance(), 0.001);
  }

  /** Tests the deposit method of the savings account class. */
  @Test
  public void testDeposit() {
    //    assertThrows(IllegalArgumentException.class, () -> sA1.deposit(-1));
    sA1.deposit(50);
    assertEquals(100, sA1.getBalance(), 0.001);
  }

  /** Tests the withdraw method for the SavingsAccount class. */
  @Test
  public void testSavingsWithdraw() {
    //    assertThrows(IllegalArgumentException.class, () -> sA2.withdraw(-1));

    //    assertFalse(sA2.withdraw(300));

    sA2.withdraw(50);
    assertEquals(150, sA2.getBalance(), 0.001);
    //    assertTrue(sA2.withdraw(1));
  }

  /** Tests the performMonthlyMaintenance method for the SavingsAccount class. */
  @Test
  public void testSavingsMM() {
    SavingsAccount sA3 = new SavingsAccount(50);
    SavingsAccount sA4 = new SavingsAccount(200);

    sA3.performMonthlyMaintenance();
    sA4.performMonthlyMaintenance();

    assertEquals(50, sA3.getBalance(), 0.001);
    assertEquals(200, sA4.getBalance(), 0.001);

    for (int i = 0; i <= 6; i++) {
      sA3.withdraw(0);
      sA4.withdraw(1);
    }
    sA3.performMonthlyMaintenance();
    sA4.performMonthlyMaintenance();

    assertEquals(36, sA3.getBalance(), 0.001);
    assertEquals(179, sA4.getBalance(), 0.001);
  }
}
