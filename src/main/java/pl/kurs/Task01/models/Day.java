package pl.kurs.Task01.models;

import java.time.DayOfWeek;

public class Day {

        private final DayOfWeek dayName;
        private int counter;

        public Day(DayOfWeek dayName, int counter) {
            this.dayName = dayName;
            this.counter = counter;
        }

    public DayOfWeek getDayName() {
        return dayName;
    }

    public int getCounter() {
        return counter;
    }

    public int setCounter() {
        return counter += 1;
    }

    @Override
        public String toString() {
            return "Day{" +
                    "dayName=" + dayName +
                    ", counter=" + counter +
                    '}';
        }
}
