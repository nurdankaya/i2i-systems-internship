import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class IsPrimeAndExistFibonacciTest
{
    IsPrimeAndExistFibonacci underTest;

    @BeforeEach
    void setUp(){
        underTest = new IsPrimeAndExistFibonacci();
    }

    @ParameterizedTest
    @CsvSource({"0, false",
            "2, true",
            "15, false",})
    public void isPrimeTest(int numberToTest, boolean isPrimeExpected){
        boolean isPrimeNumber = underTest.isPrime(numberToTest);
        assertThat(isPrimeNumber).isEqualTo(isPrimeExpected);
    }

    @ParameterizedTest
    @CsvSource({"0, false",
            "1, true",
            "34, true",})
    public void existsFibonacciTest(int numberToTest, boolean inFibonacciExpected){
        boolean isPrimeNumber = underTest.existsFibonacci(numberToTest);
        assertThat(isPrimeNumber).isEqualTo(inFibonacciExpected);
    }
}
