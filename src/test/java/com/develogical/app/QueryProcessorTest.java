package com.develogical.app;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class QueryProcessorTest {

    QueryProcessor queryProcessor = new QueryProcessor();

    @Test
    public void returnsEmptyStringIfCannotProcessQuery() throws Exception {
        assertThat(queryProcessor.process("test"), is(""));
    }

    @Test
    public void knowsAboutShakespeare() throws Exception {
        assertThat(queryProcessor.process("Shakespeare"), containsString("playwright"));
    }

    @Test
    public void isNotCaseSensitive() throws Exception {
        assertThat(queryProcessor.process("shakespeare"), containsString("playwright"));
    }

    @Test
    public void knowsAboutMozart() throws Exception {
        assertThat(queryProcessor.process("mozart"), containsString("Salzburg"));
    }

    @Test
    public void isNotCaseMozart() throws Exception {
        assertThat(queryProcessor.process("Mozart"), containsString("Salzburg"));
    }

    @Test
    public void whatIsYourNameRequestShouldReturnAPIName() throws Exception {
        String query = "7066c290: what is 11 plus 7";


        assertThat(queryProcessor.process(query), containsString("18"));
    }

    @Test
    public void whatIsTheBiggestNumber() throws Exception {
        String query = "deef89e0: which of the following numbers is the largest: 79, 37, 812, 936";


        assertThat(queryProcessor.process(query), containsString("936"));
    }

    @Test
    public void whatIsTheProduct() throws Exception {
        String query = "f8a27e20: what is 10 multiplied by 5";


        assertThat(queryProcessor.process(query), containsString("50"));
    }

    @Test
    public void whatIsSquereandCubeProduct() throws Exception {
        String query = "3b6ad3b0: which of the following numbers is both a square and a cube: 373, 64, 438, 2304";


        assertThat(queryProcessor.process(query), containsString("64"));
    }

    @Test
    public void whatArePrimes() throws Exception {
        String query = "3b6ad3b0: which of the following numbers are primes: 433, 317";


        assertThat(queryProcessor.process(query), containsString("433, 317"));
    }

    @Test
    public void whatIsSinglePrime() throws Exception {
        String query = "3b6ad3b0: which of the following numbers are primes: 433";


        assertThat(queryProcessor.process(query), containsString("433"));
    }

    @Test
    public void Test0thNumberInFibonacciSequence() throws Exception {
        String query = "ec7a1ea0: what is the 0th number in the Fibonacci sequence";


        assertThat(queryProcessor.process(query), containsString("0"));
    }
    @Test
    public void Test1stNumberInFibonacciSequence() throws Exception {
        String query = "ec7a1ea0: what is the 1st number in the Fibonacci sequence";


        assertThat(queryProcessor.process(query), containsString("1"));
    }
    @Test
    public void Test2ndNumberInFibonacciSequence() throws Exception {
        String query = "ec7a1ea0: what is the 2nd number in the Fibonacci sequence";


        assertThat(queryProcessor.process(query), containsString("1"));
    }
    @Test
    public void TestNumberInFibonacciSequence() throws Exception {

        String query = "ec7a1ea0: what is the 3rd number in the Fibonacci sequence";
        assertThat(queryProcessor.process(query), containsString("2"));


         query = "ec7a1ea0: what is the 10th number in the Fibonacci sequence";
        assertThat(queryProcessor.process(query), containsString("55"));


         query = "ec7a1ea0: what is the 16th number in the Fibonacci sequence";
        assertThat(queryProcessor.process(query), containsString("987"));


         query = "ec7a1ea0: what is the 41st number in the Fibonacci sequence";
        assertThat(queryProcessor.process(query), containsString("165580141"));
    }


}
