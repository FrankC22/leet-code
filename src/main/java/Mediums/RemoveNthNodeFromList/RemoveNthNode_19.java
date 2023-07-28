package Mediums.RemoveNthNodeFromList;


import java.util.List;

public class RemoveNthNode_19 {

    public static class ListNode {

        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }


        @Override
        public String toString() {
            ListNode temp = this;
            String output = "";

            while(temp != null) {
                output += ("\n" + temp.val);
                temp = temp.next;
            }
            return output;
        }
    }

    public static void main(String[] args) {

        ListNode case1 = new ListNode(1);
        case1.next = new ListNode(2);
        case1.next.next = new ListNode(3);
        case1.next.next.next = new ListNode(4);
        case1.next.next.next.next = new ListNode(5);

        System.out.println("Case 1 list before: " + case1);
        System.out.println("Case 1 list after: " + removeNthFromEnd(case1, 2));

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode newHead = new ListNode(0, head);
        ListNode right = newHead;
        ListNode left = newHead;

        //Two pointers where the second pointer is shifted n to the right in the list

        for(int i = 0; i < n; i++) {
            right = right.next;
        }

        while(right.next != null) {

            left = left.next;
            right = right.next;
        }

        //Now fast.next should be null here and fast should be the last member of the list
        // Slow should be the node before the node we want to remove
        left.next = left.next.next;

        return newHead.next;
    }


}
