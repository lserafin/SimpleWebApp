package com.develogical.app;

public class QueryProcessor {

    public String process(String query) {

        String ciQuery = query.toLowerCase();

        if (ciQuery.contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if (ciQuery.contains("mozart")) {
            return "Wolfgang Amadeus Mozart, baptised as Johannes Chrysostomus Wolfgangus Theophilus Mozart, was a prolific and influential composer of the Classical era. Born in Salzburg, Mozart showed prodigious ability from his earliest childhood.";
        } else if( ciQuery.contains("name")){
            return "kell01";
        } else if(ciQuery.contains("plus")){
            String[] parts = ciQuery.split(" ");
            int part1 = Integer.valueOf(parts[2]); // 004
            int part2 = Integer.valueOf(parts[4]); // -034556

            return String.valueOf((part1 + part2));

        } else if(ciQuery.contains("largest")){
            int theIndex = ciQuery.indexOf(":");
            String newText = ciQuery.substring(theIndex);
            String[] numberArray = newText.split(",");

            int biggest = Integer.valueOf(numberArray[0]);

            for(int i = 1;i<numberArray.length; i++){
                if (Integer.valueOf(numberArray[i])>biggest){
                    biggest = Integer.valueOf(numberArray[i]);
                }
            }
            return String.valueOf(biggest);
        }
        //what is your name
        return "";
    }
}
