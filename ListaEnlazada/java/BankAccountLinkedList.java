

public class BankAccountLinkedList {
    private Node head = null;
    private int size = 0;
    
    private class Node{
        public BankAccount account;
        public Node next = null;

        public Node(BankAccount account){
            this.account = account;
        }

    }

    public void insertAtBeginning(BankAccount account) {
        Node node = new Node(account);
        node.next = head;
        head = node;
        size++;
    }
    

    public void insertAtEnd(BankAccount account) {
        Node newNode = new Node(account);
    
        if (head == null) {
            head = newNode;
        } else {
            Node node = head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = newNode;
        }
        size++;
    }
    

    public void insertInMiddle(int position, BankAccount account) {
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException("Invalid position");
        }
    
        Node newNode = new Node(account);
    
        if (position == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node node = head;
            int currentPosition = 0;
    
            while (currentPosition < position - 1) {
                node = node.next;
                currentPosition++;
            }
    
            newNode.next = node.next;
            node.next = newNode;
        }
        size++;
    }
    

    public BankAccount getAccount(int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException("Invalid position");
        }
    
        Node node = head;
        int currentPosition = 0;
    
        while (currentPosition < position) {
            node = node.next;
            currentPosition++;
        }
    
        return node.account;
    }
    

    public int countList(){
       return size;
    }

    public boolean isEmpty() {
        return head == null;
    }
    

    public boolean deleteAtBeginning() {
        if (head != null) {
            Node node = head;
            head = head.next;
            node.next = null;
            size--;
            return true;
        }
        return false;
    }
    
    public boolean deleteAtEnd() {
        if (head != null) {
            if (head.next == null) {
                head = null;
            } else {
                Node node = head;
                while (node.next.next != null) {
                    node = node.next;
                }
                node.next = null;
            }
            size--;
            return true;
        }
        return false;
    }
    

    public boolean deleteInMiddle(int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException("Invalid position");
        }
    
        if (head != null) {
            if (position == 0) {
                return deleteAtBeginning();
            } else {
                Node node = head;
                int currentPosition = 0;
    
                while (currentPosition < position - 1) {
                    node = node.next;
                    currentPosition++;
                }
    
                Node temp = node.next;
                node.next = temp.next;
                temp.next = null;
                size--;
                return true;
            }
        }
        return false;
    }
    
}
