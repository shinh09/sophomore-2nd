class SinglyLinkedList {
    Node head;  // 연결 리스트의 첫 번째 노드를 가리킴 (강사)

    // 생성자: 비어있는 리스트 초기화
    public SinglyLinkedList() {
        this.head = null;
    }

    // 노드를 삽입하는 메소드
    public void insert(int data, String name) {
        Node newNode = new Node(data, name);
        if (head == null || head.data > data) {
            // 첫 번째 노드보다 작으면 새로운 노드가 맨 앞에 삽입됨
            newNode.next = head;
            head = newNode;
            System.out.println(name + "가(이) " + data + "를 가지고 삽입되었습니다.");
        } else {
            // 리스트 순회하여 적절한 위치에 삽입
            Node current = head;
            while (current.next != null && current.next.data < data) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
            System.out.println(name + "가(이) " + data + "를 가지고 삽입되었습니다.");
        }
    }

    // 노드를 삭제하는 메소드
    public void delete(int data) {
        if (head == null) {
            System.out.println("리스트가 비어있습니다.");
            return;
        }

        // 첫 번째 노드를 삭제하는 경우
        if (head.data == data) {
            System.out.println(head.name + "가(이) " + data + "를 가지고 삭제되었습니다.");
            head = head.next;
            return;
        }

        // 리스트 순회하며 삭제할 노드를 찾음
        Node current = head;
        while (current.next != null && current.next.data != data) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("해당 숫자 " + data + "를 가진 학생이 없습니다.");
        } else {
            System.out.println(current.next.name + "가(이) " + data + "를 가지고 삭제되었습니다.");
            current.next = current.next.next;  // 노드 삭제
        }
    }

    // 연결 리스트를 출력하는 메소드
    public void printList() {
        Node current = head;
        System.out.print("리스트: ");
        while (current != null) {
            System.out.print(current.name + "(" + current.data + ") -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
