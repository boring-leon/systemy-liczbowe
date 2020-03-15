package numbers;

public class DecimalNumber implements Convertable {
    private String binaryNumber;

    public DecimalNumber(String binaryNumber) {
        this.binaryNumber = binaryNumber;
    }

    private int getNumber() {
        int number = 0;
        for (int i = 0; i < this.binaryNumber.length(); i++) {
            if (this.binaryNumber.charAt(i) == '1') {
                number += this.getCurrentWeight(i);
            }
        }
        return number;
    }


    private int getCurrentWeight(int iterator) {
        return (int) Math.pow(2, this.getWeightExponent() - iterator);
    }

    public int getFirstWeight() {
        return (int) Math.pow(2, this.getWeightExponent());
    }

    public int getWeightExponent() {
        return this.binaryNumber.length() - 1;
    }

    @Override
    public int toDecimal() {
        return this.getNumber();
    }


    @Override
    public String toString() {
        return Integer.toString(this.getNumber());
    }
}