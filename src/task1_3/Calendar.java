package task1_3;

//Создать класс Календарь с внутренним классом, с помощью объектов которого можно хранить информацию о
//выходных и праздничных днях.

import java.util.ArrayList;
import java.util.List;

class Calendar {
    private String date;
    private String info;


    public Calendar(String date, String info) {
        this.date = date;
        this.info = info;
    }

    public String toString() {
        return String.format("date: %s\t info: %s\n",
                date, info);
    }


    private ArrayList<Calendar> calendarsList = new ArrayList<>();
    void addCalendar(Calendar calendar) { //создаем метод добавления информации в лист
        calendarsList.add(calendar);
    }

    private String nameCalendar; //назовем лист Calendar
    Calendar(String nameCalendar) {
        this.nameCalendar = nameCalendar;
    }

    // Внутренний класс
    public class Holiday {
        public String getDate(){
            return date;
        }

        public String getInfo(){
            return info;
        }

        public List<Calendar> getCalendar() {
            List<Calendar> list = new ArrayList<>(calendarsList);
            return list;
        }
    }

    public static void main(String args[]) {
        // Создание внешнего класса
        Calendar weekends = new Calendar("Бярозка");
        weekends.addCalendar(new Calendar("1 апреля","День юмора"));
        weekends.addCalendar(new Calendar("1 января","Новый год"));
        weekends.addCalendar(new Calendar("7 января","Рождество Христово"));
        weekends.addCalendar(new Calendar("8 марта","День женщин"));
        weekends.addCalendar(new Calendar("1 мая","Праздник труда"));

        // Создание внутреннего класса
        Calendar.Holiday fiesta = weekends.new Holiday();
        System.out.println(fiesta.getCalendar());
    }
}
