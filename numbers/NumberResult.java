package numbers;

public class NumberResult {

    private int decimal;
    private String binary;

    public NumberResult(String binary) {
        this.binary = binary;
        this.decimal = new DecimalNumber(binary).toDecimal();
    }

    public NumberResult(int decimal) {
        this.decimal = decimal;
        this.binary = new BinaryNumber(this.decimal).toString();
    }

    public static NumberResult fromHex(String hex) {
        String binary = HexNumber.toBinary(hex);
        return new NumberResult(binary);
    }

    public String toBinary() {
        return this.binary;
    }

    public int toDecimal() {
        return this.decimal;
    }

    public String toHex() {
        return new HexNumber(this.binary).toString();
    }

    public boolean equalsToDecimal(int decimal) {
        return this.decimal == decimal;
    }

    public boolean equalsToBinary(String binary) {
        return this.decimal == new DecimalNumber(binary).toDecimal();
    }

    public boolean equalsToHex(String hex) {
        String binary = HexNumber.toBinary(hex);
        return this.decimal == new DecimalNumber(binary).toDecimal();
    }

    public NumberResult addBinary(String binary) {
        this.decimal += new DecimalNumber(binary).toDecimal();
        return this;
    }

    public NumberResult addHex(String hex) {
        String binary = HexNumber.toBinary(hex);
        this.decimal += new DecimalNumber(binary).toDecimal();
        return this;
    }
}
