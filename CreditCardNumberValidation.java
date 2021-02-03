package CreditCardValidation;

import java.util.Scanner;

public class CreditCardNumberValidation {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter your credit card number: ");
            String input = scanner.next();

            System.out.println(numberTypeDetector(input));
            validateCreditCardNumber(input);

            if (validateCreditCardNumber(input)){
                System.out.println("Number is a valid credit card.");
            }

        }catch(IllegalArgumentException e){
            System.out.println("You entered an invalid card number");
        }
    }

    private static boolean validateCreditCardNumber(String input){

        int[] creditCardInt = new int[input.length()];

        for (int i = 0; i < input.length(); i++) {

            creditCardInt[i] = Integer.parseInt(input.substring(i, i + 1));
        }

        for (int i = creditCardInt.length - 2; i >= 0; i -= 2) {
            int temp = creditCardInt[i];
            temp = temp * 2;
            if (temp > 9) {
                temp = temp % 10 + 1;
            }
            creditCardInt[i] = temp;
        }
        int total = 0;
        for (int j : creditCardInt) {
            total += j;
        }

        return total % 10 == 0;
    }

    public static String numberTypeDetector(String cardNumber){
        if (cardNumber.startsWith("4")){
            return "The card is potentially a VISA card...";
        }else{
            if (cardNumber.startsWith("5")){
                return "The card is potentially a MasterCard...";
            }else{
                if (cardNumber.startsWith("6")){
                    return "The card is potentially a Discover card...";
                }else{
                    if (cardNumber.startsWith("37")){
                        return "The card is potentially an American Express card...";
                    }
                }
            }
        }
        return "Not a known card type";
    }
}
