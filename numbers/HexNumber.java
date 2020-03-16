package numbers;

public class HexNumber extends BinarySplitter implements Convertable {

    public HexNumber(String binaryString) {
        super(binaryString);
        this.splitBy = 4;
    }

    public StringBuilder getResult() {
        StringBuilder result = new StringBuilder();
        int[] sums = this.getWeightsSumsArray();

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
