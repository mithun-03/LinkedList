import java.util.Scanner;

public class MainDLL {

    public static void main(String[] args) {

        Scanner get = new Scanner(System.in);
        DLL list = new DLL();
        boolean flag = true;
        while (flag) {
            System.out.println("\n  choice\t\tOperation");
            System.out.println("-------------------------------------------------");
            System.out.println("1\t\tInsertAtBeg");
            System.out.println("2\t\tInsert");
            System.out.println("3\t\tInsertAtEnd");
            System.out.println("4\t\tReverse");
            System.out.println("5\t\tDeleteAtBeginning");
            System.out.println("6\t\tDelete");
            System.out.println("7\t\tDeleteAtEnd");
            System.out.println("8\t\tSort");
            System.out.println("9\t\tDisplay");

            int choice = get.nextInt();

            switch (choice) {
                case 1:
                    list.InsertAtBeg();
                    break;
                case 2:
                    list.Insert();
                    break;
                case 3:
                    list.InsertAtEnd();
                    break;
                case 4:
                    list.reverse();
                    break;
                case 5:
                    list.deleteAtBeg();
                    break;
                case 6:
                    list.delete();
                    break;
                case 7:
                    list.deleteAtEnd();
                    break;
                case 8:
                    list.sort();
                    break;
                case 9:
                    list.display();
                    break;

                default:
                    flag = false;
                    break;

            }

        }
    }
}

class Node {
    Node next;
    Node prev;
    int data;

    Node(int data) {
        this.data = data;
        next = null;
        prev = null;
    }
}

class DLL {
    Node head;
    Node tail;
    public int node_count = 0;

    Scanner get = new Scanner(System.in);

    public void InsertAtEnd() {
        System.out.print("Enter the data : ");
        Node temp = new Node(get.nextInt());

        if (this.head == null) {
            this.head = this.tail = temp;
        } else {
            temp.prev = tail;
            tail.next = temp;
            tail = temp;
        }
        ++node_count;
    }

    public void InsertAtBeg() {
        System.out.print("Enter the data : ");
        Node temp = new Node(get.nextInt());

        if (this.head == null) {
            this.head = this.tail = temp;
        } else {
            temp.next = head;
            head.prev = temp;
            head = temp;
        }
        ++node_count;
    }

    public void Insert() {
        System.out.print("Enter the position 1based index : ");
        int pos = get.nextInt();
        try {
            if (pos - 1 > node_count) {
                System.out.println("ReEnter the position from 1 to " + (node_count + 1));
                Thread.sleep(3);
                Insert();
            }
        } catch (Exception e) {
            System.out.print(e);
        }

        System.out.print("Enter the data : ");
        Node temp = new Node(get.nextInt());

        if (pos == 1) {
            if (head == null) {
                head = temp;
            } else {
                temp.next = head;
                head.prev = temp;
                head = temp;
            }

        } else {
            int i = 1;
            Node p = head, q = head;
            for (i = 1; i < pos; ++i) {
                p = q;
                q = q.next;
            }
            if (p == tail) {
                p.next = temp;
                temp.prev = p;
                tail = temp;
            } else {
                p.next = temp;
                temp.prev = p;
                temp.next = q;
                q.prev = temp;
            }
        }

        ++node_count;
    }

    public void display() {
        Node p = this.head;

        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
    }

    public void reverse() {
        if (head == null || head.next == null)
            return;

        Node p = head, q, temp = null;

        while (p != null) {
            q = p.next;
            p.next = temp;
            p.prev = q;
            temp = p;
            p = q;
        }
        tail = head;
        head = temp;

    }

    public void deleteAtBeg() {
        if (head == null) {
            System.out.print("Please Insert an element to delete ... \n");
            return;
        }
        if (head == tail) {
            head = tail = null;

        } else {
            Node p = head;
            head = head.next;
            head.prev = null;
            p.next = p.prev = null;
            p = null;
        }
        node_count--;

    }

    public void deleteAtEnd() {
        if (head == null) {
            System.out.print("Please Insert an element to delete ... \n");
            return;
        }
        if (head == tail) {
            head = tail = null;

        } else {
            Node p = tail;
            tail = tail.prev;
            tail.next = null;
            p.prev = p.next = null;
            p = null;
        }
        --node_count;
    }

    public void delete() {
        if (head == null) {
            System.out.print("Please Insert an element to delete ... \n");
            return;
        }

        System.out.println("Enter the position  from 1 to " + node_count);
        int pos = get.nextInt();
        if (pos < 1 && pos > node_count) {
            System.out.println("RE Enter the correct position ..");
            delete();
        }

        if (pos == 1) {
            deleteAtBeg();
            return;
        }
        if (pos == node_count) {
            deleteAtEnd();
            return;
        }

        Node p = head;

        for (int i = 1; i < pos; ++i) {
            p = p.next;
        }
        p.prev.next = p.next;
        p.next.prev = p.prev;
        p.next = p.prev = null;

        p = null;
        --node_count;

    }

    public void sort() {
        int dat = 0;
        if (head == null || head.next == null)
            return;

        for (Node p = head; p.next != null; p = p.next) {
            for (Node q = p.next; q != null; q = q.next) {
                if (q.data < p.data) {
                    dat = p.data;
                    p.data = q.data;
                    q.data = dat;
                }
            }
        }
    }

}