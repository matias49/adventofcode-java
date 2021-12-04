package main.java.matias49.aoc21.day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Day {
    String file = "src/main/java/matias49/aoc21/day1/input.txt";

    public static void main(String[] args) {
        Day day = new Day();
        System.out.println(day.Part1());
        System.out.println(day.Part2());
    }

    private String Part1() {
        int count = 0;
        try {
            List<String> lines = Files.readAllLines(Paths.get(file));
            for (int i = 1; i < lines.size(); i++) {
                if (Integer.parseInt(lines.get(i)) > Integer.parseInt(lines.get(i - 1))) {
                    count++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Integer.toString(count);
    }

    private String Part2() {
        int count = 0;
        try {
            List<String> lines = Files.readAllLines(Paths.get(file));
            for (int i = 3; i < lines.size(); i++) {
                int v1 = Integer.parseInt(lines.get(i - 3)) + Integer.parseInt(lines.get(i - 2)) + Integer.parseInt(lines.get(i - 1));
                int v2 = Integer.parseInt(lines.get(i - 2)) + Integer.parseInt(lines.get(i - 1)) + Integer.parseInt(lines.get(i));
                if (v2 > v1) {
                    count++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Integer.toString(count);
    }
}
