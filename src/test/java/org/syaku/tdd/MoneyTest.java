package org.syaku.tdd;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * closed $5 * 2 = $10
 * closed Dollar 부작용?
 * todo equals()
 *
 * @author Seok Kyun. Choi. 최석균 (Syaku)
 * @since 2018. 6. 27.
 */
public class MoneyTest {

  @Test
  public void testEqualityError() {
    // equals 는 기본적인 동작은 this == object 이며 주소값을 비교하게 된다.
    // new 로 생성되는 객체들은 매번 새로운 주소값을 가지므로 아래의 추적을 오류이면 결과는 false 이다.
//    assertTrue(new Dollar(5).equals(new Dollar(5)));
    // 아래와 같이 하면 성공할 수 있다.
//    Dollar dollar = new Dollar(5);
//    Dollar dollar2 = dollar;
//    assertTrue(dollar.equals(dollar2));
    // 해결책은 equals 를 오버리드(재작성)하여 같은 객체이면서 값이 같은지를 판단해야 한다.
    // 하지만 이번 장에는 값만 같은지 판단한다.
  }

  @Test
  public void testEquality() {
    assertTrue(new Dollar(5).equals(new Dollar(5)));
    assertFalse(new Dollar(5).equals(new Dollar(6)));
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

    @Override
    public boolean equals(Object obj) {
      Dollar dollar = (Dollar) obj;
      return this.amount == dollar.amount;
    }
  }
}
