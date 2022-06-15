package com.endava.tmd.soj.junit5.p02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.endava.tmd.soj.junit5.p02.ComputationUtils.sum;
import static org.assertj.core.api.Assertions.*;


// Provocare: Copiati metodele de test din tema anterioara, si adaugati adnotarile necesare astfel incat:
// 1. Sa fie afisat "Tests for my sum method" in loc de "ComputationUtilsTest"
// 2. La fiecare test sa fie afisata suma. De exemplu "zeroShouldNotChangeZero" ar trebui sa fie inlocuit cu "0 + 0 = 0"
@DisplayName("Tests for my sum method")
class ComputationUtilsTest {
     @Test
     @DisplayName("0+0==")
    void zeroShouldNotChangeZero() {
        // JUnit Assertion
        Assertions.assertEquals(
                0, sum(0,0)
        );

        // AssertJ Assertion
        assertThat(sum(0, 0)).isZero();
    }

     @Test
    @DisplayName("2+3=5")
    void zeroShouldNotChangePositive() { Assertions.assertEquals(
            5, sum(2, 3));
    }

    @Test
    @DisplayName("0+(-5)=-5")
    void zeroShouldNotChangeNegative() {
        assertThat(sum(0,-5)).isEqualTo(-5);
    }

    @Test
    @DisplayName("7+8=15")
    void twoPositiveNumbersShouldHaveAbsoluteValuesAddedAndPositiveResult() {
        assertThat(sum(7,8)).isEqualTo(15);
    }
    @Test
    @DisplayName("-7+(-8)=-15")
    void twoNegativeNumbersShouldHaveAbsoluteValuesAddedAndNegativeResult() {
        assertThat(sum(-7,-8)).isEqualTo(-15);
    }
    @Test
    @DisplayName("-7+9=2")
    void oneSmallNegativeAndOneBigPosiveNumberShouldHaveAbsoluteValuesSubtractedAndPositiveResult() {
        assertThat(sum(-7,9)).isEqualTo(2);
    }
    @Test
    @DisplayName("-7+5=-2")
    void oneBigNegativeAndOneSmallPosiveNumberShouldHaveAbsoluteValuesSubtractedAndNegativeResult() {
        assertThat(sum(-7, 5)).isEqualTo(-2);
    }

}
