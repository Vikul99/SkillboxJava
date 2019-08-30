package Accounts;

import java.time.LocalDate;

public class MyTime {
    private static MyTime instance;
    private LocalDate date;

    private MyTime() {
        date = LocalDate.now();
    }

    public static MyTime getInstance() {
        if (instance == null) {
            instance = new MyTime();
        }
        return instance;
    }

    public void setNow(LocalDate date) {
        this.date = date;
    }

    public LocalDate now() {
        return date;
    }
}
