package doublePtrs;


import java.util.*;


public class DoublePtrsForLinkedList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1), p = dummy;
        ListNode p1 = list1, p2 = list2;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        if (p1 != null) {
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }
        return dummy.next;
    };

    // 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
    // 你应当 保留 两个分区中每个节点的初始相对位置。
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(-1), dummy2 = new ListNode(-1);
        ListNode p1 = dummy1, p2 = dummy2;
        ListNode p = head;
        while (p != null) {
            if (p.val < x) {
                p1.next = p;
                p1 = p1.next;
            } else {
                p2.next = p;
                p2 = p2.next;
            }
            // 每次指向 p 节点的指针往后移之前，先断掉内存中该节点的 next 路径。
            ListNode temp = p.next;
            p.next = null;
            p = temp;
        }
        p1.next = dummy2.next; // 将 list1 的尾与 list2 的头连接
        return dummy1.next;
    }

    // 合并 k 个有序链表，使用优先级队列即可
    ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) { return null; }

        ListNode dummy = new ListNode(-1), p = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length, (a, b) -> (a.val - b.val));
        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }
        while (!pq.isEmpty()) {
            p.next = pq.poll();
            p = p.next;
            if (p.next != null) {
                pq.add(p.next);
            }
        }
        return dummy.next;
    }

    public ListNode middleNode(ListNode head) {
        if (head == null) { return null; }
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
