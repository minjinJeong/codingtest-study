package programmers.PCCP.Q1;

public class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        
        int answer = health;
        int lastAttacksTime = attacks[attacks.length-1][0] + 1;
        
        int current = 0;
        int success = 0;
        
        for(int i=0; i<lastAttacksTime; i++) {
            
            if (i == attacks[current][0]) {
                answer -= attacks[current][1];
                current++;
                success = 0;
            }
            else {
                answer += bandage[1];
                success++;
                
                if (success == bandage[0]) {
                    answer += bandage[2];
                    success = 0;
                }

                if (answer > health) {
                    answer = health;
                }
            }
            
            if (answer < 1) {
                answer = -1;
                break;
            }
        }
        
        return answer;
    }
}
