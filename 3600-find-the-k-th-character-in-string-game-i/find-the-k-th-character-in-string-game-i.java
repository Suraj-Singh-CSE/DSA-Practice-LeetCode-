class Solution {
    public char kthCharacter(int k) {
        StringBuilder word = new StringBuilder("a");

        while (word.length() < k) {
            StringBuilder generated = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (c == 'z') {
                    generated.append('a');
                } else {
                    generated.append((char) (c + 1));
                }
            }
            word.append(generated);
        }

        return word.charAt(k - 1);
    }
}
