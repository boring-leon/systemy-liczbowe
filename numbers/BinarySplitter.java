package numbers;

public abstract class BinarySplitter {

    protected String binaryString;
    protected int[] weights;
    protected int splitBy;

    public BinarySplitter(String binaryString){
        this.binaryString = binaryString;
    }

    public String toString() {
        this.weights = this.getWeightsArray(this.getSplittedBinaryStringBuilder());
        return this.getResult().toString();
    }

    protected int getSplittedBinaryStringLength() {
        int binaryStringLength = binaryString.length();
        return binaryStringLength % this.splitBy == 0 ? binaryStringLength :
                (int) (this.splitBy * Math.ceil((double) binaryStringLength / this.splitBy));

    }

    protected StringBuilder getSplittedBinaryStringBuilder() {
        StringBuilder builder = new StringBuilder(this.binaryString);

        for (int i = 0; i < this.getSplittedBinaryStringLength() - binaryString.length(); i++) {
            builder.insert(i, "0");
        }

        return builder;
    }

    protected int[] getWeightsSumsArray() {
        int[] sumArray = new int[this.weights.length / this.splitBy];
        for (int i = 0; i < this.weights.length; i += this.splitBy) {
            int sum = 0, index = 0;
            for (int j = 0; j < this.splitBy; j++) {
                index = i + j;
                if (index >= this.weights.length) index = this.weights.length - 1;
                sum += this.weights[index];
            }
            if (sum > 0) sumArray[i / this.splitBy] = sum;
        }

        return sumArray;
    }

    protected int[] getWeightsArray(StringBuilder binaryStringBuilder) {
        int binaryStringLength = binaryStringBuilder.length();
        int weights[] = new int[binaryStringLength];

        for (int i = 0; i < binaryStringLength; i += this.splitBy) {
            for (int j = 0; j < this.splitBy; j++) {
                int index = i + j;
                if (index >= binaryStringLength) {
                    index = binaryStringLength - 1;
                }

                if (binaryStringBuilder.charAt(index) == '0') {
                    weights[index] = 0;
                } else {
                    int wykladnik = -1 * j + this.splitBy - 1;
                    int waga = (int) Math.pow(2, wykladnik);
                    weights[index] = waga;
                }
            }
        }

        return weights;
    }

    //TO override by child
    public StringBuilder getResult(){
        return new StringBuilder();
    }

}
