package com.endava.tmd.soj.junit5.p06.s3;

import java.util.stream.Stream;

import com.endava.tmd.soj.junit5.p05.s1.ComputationUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static com.endava.tmd.soj.junit5.p01.ComputationUtils.sum;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

// Provocare: Rescrieti cele doua teste parametrizate din sectiunea 1 astfel incat sa existe
// cate o metoda care sa furnizeze valorile parametrilor. Dar, nu se vor mai folosi valorile
// explicite pentru valoarea minima si maxima acceptata de Java pentru tipul de date intreg,
// ci se vor folosi Integer.MIN_VALUE, respectiv Integer.MAX_VALUE
// Se va utiliza adnotarea @MethodSource.
class ComputationUtilsTest {
@ParameterizedTest
    @MethodSource("sumInputProvider")
    void testSumResult(int a, int b, int expected) {
        assertThat(sum(a,b)).isEqualTo(expected);
    }

    static Stream<Arguments> sumInputProvider() {
        return Stream.of(
                arguments(0, 0, 0),
                arguments(0, 3, 3),
                arguments(0, -3, -3),
                arguments(7, 8, 15),
                arguments(-7, -8, -15),
                arguments(-7, 9, 2),
                arguments(-7, 5, -2),
                arguments(0, Integer.MAX_VALUE, Integer.MAX_VALUE),
                arguments(Integer.MAX_VALUE, -2, 2147483645),
                arguments(0, Integer.MIN_VALUE, Integer.MIN_VALUE),
                arguments(Integer.MIN_VALUE, 2, -2147483646),
                arguments(Integer.MIN_VALUE, Integer.MAX_VALUE, -1)

        );
    }

    @ParameterizedTest
    @MethodSource("exceptionInputProvider")
    void exceptionWhenSumIsLowerThanIntegerMinValue(int a, int b) {
        // AssertJ
        assertThatThrownBy(() -> ComputationUtils.sum(a, b))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Overflow while computing the sum");
    }
    static Stream<Arguments> exceptionInputProvider() {
        return Stream.of(
                arguments(Integer.MAX_VALUE, 1),
                arguments(Integer.MIN_VALUE, -1)
        );
    }
}
