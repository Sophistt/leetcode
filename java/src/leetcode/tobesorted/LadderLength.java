package leetcode.tobesorted;

import java.util.*;

// 字典 wordList 中从单词 beginWord 到 endWord 的 转换序列 是一个按下述规格形成的序列 beginWord -> s1 -> s2 -> ... -> sk：
// 每一对相邻的单词只差一个字母。
// 对于 1 <= i <= k 时，每个 si 都在 wordList 中。注意， beginWord 不需要在 wordList 中。
// sk == endWord
// 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，返回 从 beginWord 到 endWord 的 最短转换序列 中的 单词数目 。
// 如果不存在这样的转换序列，返回 0 。

public class LadderLength {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) return 0;
        return bfs(beginWord, endWord, wordList);
    }

    public int bfs(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0; // 如果 endWord 不在 wordList 中，直接返回 0

        Queue<String> queue = new LinkedList<String>();
        queue.add(beginWord);

        HashSet<String> visited = new HashSet<>();
        visited.add(beginWord);

        int depth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (word.equals(endWord)) return depth;

                List<String> ladders = findLadders(word);
                for (String ladder : ladders) {
                    if (!visited.contains(ladder) && wordSet.contains(ladder)) {
                        queue.add(ladder);
                        visited.add(ladder);
                    }
                }
            }
            depth++;
        }
        return 0;
    }

    public List<String> findLadders(String word) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < word.length(); i++)
            res.addAll(findLadders(word, i));
        return res;
    }

    public List<String> findLadders(String word, int pos) {
        List<String> res = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder(word);
        for (int i = 0; i < 26; i++) {
            stringBuilder.setCharAt(pos, (char) ('a' + i));
            res.add(stringBuilder.toString());
        }
        return res;
    }
}
