package aoc2018;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Day3 {

    public static Claim parseClaim(String claimStr) {
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

    private static int[][] grid;

    private void initGrid() {
        grid = new int[1000][1000];
    }

    public static void fillGrid(Claim claim) {
        int xBound = claim.x + claim.width;
        int yBound = claim.y + claim.height;

        for (int i = claim.x; i < xBound; i++)
            for (int j = claim.y; j < yBound; j++)
                grid[i][j]++;
    }

    public int solution1(List<String> claimStrs) {
        initGrid();
        claimStrs
                .stream()
                .map(Day3::parseClaim)
                .forEach(Day3::fillGrid);

        int overlappingSquares = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid.length; j++)
                if (grid[i][j] > 1) overlappingSquares++;

        return overlappingSquares;
    }

    public static boolean checkOverlap(Claim claim) {
        int xBound = claim.x + claim.width;
        int yBound = claim.y + claim.height;

        for (int i = claim.x; i < xBound; i++)
            for (int j = claim.y; j < yBound; j++)
                if (grid[i][j] > 1) return false;
        return true;
    }

    public int solution2(List<String> claimStrs) {
        initGrid();
        List<Claim> claims = claimStrs
                .stream()
                .map(Day3::parseClaim)
                .collect(Collectors.toList());

        for (int i = 0; i < claims.size(); i++) {
            Claim current = claims.get(i);
            fillGrid(current);
            for (int j = 0; j < claims.size(); j++)
                if (j != i)
                    fillGrid(claims.get(j));

            if (checkOverlap(current)) return current.id;
            initGrid();
        }

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