package leetcode;

import java.util.*;

public class AccountMerge {
    List<List<String>> accountsMerge(List<List<String>> accounts) {
        // key: email, value: 出现该 email 的 account 的索引列表
        HashMap<String, List<Integer>> emailToIndexes = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                List<Integer> indexes = emailToIndexes.getOrDefault(email, new ArrayList<>());
                indexes.add(i);
                emailToIndexes.put(email, indexes);
            }
        }

        // 计算合并后的账户
        List<List<String>> res = new ArrayList<>();
        HashSet<String> visitedEmails = new HashSet<>();

        for (String email : emailToIndexes.keySet()) {
            if (visitedEmails.contains(email)) {
                continue;
            }

            // 合并账户
            HashSet<String> mergedEmail = new HashSet<>();
            Queue<String> q = new LinkedList<>();
            q.offer(email);
            visitedEmails.add(email);
            // 关键是以一个 email 为起点，通过 bfs 穷举关联 email 中的账户
            while(!q.isEmpty()) {
                String curEmail = q.poll();
                mergedEmail.add(curEmail); // 每一个 email poll 出来后，先放到合并队列
                List<Integer> indexes = emailToIndexes.get(curEmail);
                for (int index : indexes) { // 一层遍历该 email 对应的账户 index
                    List<String> account = accounts.get(index);
                    for (int j = 1; j < account.size(); j++) { // 二层遍历账户的所有 email，全加到队列中；再通过队列poll email查穷举所有的账户
                        if (!visitedEmails.contains(account.get(j))) {
                            q.offer(account.get(j));
                            visitedEmails.add(account.get(j));
                        }
                    }
                }
            }

            // mergedEmail 是 userName 的所有邮箱
            String userName =  accounts.get(emailToIndexes.get(email).get(0)).get(0);
            LinkedList<String> mergedAccount = new LinkedList<>(mergedEmail);
            Collections.sort(mergedAccount);
            mergedAccount.addFirst(userName);
            res.add(mergedAccount);
        }
        return res;
    }
}
