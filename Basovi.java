
// абстрактный класс abs_ut
abstract class abs_ut {
    abstract void poisk(Basovi[] array, int count);
}

// класс basovi, наследующий abs_ut
class Basovi extends abs_ut {
    String vladelec;

    public void setVladelec(String vladelec) {
        this.vladelec = vladelec;
    }

    public String getVladelec() {
        return vladelec;
    }

    @Override
    void poisk(Basovi[] array, int count) {
        // реализация поиска объекта собаки заданной породы
    }
}

// интерфейс inter
interface inter {
    void reading(Basovi[] array, int count);
}

// класс dog, наследующий basovi и реализующий интерфейс inter
class dog extends Basovi implements inter {
    int age;

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public void reading(Basovi[] array, int count) {
        // реализация ввода данных в массив объектов
    }
}

class Main {
    public static void main(String[] args) {
        int count = 3; // количество объектов
        Basovi[] array = new Basovi[count]; // создание массива объектов

        // цикл для вызова методов
        for (int i = 0; i < count; i++) {
            array[i] = new dog(); // создание объекта класса dog
            ((dog)array[i]).reading(array, count); // вызов метода reading для ввода данных
            array[i].poisk(array, count); // вызов метода poisk для поиска собаки заданной породы
        }
    }
}