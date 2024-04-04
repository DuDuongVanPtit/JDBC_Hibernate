package org.example.customException;

public class PhoneNumberFormatException extends RuntimeException{
    public PhoneNumberFormatException(String s){
        super(s);
    }
}
