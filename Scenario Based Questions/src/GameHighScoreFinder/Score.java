package GameHighScoreFinder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;

public class Score {
    ArrayList<Integer> topScores;

    public Score() {
        topScores = new ArrayList<>();
    }

    Random random = new Random();

//    public ArrayList<Integer> generateSortedScoreList(int n) {
//        HashSet<Integer> set = new HashSet<>();
//
//        for (int i = 0; topScores.size() < n; i++) {
//
//            if (topScores.size() < n) {
//
//                int k = random.nextInt(500,1200);
//
//                if (!set.contains(k)) {
//                    topScores.add(k);
//                    set.add(k);
//                }
//            }
//        }
//
//        topScores.sort(Collections.reverseOrder());
//        return topScores;
//    }


    public void generateSortedScoreList(int n) {
        HashSet<Integer> set = new HashSet<>();

        while (set.size() < n)
            set.add(random.nextInt(500,610));

        this.topScores = new ArrayList<>(set);
        this.topScores.sort(Collections.reverseOrder());
    }


    public int findRank(int score) {
        int left = 0;
        int right = topScores.size()-1;


        while (left <= right){
            int mid = (right - left)/2 + left;

            if (score == topScores.get(mid))
                return mid + 1;
            else if (score < topScores.get(mid))
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }
}
