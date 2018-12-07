package aoc2018;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) throws Exception {
        String filePath = "src/main/resources/input-day3.txt";

        Scanner scanner = new Scanner(new File(filePath));
        List<String> lines = new ArrayList<>();

        while (scanner.hasNextLine())
            lines.add(scanner.nextLine());


        System.out.println(new Day3().solution1(lines));
        System.out.println(new Day3().solution2(lines));
    }
}
