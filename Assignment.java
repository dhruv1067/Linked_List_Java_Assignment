class LinkedList {
    Node head; // Head of the list

    // Node class
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Q1: Check if a key is present in the linked list
    public boolean search(int key) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == key) return true;
            temp = temp.next;
        }
        return false;
    }

    // Q2: Insert a node at a given position
    public void insertAfter(Node prevNode, int newData) {
        if (prevNode == null) {
            System.out.println("Previous node cannot be null");
            return;
        }
        Node newNode = new Node(newData);
        newNode.next = prevNode.next;
        prevNode.next = newNode;
    }

    // Q3: Remove duplicates from a sorted linked list
    public void removeDuplicates() {
        Node current = head;
        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }

    // Q4: Check if a linked list is a palindrome
    public boolean isPalindrome() {
        Node slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            Node next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        if (fast != null) slow = slow.next; // Skip middle for odd-length list
        while (slow != null) {
            if (slow.data != prev.data) return false;
            slow = slow.next;
            prev = prev.next;
        }
        return true;
    }

    // Q5: Add two numbers represented as linked lists
    public static LinkedList addTwoLists(LinkedList l1, LinkedList l2) {
        Node n1 = l1.head, n2 = l2.head;
        LinkedList result = new LinkedList();
        Node temp = new Node(0);
        result.head = temp;
        int carry = 0;

        while (n1 != null || n2 != null || carry > 0) {
            int sum = (n1 != null ? n1.data : 0) + (n2 != null ? n2.data : 0) + carry;
            carry = sum / 10;
            temp.next = new Node(sum % 10);
            temp = temp.next;
            if (n1 != null) n1 = n1.next;
            if (n2 != null) n2 = n2.next;
        }
        result.head = result.head.next;
        return result;
    }

    // Print the linked list
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Sample Linked List: 1 -> 2 -> 3 -> 4 -> 5
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(5);

        // Q1: Search for a key
        System.out.println("Is 3 present? " + list.search(3));
        System.out.println("Is 10 present? " + list.search(10));

        // Q2: Insert a node after 2
        list.insertAfter(list.head.next, 10);
        System.out.print("List after insertion: ");
        list.printList();

        // Q3: Remove duplicates from sorted list
        LinkedList sortedList = new LinkedList();
        sortedList.head = new Node(1);
        sortedList.head.next = new Node(1);
        sortedList.head.next.next = new Node(2);
        sortedList.head.next.next.next = new Node(3);
        sortedList.head.next.next.next.next = new Node(3);
        System.out.print("Sorted List before removing duplicates: ");
        sortedList.printList();
        sortedList.removeDuplicates();
        System.out.print("Sorted List after removing duplicates: ");
        sortedList.printList();

        // Q4: Check if a list is a palindrome
        LinkedList palindromeList = new LinkedList();
        palindromeList.head = new Node(1);
        palindromeList.head.next = new Node(2);
        palindromeList.head.next.next = new Node(2);
        palindromeList.head.next.next.next = new Node(1);
        System.out.println("Is palindrome? " + palindromeList.isPalindrome());

        // Q5: Add two numbers as linked lists
        LinkedList num1 = new LinkedList();
        num1.head = new Node(5);
        num1.head.next = new Node(6);
        num1.head.next.next = new Node(3);

        LinkedList num2 = new LinkedList();
        num2.head = new Node(8);
        num2.head.next = new Node(4);
        num2.head.next.next = new Node(2);

        LinkedList sumList = addTwoLists(num1, num2);
        System.out.print("Sum of two numbers as linked lists: ");
        sumList.printList();
    }
}
