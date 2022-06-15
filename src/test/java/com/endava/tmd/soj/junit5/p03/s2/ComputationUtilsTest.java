package com.endava.tmd.soj.junit5.p03.s2;

import org.junit.jupiter.api.*;

import static com.endava.tmd.soj.junit5.p02.ComputationUtils.sum;
import static org.assertj.core.api.Assertions.assertThat;

// Provocare: Copiati metodele de test din tema anterioara (p02), si adaugati adnotarile necesare astfel incat
// sa fie rulate testele in functie de adnotarea de ordine specificata pe fiecare metoda de test. Adnotarea de ordine
// trebuie sa fie pusa pe fiecare metoda de test astfel incat metodele sa fie executate in ordinea in care sunt scrise
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ComputationUtilsTest {
    @Test
    @DisplayName("zerosum")
    @Order(1)
    void zeroShouldNotChangeZero() {
        // JUnit Assertion
        Assertions.assertEquals(
                0, sum(0,0)
        );

        // AssertJ Assertion
        assertThat(sum(0, 0)).isZero();
    }

    @Test
    @DisplayName("sum")
    @Order(2)
    void zeroShouldNotChangePositive() { Assertions.assertEquals(
            5, sum(2, 3));
    }

    @Test
    @DisplayName("negativezerosum")
    @Order(3)
    void zeroShouldNotChangeNegative() {
        assertThat(sum(0,-5)).isEqualTo(-5);
    }

    @Test
    @DisplayName("positesabsolute")
    @Order(4)
    void twoPositiveNumbersShouldHaveAbsoluteValuesAddedAndPositiveResult() {
        assertThat(sum(7,8)).isEqualTo(15);
    }
    @Test
    @DisplayName("negativeabsoulute")
    @Order(5)
    void twoNegativeNumbersShouldHaveAbsoluteValuesAddedAndNegativeResult() {
        assertThat(sum(-7,-8)).isEqualTo(-15);
    }
    @Test
    @DisplayName("smallnegbigpos")
    @Order(6)
    void oneSmallNegativeAndOneBigPosiveNumberShouldHaveAbsoluteValuesSubtractedAndPositiveResult() {
        assertThat(sum(-7,9)).isEqualTo(2);
    }
    @Test
    @DisplayName("bignegsmallpos")
    @Order(7)
    void oneBigNegativeAndOneSmallPosiveNumberShouldHaveAbsoluteValuesSubtractedAndNegativeResult() {
        assertThat(sum(-7, 5)).isEqualTo(-2);
    }
}
