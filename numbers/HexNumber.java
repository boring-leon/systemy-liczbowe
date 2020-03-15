package numbers;

public class HexNumber implements Convertable {
    private String binaryString;
    private int[] weights;

    public HexNumber(String binaryString) {
        this.binaryString = binaryString;
    }


    private int[] getGroupedWeightsSum() {
        int[] sumArray = new int[this.weights.length / 4];
        for (int i = 0; i < this.weights.length; i += 4) {
            int sum = 0, index = 0;
            for (int j = 0; j < 4; j++) {
                index = i + j;
                if (index >= this.weights.length) index = this.weights.length - 1;
                sum += this.weights[index];
            }
            if (sum > 0) sumArray[i / 4] = sum;
        }

        return sumArray;
    }

    private int[] getWeightsArray(StringBuilder binaryStringBuilder) {
        int binaryStringLength = binaryStringBuilder.length();
        int weights[] = new int[binaryStringLength];

        for (int i = 0; i < binaryStringLength; i += 4) {
            for (int j = 0; j < 4; j++) {
                int index = i + j;
                if (index >= binaryStringLength) {
                    index = binaryStringLength - 1;
                }

                if (binaryStringBuilder.charAt(index) == '0') {
                    weights[index] = 0;
                } else {
                    int wykladnik = -1 * j + 3;
                    int waga = (int) Math.pow(2, wykladnik);
                    weights[index] = waga;
                }
            }
        }

        return weights;
    }

    private int getNewBinaryStringLength() {
        int binaryStringLength = binaryString.length();
        return binaryStringLength % 4 == 0 ? binaryStringLength : (int) (4 * Math.ceil((double) binaryStringLength / 4));

    }

    private StringBuilder getNewBinaryStringBuilder() {
        StringBuilder builder = new StringBuilder(this.binaryString);

        for (int i = 0; i < this.getNewBinaryStringLength() - binaryString.length(); i++) {
            builder.insert(i, "0");
        }

        return builder;
    }

    @Override
    public String toString() {
        this.weights = this.getWeightsArray(this.getNewBinaryStringBuilder());
        return this.getResult().toString();
    }

    private StringBuilder getResult() {
        StringBuilder result = new StringBuilder();
        int[] sums = this.getGroupedWeightsSum();

        for (int i = 0; i < sums.length; i++) {
            result.append(getCharNumberEquivalent(sums[i]));
        }

        return result;
    }

    private static char getCharNumberEquivalent(int c) {
        char result;
        switch (c) {
            default:
                result = Integer.toString(c).charAt(0);
                break;
            case 10:
                result = 'A';
                break;
            case 11:
                result = 'B';
                break;
            case 12:
                result = 'C';
                break;
            case 13:
                result = 'D';
                break;
            case 14:
                result = 'E';
                break;
            case 15:
                result = 'F';
                break;
        }
        return result;
    }

    private static int getNumberCharEquivalent(char c) {
        int result;
        switch (c) {
            default:
                result = Integer.parseInt(Character.toString(c));
                break;
            case 'A':
                result = 10;
            case 'B':
                result = 11;
                break;
            case 'C':
                result = 12;
                break;
            case 'D':
                result = 13;
                break;
            case 'E':
                result = 14;
                break;
            case 'F':
                result = 15;
                break;
        }
        return result;
    }

    @Override
    public int toDecimal() {
        return new DecimalNumber(this.binaryString).toDecimal();
    }

    public static String toBinary(String s) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            int decimal = getNumberCharEquivalent(s.charAt(i));
            result.append(new BinaryNumber(decimal).toString());
        }

        return result.toString();
    }
}
