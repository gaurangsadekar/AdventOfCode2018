package aoc2018;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) throws Exception {
        String filePath = args[0];

        Scanner scanner = new Scanner(new File(filePath));
        List<String> lines = new ArrayList<>();

        while (scanner.hasNextLine())
            lines.add(scanner.nextLine());

        System.out.println(new Day2().solution1(lines));
//        System.out.println(new Day1().solution2(lines));
    }
}
