package com.endava.tmd.soj.junit5.p05.s2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.endava.tmd.soj.junit5.p05.s1.ComputationUtils.sum;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

// Scopul acestei sectiuni este sa urmarim rescrierile de cod din partea de productie
// Deci pastram testele din sectiunea precedenta
class ComputationUtilsTest {
    @Test
    @DisplayName("0 + 0 = 0")
    void zeroShouldNotChangeZero() {
        //JUnit Assertion
        Assertions.assertEquals(0, sum(0, 0));
        // AssertJ Assertion
        assertThat(sum(0, 0)).isZero();
        //failed if we put expected: 0, see the next two lines
          Assertions.assertEquals(9,sum(5,4));
        //Assertions.assertEquals(0,sum(5,4));
    }

    @Test
    @DisplayName("0 + 3 = 3")
    void zeroShouldNotChangePositive() {
        assertThat(sum(0,3)).isEqualTo(3);
    }

    @Test
    @DisplayName("0 + -5 = -5")
    void zeroShouldNotChangeNegative() {
        assertThat(sum(0,-5)).isEqualTo(-5);
    }

    @Test
    @DisplayName("5 + 6 = 11")
    void twoPositiveNumbersShouldHaveAbsoluteValuesAddedAndPositiveResult() {
        assertThat(sum(5,6)).isEqualTo(11);
    }

    @Test
    @DisplayName("-5 + -10 = -15")
    void twoNegativeNumbersShouldHaveAbsoluteValuesAddedAndNegativeResult() {
        assertThat(sum(-5,-10)).isEqualTo(-15);
    }

    @Test
    @DisplayName("-5 + 10 = 6")
    void oneSmallNegativeAndOneBigPositiveNumberShouldHaveAbsoluteValuesSubtractedAndPositiveResult() {
        assertThat(sum(-5,10)).isEqualTo(5);
    }

    @Test
    @DisplayName("-110 + 30 = -80")
    void oneBigNegativeAndOneSmallPositiveNumberShouldHaveAbsoluteValuesSubtractedAndNegativeResult() {
        assertThat(sum(-110,30)).isEqualTo(-80);
    }

    @Test
    void zeroShouldNotChangeMaxInt() {
        assertThat(sum(Integer.MAX_VALUE,0)).isEqualTo(Integer.MAX_VALUE);
    }

    @Test
    void maxIntAndANegativeNumber() {
        assertThat(sum(Integer.MAX_VALUE,-100)).isEqualTo(2147483547);
    }

    @Test
    void zeroShouldNotChangeMinInt() {
        assertThat(sum(Integer.MIN_VALUE,0)).isEqualTo(Integer.MIN_VALUE);
    }

    @Test
    void minIntAndAPositiveNumber() {
        assertThat(sum(Integer.MIN_VALUE,100)).isEqualTo(-2147483548);
    }

    @Test
    void minIntAndMaxInt() {
        assertThat(sum(Integer.MIN_VALUE,Integer.MAX_VALUE)).isEqualTo(-1);
    }

    @Test
    @Disabled
    void whatToDoWhenSumExceedsMaxIntegerValue() {
        assertThat(sum(Integer.MAX_VALUE,3)).isEqualTo(2147483650L);
    }

   @DisplayName("2147483647 + 1 \u21D2 Overflow")
    void exceptionWhenSumIsGreaterThanIntegerMaxValue() {
        // JUnit way of checking the exception class
      assertThrows(ArithmeticException.class, () -> sum(2147483647, 1));

        // JUnit way of checking the exception class and its characteristics
       ArithmeticException exception = assertThrows(ArithmeticException.class, () -> sum(2147483647, 1));
       assertEquals("Overflow while computing the sum", exception.getMessage());

        // AssertJ
       assertThatThrownBy(() -> sum(2147483647, 1))
             .isInstanceOf(ArithmeticException.class)
               .hasMessage("Overflow while computing the sum");
    }

    @DisplayName("-2147483648 + (-1) \u21D2 Overflow")
    void exceptionWhenSumIsLowerThanIntegerMinValue() {
        // JUnit way of checking the exception class
        assertThrows(ArithmeticException.class, () -> sum(-2147483648, -1));

        // JUnit way of checking the exception class and its characteristics
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> sum(-2147483648, -1));
        assertEquals("Overflow while computing the sum", exception.getMessage());

        // AssertJ
        assertThatThrownBy(() -> sum(-2147483648, -1))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Overflow while computing the sum");
    }
}
