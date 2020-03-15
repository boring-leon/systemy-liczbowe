package numbers;

public class OctNumber implements Convertable {
    private String binaryString;
    private int[] weights;

    public OctNumber(String binaryString) {
        this.binaryString = binaryString;
    }

    private int[] getGroupedWeightsSum() {
        int[] sumArray = new int[this.weights.length / 3];
        for (int i = 0; i < this.weights.length; i += 3) {
            int sum = 0, index = 0;
            for (int j = 0; j < 3; j++) {
                index = i + j;
                if (index >= this.weights.length) index = this.weights.length - 1;
                sum += this.weights[index];
            }
            if (sum > 0) sumArray[i / 3] = sum;
        }

        return sumArray;
    }

    private int[] getWeightsArray(StringBuilder binaryStringBuilder) {
        int binaryStringLength = binaryStringBuilder.length();
        int weights[] = new int[binaryStringLength];

        for (int i = 0; i < binaryStringLength; i += 3) {
            for (int j = 0; j < 3; j++) {
                int index = i + j;
                if (index >= binaryStringLength) {
                    index = binaryStringLength - 1;
                }

                if (binaryStringBuilder.charAt(index) == '0') {
                    weights[index] = 0;
                } else {
                    int wykladnik = -1 * j + 2;
                    int waga = (int) Math.pow(2, wykladnik);
                    weights[index] = waga;
                }
            }
        }

        return weights;
    }

    private int getNewBinaryStringLength() {
        int binaryStringLength = binaryString.length();
        return binaryStringLength % 3 == 0 ? binaryStringLength : (int) (3 * Math.ceil((double) binaryStringLength / 3));

    }

    private StringBuilder getNewBinaryStringBuilder() {
        StringBuilder builder = new StringBuilder(this.binaryString);

        for (int i = 0; i < this.getNewBinaryStringLength() - binaryString.length(); i++) {
            builder.insert(i, "0");
        }

        return builder;
    }

    private StringBuilder getResult() {
        StringBuilder result = new StringBuilder();
        int[] sums = this.getGroupedWeightsSum();

        for (int i = 0; i < sums.length; i++) {
            result.append(sums[i]);
        }

        return result;
    }

    @Override
    public String toString() {
        this.weights = this.getWeightsArray(this.getNewBinaryStringBuilder());
        return this.getResult().toString();
    }

    @Override
    public int toDecimal() {
        return new DecimalNumber(this.binaryString).toDecimal();
    }

    public static String toBinary(String oct) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < oct.length(); i++) {
            int decimal = Integer.parseInt(Character.toString(oct.charAt(i)));
            StringBuilder binary = new StringBuilder(new BinaryNumber(decimal).toString());
            for (int j = 0; j < 4 - binary.length(); j++) {
                binary.insert(j, "0");
            }
            result.append(binary.toString());
        }

        return result.toString();
    }

}
