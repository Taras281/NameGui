package org.example;

import lombok.Data;

import java.util.regex.Pattern;


public class Validator {
    private  String Name;
    private String Surname;
    private String Patronomyc;
    private String nsp;

    private static String regex;
    private static Pattern pattern;


    public static void init() {
        regex="[a-zA-Z]{1,20}";
        pattern = Pattern.compile(regex);
    }


    static public boolean valid(String name, String surname, String patronomyc){
        init();
        if(pattern.matches(regex,name)&&
           pattern.matches(regex,surname)&&
           (pattern.matches(regex,patronomyc)||pattern.matches("",patronomyc))){
            return true;
        }
        else{
            return false;
        }
    }

    static public boolean validNSP(String nsp){
        init();
        String[] input = nsp.split(" ");
        Boolean boll=true;
        for (String string:input){
           boll=boll&pattern.matches(regex,string);
        }
        return boll;
    }

}
