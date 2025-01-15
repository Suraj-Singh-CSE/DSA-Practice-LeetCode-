class Solution {
    public int minimizeXor(int num1, int num2) {

        int count1 = Integer.bitCount(num1);
        int count2 = Integer.bitCount(num2);

        if (count1 == count2) {
            return num1; 
        } else if (count1 > count2) {
            
            for (int i = 0; i < 32 && count1 > count2; i++) {
                if ((num1 & (1 << i)) != 0) { 
                    num1 &= ~(1 << i); 
                    count1--; 
                }
            }
        } else {
            
            for (int i = 0; i < 32 && count1 < count2; i++) {
                if ((num1 & (1 << i)) == 0) { 
                    num1 |= (1 << i); 
                    count1++; 
                }
            }
        }

        return num1; 
    }
}
