package leetcode.tobesorted;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

import java.util.Arrays;


public class OpenLock {
    public int openLock(String[] deadends, String target) {
        return bfs(deadends, target);
    }

    public int bfs(String[] deadends, String target) {
        HashSet<String> deads = new HashSet<>(Arrays.asList(deadends)); // 将 deadends
        if (deads.contains("0000")) return -1;

        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");

        Set<String> visited = new HashSet<>();
        visited.add("0000");

        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (target.equals(cur))
                    return step;

                for (String neighbor : getNeighbours(cur)) {
                    if (!visited.contains(neighbor) && !deads.contains(neighbor)) {
                        queue.offer(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    public List<String> getNeighbours(String target) {
        List<String> neighbours = new ArrayList<>();
        for (int i = 0; i < target.length(); i++) {
            neighbours.add(plusOne(target, i));
            neighbours.add(minusOne(target, i));
        }
        return neighbours;
    }

    public String plusOne(String target, int i) {
        char[] chars = target.toCharArray();
        chars[i] = chars[i] == '9' ? '0' : chars[i]++;
        return new String(chars);
    }

    public String minusOne(String target, int i) {
        char[] chars = target.toCharArray();
        chars[i] = chars[i] == '0' ? '9' : chars[i]--;
        return new String(chars);
    }
}