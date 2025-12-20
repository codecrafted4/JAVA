class Node{
    int data;
    Node next;
    public Node(int data)
    {
        this.data = data;
        this.next = null;
    }
}

class LinkedList{
    Node head=null;
    void add_data(int val){
        Node newNode = new Node(val);
        if(head==null){
            head = newNode;
            return;
        }
        Node curr = head;
        while(curr.next!= null)
        {
            curr= curr.next;
        }
        curr.next = newNode;
    }
    void printll(){
        Node curr = head;
        if(head == null)
        {
            System.out.println("empty linkedlist");
            return;
        }
        while(curr!=null)
        {
            System.out.print(curr.data + "->");
            curr= curr.next;
        }
        System.out.print("null");
    }
    int size(){
        int count = 0;
        Node curr = head;
        while(curr!=null)
        {
            count++;
            curr= curr.next;
        }
        return count;
    }
    void deleteLast()
    {
        if(head==null)
        {
            System.out.println("no value to delete");
            return;
        }
        if(head.next==null)
        {
            head=null;
            return;
        }
        Node curr = head;
        while(curr.next.next!=null)
        {
            curr = curr.next;

        }
        curr.next = null;
    }
    void reverse()
    {
        if(head==null)
        {
            return;
        }
        Node curr = head;
        Node nextNode=null;
        Node prev = null;
        while(curr!=null)
        {
            nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;

        }
        head = prev;
        

    }
}


public class Main1 {
    public static void main(String args[])
    {
        LinkedList ll = new LinkedList();
        ll.add_data(10);
        ll.add_data(20);
        ll.add_data(30);
        ll.add_data(40);
        ll.add_data(50);
        ll.printll();
        System.out.println("  "+ll.size());
        ll.deleteLast();
        ll.deleteLast();
        ll.deleteLast();
        ll.deleteLast();
        ll.deleteLast();
        ll.add_data(10);
        ll.add_data(20);
        ll.add_data(30);
        ll.add_data(40);
        ll.add_data(50);
        ll.printll();
        ll.reverse();
        
        System.out.println();
        ll.printll();

    }
    
}
