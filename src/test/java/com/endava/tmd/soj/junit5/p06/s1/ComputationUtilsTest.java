package com.endava.tmd.soj.junit5.p06.s1;

import com.endava.tmd.soj.junit5.p05.s1.ComputationUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.endava.tmd.soj.junit5.p01.ComputationUtils.sum;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


// Provocare: Rescrieti scenariile de testare din tema precedenta folosind teste parametrizate.
// Se vor utiliza adnotarile @ParameterizedTest si @CsvSource
// E suficient sa scrieti 2 teste distincte:
// - Un test care verifica valoarea sumei a doua numere
// - Un test care verifica exceptiile generate
//
// Bonus: personalizarea numelui afisat al testului
//   * vom folosi {0} pentru a folosi valoarea primului parametru al metodei
//   * vom folosi {1} pentru a folosi valoarea celui de-al doilea parametru al metodei
//   * ...
//   dar NU in @DisplayName ci in atributul "name" al adnotarii @ParameterizedTest
class ComputationUtilsTest {

    @ParameterizedTest(name = "{index} : the sum of {0} and {1} is {2}")
    @CsvSource({
            "0,          0,           0",
            "0,          3,           3",
            "0,         -3,           -3",
            "7,          8,           15",
            "-7,         -8,          -15",
            "-7,         9,           2",
            "-7,         5,           -2",
            "0,          2147483647,  2147483647",
            "2147483647, -2,          2147483645",
            "0,          -2147483648, -2147483648",
            "-2147483648, 2,          -2147483646",
            "-2147483648, 2147483647, -1"
    })

    void testSumValue(int a, int b, int expected) {
        assertThat(sum(a, b)).isEqualTo(expected);
    }

   @ParameterizedTest(name = "{index} : the sum of {0} and {1} is {2}")
    @CsvSource({
                " 2147483647,      1,    'Overflow while computing the sum'",
                " -2147483648,    -1,    'Overflow while computing the sum'"
    })

    void exceptionWhenSumIsLowerThanIntegerMinValue(int a, int b, String expected) {
        // AssertJ
        assertThatThrownBy(() -> ComputationUtils.sum(a, b))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage(expected);
    }

    @ParameterizedTest(name = "{index} : the sum of {0} and {1} is Overflow")
    @CsvSource({
            " 2147483647,      1",
            " -2147483648,    -1"
    })

    void exceptionWhenSumIsLowerThanIntegerMinValue2(int a, int b) {
        // AssertJ
        assertThatThrownBy(() -> ComputationUtils.sum(a, b))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Overflow while computing the sum");
    }
}
