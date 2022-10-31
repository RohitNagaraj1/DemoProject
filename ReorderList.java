import java.util.*;

class Node 
{
    int data;
    Node next; 
    Node(int data) 
    {
        this.data = data; 
    }
}

class ReorderList 
{
    static Node head;
    public Node reverseList(Node head)
    {
        Node previous = null;
        while (head != null)
        {
            Node next = head.next;
            head.next = previous;
            previous = head;
            head = next;
        }
        return previous;
    }

    public void reorderList() 
    { 
        Node fast = head.next;
        Node slow = head;

        while (fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }

        Node next = slow.next;
        slow.next = null;
        Node secondList = reverseList(next);
        Node firstList = head;

        Node result = new Node(-1);
        Node temp = result;

        while (secondList != null && firstList != null)
        {
            temp.next = firstList;
            firstList = firstList.next;
            temp = temp.next;
            temp.next = secondList;
            secondList = secondList.next;
            temp = temp.next;
        }

        if (firstList != null)
        {
            temp.next = firstList;
        }

        if (secondList != null)
        {
            temp.next = secondList;
        }
        //Write your code here
        head = result.next;
    }

    void insert(int value) 
    {
        Node newNode = new Node(value);
        if (head == null) 
        { 
            head = newNode; return;
        }

        newNode.next = null;
        Node tmp = head;
        while (tmp.next != null)
        tmp = tmp.next;
        tmp.next = newNode;
        return; 
    }

    void display() 
    {
        Node tmp = head; while (tmp != null) {
        System.out.println(tmp.data);
        tmp = tmp.next; }
    }

    public static void main(String[] args) 
    { 
        Scanner in = new Scanner(System.in); 
        ReorderList ob = new ReorderList(); 
        int numberOfNodes = in .nextInt(); 
        while (numberOfNodes--> 0)
            ob.insert( in .nextInt());

        ob.reorderList(); 
        ob.display();
    } 
}
