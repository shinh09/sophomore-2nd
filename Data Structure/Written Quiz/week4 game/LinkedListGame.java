public class LinkedListGame {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        // 삽입 예시
        list.insert(4, "Satan");
        list.insert(9, "Wizard");
        list.insert(7, "Angel");
        list.insert(2, "Witch");

        // 리스트 출력
        list.printList();

        // 삭제 예시
        list.delete(4);  // Satan 삭제
        list.delete(9);  // Wizard 삭제
        list.delete(2);  // Witch 삭제

        // 리스트 출력
        list.printList();
    }
}