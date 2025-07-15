public class Test {
    // Given an array, consists of stock prices from day-1 to day-n. Please find the
    // max profit possible by buying & selling only once
    // Input : [20, 10, 60, 100, 5, 99]
    // Output : 94

    public static void main(String args[]) {
        int[] input = { 20, 10, 60, 100, 5, 99 };
        int buyPrice = input[0];
        int profit = 0;

        for (int i = 0; i < input.length; i++) {
            if (input[i] < buyPrice) {
                buyPrice = input[i];
            }

            profit = Math.max(profit, (input[i] - buyPrice));
        }
        System.out.println(profit);
    }
}
