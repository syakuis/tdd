package org.syaku.tdd;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * close $5 * 2 = $10
 * todo Dollar 부작용?
 *
 * @author Seok Kyun. Choi. 최석균 (Syaku)
 * @since 2018. 6. 27.
 */
public class MoneyTest {

  @Test(expected = AssertionError.class)
  public void testMultiplicationError() {
    Dollar five = new Dollar(5);
    five.times(2);
    assertEquals(10, five.amount);
    // five 5가 아니라 10인 상태
    five.times(3);
    // 그래서 5 * 3 이 아닌 10 * 3 이 되고 아래는 추정은 오류가 발생한다.
    assertEquals(15, five.amount);
  }

  @Test
  public void testMultiplication() {
    Dollar five = new Dollar(5);
    Dollar product = five.times(2);
    assertEquals(10, product.amount);
    product = five.times(3);
    assertEquals(15, product.amount);
  }

  class Dollar {
    int amount;
    public Dollar(int amount) {
      this.amount = amount;
    }

    Dollar times(int multiplier) {
      return new Dollar(amount * multiplier);
    }
  }
}
