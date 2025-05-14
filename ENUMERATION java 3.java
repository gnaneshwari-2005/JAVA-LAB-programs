package BM23AI069;

import java.util.Scanner;
public class ENUMERATION {

    public enum DayOfWeek {
        SUNDAY,
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY;

        public boolean isWorkday() {
            return this.ordinal() >= MONDAY.ordinal() && this.ordinal() <= FRIDAY.ordinal();
        }
    }

    public static void main(String[] args) {
        for (DayOfWeek day : DayOfWeek.values()) {
            System.out.println(day + " is a workday? " + day.isWorkday());
        }
    }
}