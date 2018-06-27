package org.syaku.tdd;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author Seok Kyun. Choi. 최석균 (Syaku)
 * @since 2018. 6. 27.
 */
public class MoneyTest {
  @Test
  public void testMultiplication() {
    Dollar five = new Dollar(5);
    five.times(2);
    assertEquals(10, five.amount);
  }

  class Dollar {
    int amount;
    public Dollar(int amount) {
      this.amount = amount;
    }

    void times(int multiplier) {
      amount *= multiplier;
    }
  }
}
