class Node {
	int elements;
	Node next;

	Node(int elements) {
		this.elements = elements;
		this.next = null;
	}
}

class LinkedList {
	Node head;

	public void append(int elements) {
		if (head == null) {
			head = new Node(elements);
			return;
		}
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = new Node(elements);
	}

	public Node mergeSort(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node middle = getMiddle(head);
		Node nextOfMiddle = middle.next;
		middle.next = null;
		Node left = mergeSort(head);
		Node right = mergeSort(nextOfMiddle);
		return merge(left, right);
	}

	private Node getMiddle(Node head) {
		if (head == null)
			return head;
		Node slow = head, fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	private Node merge(Node left, Node right) {
		if (left == null)
			return right;
		if (right == null)
			return left;

		Node result;
		if (left.elements <= right.elements) {
			result = left;
			result.next = merge(left.next, right);
		} else {
			result = right;
			result.next = merge(left, right.next);
		}
		return result;
	}

	public void printList(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.elements + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	public void sort() {
		head = mergeSort(head);
	}
}

public class Sorting_linked_list {
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.append(3);
		list.append(1);
		list.append(4);
		list.append(2);
		System.out.println("Unsorted Linked List:");
		list.printList(list.head);
		list.sort();
		System.out.println("Sorted Linked List:");
		list.printList(list.head);
	}
}
