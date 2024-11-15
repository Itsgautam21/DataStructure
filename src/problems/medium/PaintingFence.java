package problems.medium;

public class PaintingFence {
    
    /**
     * @param posts       No of posts.
     * @param colour      No of colour.
     * @param sum         count of last repeated digit
     * @param combination generate all possible combination for arrangement in string.
     * @return count of possible combination.
     */
    public static int paintFence(int posts, int colour, int sum, String combination) {
        
        if (posts == 0) return 1;
        int addition = 0;
        for (int i = 0; i < colour; i++) {
            int newSum = combination.length() > 0 && Integer.parseInt(String.valueOf(combination.charAt(combination.length() - 1))) == i ? sum + 1 : 1;
            if (newSum < 3)
                addition = addition + paintFence(posts - 1, colour, newSum, combination + i);
        }
        return addition;
    }
    
    /**
     * @param posts  No of posts
     * @param colour No of colour
     * @return count of possible combination
     */
    public static long paintFence(long posts, long colour) {
        
        long same = colour;
        long diff = colour * (colour - 1);
        long total = same + diff;
        for (int i = 3; i <= posts; i++) {
            same = diff;
            diff = total * (colour - 1);
            total = same + diff;
        }
        return total;
    }
    
    public static void main(String[] args) {
        
        int posts = 79;
        int colour = 53;
        System.out.println(paintFence(posts, colour, 0, ""));
        System.out.println(paintFence(posts, colour));
    }
}
