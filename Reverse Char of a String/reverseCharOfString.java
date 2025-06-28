public class reverseCharOfString {
    public static void main(String[] args) {
        String string = "I Love Java";

        String[] str = string.split("\\s+");

        String ans = "";

        for (String st : str) {
            char[] word = st.toCharArray();
            int left = 0;
            int right = word.length - 1;
            while (left < right) {
                char temp = word[left];
                word[left] = word[right];
                word[right] = temp;
                left++;
                right--;
            }
            ans += new String(word) + " ";
        }

        System.out.println(string);
        System.out.println(ans);
    }
}


