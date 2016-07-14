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
        String query = " what is 14 plus 1 ";


        assertThat(queryProcessor.process(query), containsString("15"));
    }

    @Test
    public void whatIsTheBiggestNumber() throws Exception {
        String query = "deef89e0: which of the following numbers is the largest: 79, 37, 812, 936";


        assertThat(queryProcessor.process(query), containsString("936"));
    }


}
