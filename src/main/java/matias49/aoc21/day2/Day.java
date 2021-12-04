package main.java.matias49.aoc21.day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Day {
    String file = "src/main/java/matias49/aoc21/day2/input.txt";

    public static void main(String[] args) {
        Day day = new Day();
        System.out.println(day.Part1());
        System.out.println(day.Part2());
    }

    private String Part1() {
        int x = 0;
        int y = 0;

        try {
            List<String> lines = Files.readAllLines(Paths.get(file));
            for (String lineRead : lines) {
                String[] line = lineRead.split(" ");
                switch (line[0]) {
                    case "forward" -> x += Integer.parseInt(line[1]);
                    case "down" -> y += Integer.parseInt(line[1]);
                    case "up" -> y -= Integer.parseInt(line[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Integer.toString(x * y);
    }

    private String Part2() {
        int x = 0;
        int y = 0;
        int aim = 0;
        try {
            List<String> lines = Files.readAllLines(Paths.get(file));
            for (String lineRead : lines) {
                String[] line = lineRead.split(" ");
                switch (line[0]) {
                    case "forward" -> {
                        x += Integer.parseInt(line[1]);
                        y += (aim * Integer.parseInt(line[1]));
                    }
                    case "down" -> aim += Integer.parseInt(line[1]);
                    case "up" -> aim -= Integer.parseInt(line[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Integer.toString(x * y);
    }

}
