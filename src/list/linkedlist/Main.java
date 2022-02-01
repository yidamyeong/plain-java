package list.linkedlist;

public class Main {
    public static void main(String[] args) {
        LinkedList numbers = new LinkedList();
        numbers.addLast(10);
        numbers.addLast(20);
        numbers.addLast(30);
        numbers.addLast(40);
        numbers.addLast(50);
        System.out.println(numbers.toString());

        System.out.println(numbers.remove(0));
        System.out.println(numbers.toString());

        LinkedList.ListIterator i = numbers.listIterator();
//        while (i.hasNext()) {
//            System.out.println(i.next());
//        }
        i.add(5);  // 끼워넣기
        i.next();
        i.add(15);
        System.out.println(numbers);

        while (i.hasNext()) {
            if ((int) i.next() == 30) {
                i.add(88);
            }
        }

        System.out.println(numbers);
        i.remove();
        System.out.println(numbers);


    }
}
