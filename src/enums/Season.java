package enums;

enum Season {
    SPRING, SUMMER, FALL, WINTER
    // 0 ,    1,     2,    3
}

enum ErrorMessage {
    AAA(1, "SSSSS"), BBB(2, "DDDD");




    private static final ErrorMessage[] SSS = ErrorMessage.values();
    private final int number;
    private final String message;

    ErrorMessage(int number, String message) {
        this.number = number;
        this.message = message;
    }

    public int getNumber() {
        return number;
    }

    public String getMessage() {
        return message;
    }
}

class EnumExample {
    public static void main(String[] args) {
        Season season = Season.SUMMER;
//        System.out.println(season);
//        System.out.println(Season.FALL);

        System.out.println(Season.WINTER.ordinal());

        Season season2 = Season.valueOf("WINTER");
        System.out.println(season.compareTo(season2));

        for (Season s : Season.values()) {
            System.out.println(s);
        }
    }
}

class People {
    public String name;
    public Season favoriteSeason;

    public static void main(String[] args) {
        People people = new People();
        people.name = "이담영";
        people.favoriteSeason = Season.WINTER;

        People people1 = new People();
        people1.name = "천의령";
        people1.favoriteSeason = Season.FALL;



    }
}


