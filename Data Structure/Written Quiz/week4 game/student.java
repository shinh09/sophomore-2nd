class Node {
    int data;           // 학생이 가진 번호 (카드의 숫자)
    String name;        // 학생 이름
    Node next;          // 다음 학생을 가리킴 (연결 리스트의 다음 노드)

    // 노드(학생)를 생성하는 생성자
    public Node(int data, String name) {
        this.data = data;
        this.name = name;
        this.next = null;
    }
}
