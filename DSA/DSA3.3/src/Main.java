class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Main {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Create a dummy node to simplify the merge process
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Iterate while both lists have nodes
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // Attach the remaining nodes from list1 or list2
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        // The merged list starts at dummy.next
        return dummy.next;
    }

    public static void main(String[] args) {
        // Create list1: 1 -> 2 -> 4
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        // Create list2: 1 -> 3 -> 4
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        Main solution = new Main();
        ListNode mergedList = solution.mergeTwoLists(list1, list2);

        // Print the merged list
        ListNode current = mergedList;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}