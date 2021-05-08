package solution;
import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution {


    public static boolean checkValidity(String input) {
        if (input.equalsIgnoreCase("ipd") == false && input.equalsIgnoreCase("mbp") == false
                && input.equalsIgnoreCase("atv") == false && input.equalsIgnoreCase("vga") == false) {
            return false;
        }
        return true;
    }

    public static float calculateTotal(int cPad, int cPro, int cTV, int cVGA) {
        int diff = cVGA - cPro;
        if (diff < 0) diff = 0;
        float sum = 0;
        sum = (float) ((cPro * 1399.99) + (diff * 30));

        int numPads = cTV / 3;
        int extraPads = cTV % 3;
        sum += (float) ((numPads * 109.5 * 2) + (extraPads * 109.5));

        if (cPad < 4) {
            sum += (float) (cPad * 549.99);
        } else {
            sum += (float) (cPad * 499.99);
        }
        return sum;
    }


    public static void main(String[] args) {
        boolean nextCus = true;
        while (nextCus == true) {
            HashMap<String, Integer> checkout = new HashMap<String, Integer>();
            checkout.put("ipd", 0);
            checkout.put("mbp", 0);
            checkout.put("atv", 0);
            checkout.put("vga", 0);
            Scanner sc = new Scanner(System.in);
            System.out.println("Welcome to the Cashier. Please type the barcode of your item and then press enter.");
            System.out.println("Follow it up by the frequency of items you wish to enter");
            System.out.println("Please type code: None if you wish to calculate total cost.");
            while (true) {
                System.out.println("Please insert itemCode:");
                String s = sc.next();
                if (s.equalsIgnoreCase("none")) {
                    break;
                }
                if (checkValidity(s) == false) {
                    System.out.println("Please type in a valid item code.");
                    continue;
                }
                checkout.put(s, checkout.get(s) + 1);

            }
            float ans = calculateTotal(checkout.get("ipd"), checkout.get("mbp"), checkout.get("atv"), checkout.get("vga"));
            String s = String.valueOf(ans);
            System.out.println("Your total cost is: " + s);
            System.out.println("Is there another customer? If no, please type 0, else type in any number");
            try {
                int next = sc.nextInt();
                if (next == 0)  nextCus = false;
            } catch (InputMismatchException e)  {
                System.out.println();
                sc.nextLine();
            }
        }
    }
}
