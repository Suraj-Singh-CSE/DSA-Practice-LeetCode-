import java.util.*;

class ProductOfNumbers {
    private List<Integer> prefixProduct;

    public ProductOfNumbers() {
        prefixProduct = new ArrayList<>();
        prefixProduct.add(1); // Base case to handle division properly
    }
    
    public void add(int num) {
        if (num == 0) {
            // Reset the prefix product when zero is encountered
            prefixProduct.clear();
            prefixProduct.add(1); // Reset with base case
        } else {
            // Append the new product to the prefix list
            prefixProduct.add(prefixProduct.get(prefixProduct.size() - 1) * num);
        }
    }
    
    public int getProduct(int k) {
        int n = prefixProduct.size();
        if (k >= n) return 0; // If k exceeds available numbers, return 0 due to reset
        return prefixProduct.get(n - 1) / prefixProduct.get(n - 1 - k);
    }
}

/**
 * Usage:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
