
/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * https://leetcode.com/problems/add-two-numbers/
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int currVal = 0;
        int reminder = 0;
        ListNode result = null;
        ListNode resultHead = null;
        while(l1 != null || l2 != null) {
            int l1Val = 0;
            if (l1 != null) {
                l1Val = l1.val;
            }
            int l2Val = 0;
            if (l2 != null) {
                l2Val = l2.val;
            }
            currVal = l1Val + l2Val  + reminder;

            reminder = currVal / 10;
            int digit = currVal % 10;

            if (result == null) {
                result = new ListNode(digit);
                resultHead = result;
            } else {
                ListNode currNode = new ListNode(digit);
                result.next = currNode;
                result = currNode;
            }
            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (reminder != 0) {
            ListNode currNode = new ListNode(reminder);
            result.next = currNode;
//            result = currNode;
        }

        return resultHead;
    }

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(2);
        l3.next = l2;
        l2.next = l1;

        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(4);
        l6.next = l5;
        l5.next = l4;

    }
}
