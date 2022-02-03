package generics;

import java.util.ArrayList;

public class Generics {





    public static void main(String[] args) {

        ArrayList list = new ArrayList();
//      [ 0: _____, 1: ______,  2: _______,     ]
//      [ 0: 10, 1: "커피",  2: new ArrayList(),     ]

        list.add(10); // map.put(key, value)
        list.add("커피");
        list.add(new ArrayList());


        System.out.println((String) list.get(0));
        System.out.println((int) list.get(1));


        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("coffee");
        stringList.add("문자열만넣기로했지");

        String str1 = stringList.get(0);
        String str2 = stringList.get(1);









//     jdk1.5           jdk1.8




    }


}
