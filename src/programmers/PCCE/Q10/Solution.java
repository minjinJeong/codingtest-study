package programmers.PCCE.Q10;

import java.util.*;

public class Solution {
    
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};
        
        int index = getIndex(ext);
        answer = Arrays.stream(data)
                    .filter(i -> i[index] < val_ext)
                    .toArray(int[][]::new);
        
        int sortIndex = getIndex(sort_by);
        Arrays.sort(answer, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[sortIndex] - b[sortIndex];
            }
        });
        
        return answer;
    }
    
    private int getIndex(String colName) {
        switch(colName) {
            case "code":
                return 0;
            case "date":
                return 1;
            case "maximum":
                return 2;
            case "remain":
                return 3;
            default:
                return -1;
        }
    }
}