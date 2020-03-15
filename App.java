import numbers.Number;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        //Number.hex("1C").addHex("1C").addHex("1C").equalsToDecimal(3 * Number.hex("1C").toDecimal());

        do {

            System.out.println("Podaj liczbe dziesietna: ");
            int input = new Scanner(System.in).nextInt();
            System.out.print(
                            "Bin: " + Number.decimal(input).toBinary() + "\n" +
                            "Hex: " + Number.decimal(input).toHex() + "\n" +
                            "Oct: " + Number.decimal(input).toOct()
            );
            System.out.println("\n");
        }
        while (true);
    }
}
