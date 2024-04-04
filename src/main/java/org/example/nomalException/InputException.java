package org.example.nomalException;

import java.util.Scanner;

public class InputException {
    public static int numberInputException(Scanner scanner, String info){
        int n;
        while(true){
            System.out.print(info);
            try {
                int N = scanner.nextInt();
                n = N;
                scanner.nextLine();
                break;
            }
            catch (Exception e){
                System.out.println("Invalid input, please input the number.");
                scanner.next();
            }
        }
        return n;
    }
}
