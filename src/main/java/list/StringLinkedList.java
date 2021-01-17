package list;

public class StringLinkedList {
    StringNode head;
    StringNode tail;

    public boolean isEmpty() {
        return head == null;
    }

    public boolean add(String item) {
        StringNode node = new StringNode(item, null);
        if (isEmpty()) {
            head = node;
            tail = node;
            return true;
        }
        tail.next = node;
        tail = node;
        return true;
    }

    // dodawanie
    public boolean add(String item, int index) {
        StringNode node = new StringNode(item, null);
        //indexy ujemne, niemożliwe dodanie
        if (index < 0) {
            return false;
        }
        StringNode previous = getAt(index - 1);
        //brak  węzła poprzedniego gdy  nie wstawiamy na początek, niemożliwe dodanie
        if (previous == null && index > 0) {
            return false;
        }
        //jeśl  poprzedni to ogon t ogonem jest teraz nowy węzeł
        if (previous == tail) {
            tail = node;
        }
        // jeżeli wstawiamy na początek to nowa głąwoą jest teraz nowy węzeł
        if (index == 0) {
            node.next = head;
            head = node;
            return true;
        }
        StringNode temp = previous.next;
        previous.next = node;
        node.next = temp;
        return true;
    }

    StringNode getAt(int index) {
        int count = 0;
        StringNode current = head;
        while (current != null) {
            if (index == count) {
                return current;
            }
            count++;
            current = current.next;
        }
        return null;
    }

    public String get(int index) {
        int count = 0;
        StringNode current = head;
        while (current != null) {
            if (count == index) {
                return current.value;
            }
            count++;
            current = current.next;
        }
        /* StringNode node = getAt(index);
        if(node == null){
        return null;}*/
        return null;
    }

    public boolean remove(int index) {
        if (index < 0 || isEmpty()) {
            return false;
        }
        if (index == 0) {
            if(head == tail){
                tail = null;
            }
            head = head.next;
            return true;
        }


        StringNode previous = getAt(index - 1);
        if(previous == null){
            return false;
        }
        StringNode removed = previous.next;
        if(removed ==null){
            return false;
        }

        if (removed == tail ){
            tail = previous;
        }
        previous.next = removed.next;
        return true;
    }


    public int size() {
        int count = 0;
        StringNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public boolean isFull(){
        return false;
    }

}


