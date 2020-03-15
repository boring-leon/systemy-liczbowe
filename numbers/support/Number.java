package numbers.support;

public class Number {
    public static NumberResult decimal(int n) {
        return new NumberResult(n);
    }

    public static NumberResult binary(String binary) {
        return new NumberResult(binary);
    }

    public static NumberResult hex(String hex) {
        return NumberResult.fromHex(hex);
    }

    public static NumberResult oct(String oct) {
        return NumberResult.fromOct(oct);
    }
}
