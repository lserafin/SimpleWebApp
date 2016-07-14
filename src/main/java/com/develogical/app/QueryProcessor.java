package com.develogical.app;

import java.util.ArrayList;

public class QueryProcessor {

    public String process(String query) {

        try {
            String ciQuery = query.toLowerCase().trim();

            if (ciQuery.contains("shakespeare")) {
                return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                        "English poet, playwright, and actor, widely regarded as the greatest " +
                        "writer in the English language and the world's pre-eminent dramatist.";
            } else if (ciQuery.contains("mozart")) {
                return "Wolfgang Amadeus Mozart, baptised as Johannes Chrysostomus Wolfgangus Theophilus Mozart, was a prolific and influential composer of the Classical era. Born in Salzburg, Mozart showed prodigious ability from his earliest childhood.";
            } else if (ciQuery.contains("name")) {
                return "kell01";
            } else if (ciQuery.contains("plus")) {
                String[] parts = ciQuery.split(" ");
                int part1 = Integer.valueOf(parts[3]); // 004
                int part2 = Integer.valueOf(parts[5]); // -034556

                return String.valueOf((part1 + part2));

            } else if (ciQuery.contains("largest")) {
                int theIndex = ciQuery.lastIndexOf(":");
                String newText = ciQuery.substring(theIndex + 1).trim();
                String[] numberArray = newText.split(",");

                int biggest = Integer.valueOf(numberArray[0].trim());

                if (numberArray.length > 1) {
                    for (int i = 1; i < numberArray.length; i++) {
                        if (Integer.valueOf(numberArray[i].trim()) > biggest) {
                            biggest = Integer.valueOf(numberArray[i].trim());
                        }
                    }
                }

                return String.valueOf(biggest);
            } else if (ciQuery.contains("multiplied")) {

                String[] parts = ciQuery.split(" ");
                int length = parts.length;
                int part1 = Integer.valueOf(parts[length - 1]); // 004
                int part2 = Integer.valueOf(parts[length - 4]); // -034556

                return String.valueOf((part1 * part2));

            } else if (ciQuery.contains("square")) {

                int theIndex = ciQuery.lastIndexOf(":");
                String newText = ciQuery.substring(theIndex + 1).trim();
                String[] numberArray = newText.split(",");


                for (int i = 0; i < numberArray.length; i++) {

                    Integer number = Integer.valueOf(numberArray[i].trim());
                    double sqrRoot = Math.sqrt(number);
                    double cubeRoot = Math.cbrt(number);

                    if (Math.floor(sqrRoot) == Math.ceil(sqrRoot) && Math.floor(cubeRoot) == Math.ceil(cubeRoot))
                        return String.valueOf(number);
                }

            } else if (ciQuery.contains("prime") && ciQuery.contains("number")) {

                int theIndex = ciQuery.lastIndexOf(":");
                String newText = ciQuery.substring(theIndex + 1).trim();
                String[] numberArray = newText.split(",");

                String primes = "", splitter = "";

                for (int i = 0; i < numberArray.length; i++) {

                    long number = Long.valueOf(numberArray[i].trim());
                    if (isPrime(number)) {
                        primes = primes + splitter + number;
                        splitter = ", ";
                    }
                }
                return primes;

            } else if (ciQuery.contains("prime") && ciQuery.contains("minister")) {


                return "David Cameron";

            } else if (ciQuery.contains("fibonacci")) {

                String[] numberArray = ciQuery.split(" ");
                String numberText = numberArray[numberArray.length - 6];
                numberText = numberText.replace("th", "");
                numberText = numberText.replace("rd", "");
                numberText = numberText.replace("st", "");
                numberText = numberText.replace("nd", "");

                Integer i = Integer.valueOf(numberText);
                if (i == 0)
                    return "0";
                else if (i == 1)
                    return "1";
                else if (i == 2)
                    return "1";
                else {

                    ArrayList<Integer> fib = new ArrayList<Integer>();
                    fib.add(1);
                    fib.add(1);

                    for (Integer index = 1; index < i; index++)
                        fib.add(fib.get(index - 1) + fib.get(index));

                    return String.valueOf(fib.get(i - 1));
                }

            }
            //what is your name
        }
            catch (Exception ex) {
                ex.printStackTrace();
        }

        return "";
    }

    public boolean isPrime(long n) {
        // fast even test.
        if(n > 2 && (n & 1) == 0)
            return false;
        // only odd factors need to be tested up to n^0.5
        for(int i = 3; i * i <= n; i += 2)
            if (n % i == 0)
                return false;
        return true;
    }
}
