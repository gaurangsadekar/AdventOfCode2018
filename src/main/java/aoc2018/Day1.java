package aoc2018;

import java.util.List;

public class Day1 {
    public long solution(List<String> frequencies) {
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
}
