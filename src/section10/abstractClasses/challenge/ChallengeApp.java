package section10.abstractClasses.challenge;

public class ChallengeApp {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList(null);
        list.traverse(list.getRoot());

        // Create string data array to avoid typing loads of addItem instructions
        String stringData = "Darwin Brisbane Perth Melbourne Canberra Adelaide Sydney Canberra";
        //String stringData = "8 7 6 1 2 5 4 3 9 0";
        String[] data = stringData.split(" ");
        for(String s : data) {
            list.addItem(new Node(s));
        }

        list.traverse(list.getRoot());
        list.removeItem(new Node("Darwin"));
//
//        list.traverse(list.getRoot());
//        list.removeItem(new Node("Melbourne"));
//
//        list.traverse(list.getRoot());
//        list.removeItem(new Node("Brisbane"));

        list.traverse(list.getRoot());

    }
}
