import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LC {
    public static void main(String[] args) {
        new Solution().lengthOfLongestSubstring("abcabcbb");
    }
}


class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int playersIdx = 0, trainersIdx = 0;
        int ans=0;
        while (playersIdx < players.length && trainersIdx < trainers.length) {
            if (players[playersIdx]<=trainers[trainersIdx]){
                ans++;
                trainersIdx++;
                playersIdx++;
            }else{
                trainersIdx++;
            }
        }
        return ans;
    }
}