// Java program to Check that two circular
// linked list are identical or not

public class Identical {

	// Circular Linked list Node Class
	static class Node {
		int data;
		Node next;

		// Constructor function
		Node(int data)
		{
			this.data = data;
			this.next = null;
		}
	};

	// Function to insert a node in
	// tail in circular linked list
	static Node insertNode(Node head, Node tail, int d)
	{
		// First insertion in circular
		// linked list
		if (head == null) {
			Node newNode = new Node(d);
			head = newNode;
			tail = newNode;
			newNode.next = newNode;
			return newNode;
		}
		else {

			// Non-empty list
			Node temp = new Node(d);
			temp.next = tail.next;
			tail.next = temp;
			return tail.next;
		}
	}

	// Function to print circular linked list
	static void print(Node head)
	{
		Node curr = head;

		// If circular linked list is empty
		if (head == null) {
			System.out.println("List is Empty ");
			return;
		}

		// Else iterate until node is NOT head
		do {
			System.out.print(curr.data + " ");
			curr = curr.next;
		} while (curr != head);
		System.out.println();
	}

	// Function to return length of
	// circular linked list
	static int length(Node head)
	{
		// If circular linked list is empty
		if (head == null) {
			return 0;
		}

		int size = 0;
		Node curr = head;

		// Else iterate until node is NOT head
		do {
			curr = curr.next;
			size++;
		} while (curr != head);
		return size;
	}

	// Function to Check that two circular
	// linked list are identical or not
	static boolean checkIdentical(Node head1, Node head2)
	{
		// Get the length of first linked list
		int l1 = length(head1);

		// Get the length of first linked list
		int l2 = length(head2);

		// If l1!=l2 then linked list can not
		// be identical
		if (l1 != l2)
			return false;

		// Initialize the variables
		int Count = 0;
		boolean flag = false;

		// Initialize temporary pointers
		Node h1 = head1;
		Node h2 = head2;

		// Traverse the list
		while (true) {

			// If element matches in two
			// circular linked list
			if (h1.data == h2.data) {
				h1 = h1.next;
				Count++;

				// If count equals to l1(or l2)
				// then linked list are identical
				if (Count == l1)
					return true;
			}

			// If element does not matches
			// in two circular linked list
			else {
				h1 = head1;
				Count = 0;

				// If flag becomes 1 then one
				// rotation is complete and
				// if now data does not match then
				// linked lists are not identical
				if (flag)
					return false;
			}

			// Check if h2 complete one rotation
			if (h2.next == head2)
				flag = true;

			// Move h2 to h2.next
			h2 = h2.next;
		}
	}

	static Node head1, tail1, head2, tail2;
	// Driver Code
	public static void main(String[] args)
	{

		head1 = null;
		tail1 = null;

		head1 = tail1 = insertNode(head1, tail1, 1);
		tail1 = insertNode(head1, tail1, 2);
		tail1 = insertNode(head1, tail1, 3);
		tail1 = insertNode(head1, tail1, 4);
		tail1 = insertNode(head1, tail1, 5);
		tail1 = insertNode(head1, tail1, 1);
		tail1 = insertNode(head1, tail1, 2);
		tail1 = insertNode(head1, tail1, 6);

		head2 = null;
		tail2 = null;

		head2 = tail2 = insertNode(head2, tail2, 5);
		tail2 = insertNode(head2, tail2, 1);
		tail2 = insertNode(head2, tail2, 2);
		tail2 = insertNode(head2, tail2, 6);
		tail2 = insertNode(head2, tail2, 1);
		tail2 = insertNode(head2, tail2, 2);
		tail2 = insertNode(head2, tail2, 3);
		tail2 = insertNode(head2, tail2, 4);

		boolean flag = checkIdentical(head1, head2);
		if (flag)
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}

// This code is contributed by Lovely Jain
