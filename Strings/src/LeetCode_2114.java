// Maximum Number of words found in sentences

public class LeetCode_2114 {
    public static void main(String[] args) {
        String[] sentences = {"please wait", "continue to fight", "continue to win"};

        System.out.println(mostWordsFound(sentences));
    }

    static int mostWordsFound(String[] sentences) {
        int maxWords = 0;

        for (String sentence : sentences) {
            maxWords = Math.max(maxWords, sentence.split(" ").length);
        }

        return maxWords;
    }
}
