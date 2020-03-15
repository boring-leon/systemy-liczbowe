package numbers;

public class Number {
    public static NumberResult decimal(int n) {
        return new NumberResult(n);
    }

    public static NumberResult binary(String s) {
        return new NumberResult(s);
    }

    public static NumberResult hex(String s) {
        return NumberResult.fromHex(s);
    }
}
