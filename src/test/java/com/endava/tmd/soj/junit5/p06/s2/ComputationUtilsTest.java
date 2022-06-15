package com.endava.tmd.soj.junit5.p06.s2;
import com.endava.tmd.soj.junit5.p05.s1.ComputationUtils;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static com.endava.tmd.soj.junit5.p01.ComputationUtils.sum;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
// Provocare: Rescrieti testul care verifica valoarea sumei a doua numere din tema precedenta
// folosind un fisier (Comma-Separated Value) care sa stocheze datele necesare pentru test
// Fisierul se va numi "sumCheckArguments.csv" si va fi creat in folderul src/test/resources
// Se va utiliza adnotarea @CsvFileSource.
// 
// Testul care verifica exceptiile generate se va copia din tema precedenta
class ComputationUtilsTest {
 @ParameterizedTest(name = "I. {index} : the sum of {0} and {1} is {2}")
    @CsvFileSource(resources = "/sumCheckArguments.csv")
    void testSumValue(int a, int b, int expected) {
        assertThat(sum(a,b)).isEqualTo(expected);
    }

    @ParameterizedTest(name = "II. {index} : the sum of {0} and {1} is {2}")
    @CsvFileSource(files = "src/test/resources/sumCheckArguments.csv")
    void testSumValue2(int a, int b, int expected) {
        assertThat(sum(a,b)).isEqualTo(expected);
    }


    @ParameterizedTest(name = "{index} : the sum of {0} and {1} is Overflow")
    @CsvSource({
            " 2147483647,      1",
            " -2147483648,    -1"
    })
    void exceptionWhenSumIsLowerThanIntegerMinValue(int a, int b) {
        // AssertJ
        assertThatThrownBy(() -> ComputationUtils.sum(a, b))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Overflow while computing the sum");
    }
}
