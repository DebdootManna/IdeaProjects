// Main class
public class Main {
    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // Function to reverse the linked list
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // Function to check if the linked list is a palindrome
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        // Find the end of the first half and reverse the second half.
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        // Check whether the list is a palindrome.
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) result = false;
            p1 = p1.next;
            p2 = p2.next;
        }

        // Restore the list and return the result.
        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;
    }

    // Helper function to find the end of the first half of the linked list
    private static ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    // Helper function to print the linked list
    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Main function
    public static void main(String[] args) {
        // Example 1: Reverse Linked List
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);

        System.out.println("Original List:");
        printList(head1);
        ListNode reversedHead = reverseList(head1);
        System.out.println("Reversed List:");
        printList(reversedHead);

        // Example 2: Palindrome Linked List
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(2);
        head2.next.next.next = new ListNode(1);

        System.out.println("Is Palindrome:");
        System.out.println(isPalindrome(head2)); // Should return true

        ListNode head3 = new ListNode(1);
        head3.next = new ListNode(2);

        System.out.println("Is Palindrome:");
        System.out.println(isPalindrome(head3)); // Should return false
    }
}