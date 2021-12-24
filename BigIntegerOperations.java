import java.time.*;
import java.math.*;
import java.util.Scanner;

public class BigIntegerOperations {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inp1;
        search: //label for the loop
        do{
          System.out.println("\nHow many digits do you want? ");
          // if(sc.hasNextInt()) {
          //      inp1 = sc.nextInt();
          // }
          // else {
          //     System.out.println("\nAre you serious? Try again.");
          //     continue search;
          // 
          // couldnt try this because it will run in an ongoing loop.
          // tried with try catch and that also ened with same result.
          // please try to input only integers.
          // }
          inp1 = sc.nextInt();
          System.out.println("Generating random numbers....");
          Instant first = Instant.now();
            BigInteger num1 = generateBigIntegerWithNumberOfDigits(inp1);
            BigInteger num2 = generateBigIntegerWithNumberOfDigits(inp1);
            BigInteger num3;
            System.out.println("\nnum1: " + num1);
            System.out.println("size of num1: "+ num1.toString().length()+" digits.");
            System.out.println("\nnum2: " + num2);
            System.out.println("size of num2: "+ num2.toString().length()+" digits.");
            num3 = num1.gcd(num2);
            // num3 = gcd(num1.mod(num2), num1);
            Instant second = Instant.now();
            String str = "GCD of num1 and num2 is: "+ num3+".\n";
            System.out.printf("\n" + str);
            Duration duration = Duration.between(first, second);
            System.out.printf("Time taken: "+ duration.toNanos()+" Nanoseconds.");
            System.out.println("\nWant to try again? y/n: ");
            char yn = sc.next().charAt(0);
            if(yn=='n' || yn=='N'){
                break search;
              }
              else if(yn=='y' || yn=='Y'){
                continue search;
              }
              else{
               System.out.println("It was just y or n that you had to input. I'm a computer. Give me some break.");
               break search;
              }
              }
            while(true);
            sc.close();
            System.out.println("Bye!");
          }

    private static BigInteger generateBigIntegerWithNumberOfDigits(int n) {
        BigInteger mybig = null;
        int initrand = (int) (Math.random() * 9 + 1);
        if (n > 0) {
            mybig = new BigInteger("" + initrand);
            for (int i = 1; i < n; i++) {
                int crtdigit = (int) (Math.random() * 10);
                BigInteger big1 = new BigInteger("" + crtdigit);
                mybig = mybig.multiply(new BigInteger("10"));
                mybig = mybig.add(big1);
            }
        } else {
            mybig = new BigInteger("0");
        }
        return mybig;
    }



}

