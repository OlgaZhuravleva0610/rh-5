public class Time {
    private int hour;
    private int minute;
    private int second;

    public Time(int hour, int minute, int second) {
        if (hour < 0 || hour >= 24 || minute < 0 || minute >= 60 || second < 0 || second >= 60) {
            throw new IllegalArgumentException("Неверное время");
        }
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public void changeTime(int hours, int minutes, int seconds) {
        int totalSeconds = hour * 3600 + minute * 60 + second;
        totalSeconds += hours * 3600 + minutes * 60 + seconds;

        if (totalSeconds < 0) {
            throw new IllegalArgumentException("Ошибка, время не может быть отрицательным");
        }

        hour = (totalSeconds / 3600) % 24;
        minute = (totalSeconds % 3600) / 60;
        second = totalSeconds % 60;
    }

    public static void main(String[] args) {
        try {
            Time time = new Time(23, 0, 0);
            System.out.println("Текущее время: " + time.hour + ":" + time.minute + ":" + time.second);

            time.changeTime(1, 0, 0);
            System.out.println("Измененное время: " + time.hour + ":" + time.minute + ":" + time.second);

            // Попытка установить недопустимое значение времени
            // Time invalidTime = new Time(25, 70, 80); // Вызовет исключение
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
