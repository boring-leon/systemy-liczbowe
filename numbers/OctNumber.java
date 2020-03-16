package numbers;

public class OctNumber extends BinarySplitter implements Convertable {

    public OctNumber(String binaryString) {
        super(binaryString);
        this.splitBy = 3;
    }

    public StringBuilder getResult() {
        StringBuilder result = new StringBuilder();
        int[] sums = this.getWeightsSumsArray();

        for (int i = 0; i < sums.length; i++) {
            result.append(sums[i]);
        }

        return result;
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
