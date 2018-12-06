package aoc2018;

import java.util.List;

public class Day2 {

    int count2 = 0, count3 = 0;
    public void count2And3(String id) {
        int[] counts = new int[26];
        for (char c : id.toCharArray()) {
            counts[c - 'a']++;
        }

        boolean contains2 = false, contains3 = false;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == 2) contains2 = true;
            else if (counts[i] == 3) contains3 = true;
        }

        if (contains2) count2++;
        if (contains3) count3++;
    }

    public long solution1(List<String> ids) {
        for (String id : ids) {
            count2And3(id);
        }
        return count2 * count3;
    }

    public String differsByOne(String sourceId, String targetId) {
        int diff = 0;
        if (sourceId.length() == targetId.length()) {
            char[] sourceIdArr = sourceId.toCharArray();
            char[] targetIdArr = targetId.toCharArray();
            char[] result = new char[sourceIdArr.length - 1];
            int resultIdx = 0;
            for (int i = 0; i < sourceIdArr.length; i++) {
                if (sourceIdArr[i] != targetIdArr[i])
                    if (diff < 1)
                    diff++;
                    else return null;
                else {
                    result[resultIdx++] = sourceIdArr[i];
                }
            }
            return new String(result);
        } return null;

    }

    public String solution2(List<String> ids) {
        for (int i = 0; i < ids.size(); i++)
            for (int j = i + 1; j < ids.size(); j++) {
                String diffStr = differsByOne(ids.get(i), ids.get(j));
                if (diffStr != null)
                    return diffStr;
            }
        return null;
    }
}
