package aoc2018;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day1 {
    public long solution1(List<String> frequencies) {
        long result = 0;
        for (String freq : frequencies) {
            long value = Integer.parseInt(freq.substring(1));
            switch (freq.charAt(0)) {
                case '+':
                    result += value;
                    break;
                case '-':
                    result -= value;
                    break;
            }
        }
        return result;
    }

    public long solution2(List<String> frequencies) {
        Set<Long> hitFreqs = new HashSet<>();
        long result = 0;

        int i = 0;
        while (!hitFreqs.contains(result)) {
            hitFreqs.add(result);
            String freq = frequencies.get(i);
            long value = Integer.parseInt(freq.substring(1));
            switch (freq.charAt(0)) {
                case '+':
                    result += value;
                    break;
                case '-':
                    result -= value;
                    break;
            }
            i = (i + 1) % frequencies.size();
        }

        return result;
    }
}
