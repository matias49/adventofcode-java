package main.java.matias49.aoc22.day1;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day {

    public static void main(String[] args) throws Exception {
        Day day = new Day();
        System.out.println(day.Part1());
        System.out.println(day.Part2());
    }

    private ArrayList<ArrayList<Integer>> getData(Path filePath) throws Exception {
        ArrayList<ArrayList<Integer>> data = new ArrayList<>();
        List<String> lines = Files.readAllLines(filePath);
        ArrayList<Integer> currentElf = new ArrayList<>();
        for (String lineRead : lines) {
            if (!lineRead.equals("")) {
                currentElf.add(Integer.valueOf(lineRead));
            } else {
                data.add(currentElf);
                currentElf = new ArrayList<>();
            }
        }
        return data;
    }

    private ArrayList<Integer> calcSum(ArrayList<ArrayList<Integer>> data) {
        ArrayList<Integer> elfSum = new ArrayList<>();
        for (ArrayList<Integer> elf : data) {
            elfSum.add(elf.stream().reduce(0, Integer::sum));
        }
        return elfSum;
    }

    public int Part1() throws Exception {
        ArrayList<ArrayList<Integer>> data = getData(Paths.get("src/main/java/matias49/aoc22/day1/input.txt"));
        ArrayList<Integer> elfCalories = calcSum(data);
        elfCalories.sort(Collections.reverseOrder());
        return elfCalories.get(0);
    }

    public int Part2() throws Exception {
        ArrayList<ArrayList<Integer>> data = getData(Paths.get("src/main/java/matias49/aoc22/day1/input.txt"));
        ArrayList<Integer> elfCalories = calcSum(data);
        elfCalories.sort(Collections.reverseOrder());
        return elfCalories.get(0) + elfCalories.get(1) + elfCalories.get(2);
    }
}
