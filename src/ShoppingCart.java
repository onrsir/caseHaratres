import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShoppingCart {

    public static class CartResult {
        public int totalAmount;
        public List<Integer> noDiscountItems;

        public CartResult(int totalAmount, List<Integer> noDiscountItems) {
            this.totalAmount = totalAmount;
            this.noDiscountItems = noDiscountItems;
        }
    }

    public static CartResult calculateDiscounts(int[] prices) {
        if (prices.length < 1 || prices.length > 100) {
            throw new IllegalArgumentException("Array boyutu 1 ile 100 arasında olmalıdır.");
        }

        for (int price : prices) {
            if (price <= 0 || price >= 2000) {
                throw new IllegalArgumentException("Array elemanları 1 ile 2.000 arasında olmalıdır.");
            }
        }

        int totalAmount = 0;
        List<Integer> noDiscountItems = new ArrayList<>();

        for (int i = 0; i < prices.length; i++) {
            if (i < prices.length - 1 && prices[i + 1] < prices[i]) {
                totalAmount += prices[i] - prices[i + 1];
            } else {
                totalAmount += prices[i];
                noDiscountItems.add(prices[i]);
            }
        }

        return new CartResult(totalAmount, noDiscountItems);
    }

}
