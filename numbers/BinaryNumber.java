package numbers;

public class BinaryNumber implements Convertable {

    private int decimalNumber;

    public BinaryNumber(int decimalNumber) {
        this.decimalNumber = decimalNumber;
    }


    private StringBuilder getNumberStringBuilder() {
        StringBuilder binaryString = new StringBuilder();
        int firstWeight = this.getFirstWeight(), weightSum = 0;

        for (int i = firstWeight; i > 0; i /= 2) {
            if (weightSum + i <= this.decimalNumber) {
                weightSum += i;
                binaryString.append("1");
            } else {
                binaryString.append("0");
            }
        }
        return binaryString;
    }

    public int getWeightExponent() {
        double exp = Math.log(this.decimalNumber) / Math.log(2);
        return (int) Math.floor(exp);
    }

    public int getFirstWeight() {
        return (int) Math.pow(2, this.getWeightExponent());
    }

    @Override
    public int toDecimal() {
        return this.decimalNumber;
    }


    @Override
    public String toString() {
        return this.getNumberStringBuilder().toString();
    }


}