package aoc2018;

import javax.sound.midi.SysexMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Day3 {

    public static Claim processClaim(String claimStr) {
        Pattern claimPattern = Pattern.compile("^#(\\d+) @ (\\d+),(\\d+): (\\d+)x(\\d+)");
        Matcher claimMatcher = claimPattern.matcher(claimStr);

        if (claimMatcher.find()) {
            return new Claim(
                    Integer.parseInt(claimMatcher.group(1)),
                    Integer.parseInt(claimMatcher.group(2)),
                    Integer.parseInt(claimMatcher.group(3)),
                    Integer.parseInt(claimMatcher.group(4)),
                    Integer.parseInt(claimMatcher.group(5))
            );
        }
        return null;
    }

    public int solution1(List<String> claimStrs) {
        List<Claim> claims = claimStrs
                .stream()
                .map(Day3::processClaim)
                .collect(Collectors.toList());

        

        return 0;
    }
}

class Claim {
    int id;
    int x;
    int y;
    int width;
    int height;

    public Claim(int id, int x, int y, int width, int height) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
}