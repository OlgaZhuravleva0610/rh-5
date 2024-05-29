import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

class Client {
    private int id;
    private String name;
    private int age;
    private String gender;
    private List<Phone> phones;

    public Client(int id, String name, int age, String gender, List<Phone> phones) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phones = phones;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public List<Phone> getPhones() {
        return phones;
    }
}

class Phone {
    private String number;
    private String type;

    public Phone(String number, String type) {
        this.number = number;
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public String getType() {
        return type;
    }
}

class Main {

    public static void main(String[] args) {
        List<Client> clients = new ArrayList<>();

        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            List<Phone> phones = new ArrayList<>();
            for (int j = 0; j < 2; j++) {
                String type = random.nextBoolean() ? "мобильный" : "домашний";
                String number = "666-777" + random.nextInt(100);
                Phone phone = new Phone(number, type);
                phones.add(phone);
            }
            Client client = new Client(i, "клиент" + i, random.nextInt(80), random.nextBoolean() ? "мужчина" : "женщина", phones);
            clients.add(client);
        }

        // ищем самого старого клиента который польузется домашним
        Client oldestClientWithLandline = clients.stream()
                .filter(c -> c.getPhones().stream().anyMatch(p -> p.getType().equals("домашний")))
                .max((c1, c2) -> c1.getAge() - c2.getAge())
                .orElse(null);
        System.out.println("Самый старый клиент с домашним телефоном: " + oldestClientWithLandline.getName());

        // расчитываем средний возраст людей с домащним телефончиком
        double averageAgeOfClientsWithLandline = clients.stream()
                .filter(c -> c.getPhones().stream().anyMatch(p -> p.getType().equals("домашний")))
                .mapToInt(Client::getAge)
                .average()
                .orElse(0);
        System.out.println("Средний возраст клиентов с домашними телефонами: " + averageAgeOfClientsWithLandline);

        // клиенты в возрасте 18+ у кого есть мобильный
        List<Client> clientsAgedAbove18WithMobile = clients.stream()
                .filter(c -> c.getAge() >= 18 && c.getPhones().stream().anyMatch(p -> p.getType().equals("мобильный")))
                .collect(Collectors.toList());
        System.out.println("клиенты в возрасте 18+, имеющие мобильные телефоны:");
        clientsAgedAbove18WithMobile.forEach(c -> System.out.println(c.getName()));

        // проверка на женщину старше 60 имеющую домашний телефон
        boolean isFemaleAbove60WithLandline = clients.stream()
                .anyMatch(c -> c.getGender().equals("женщина") && c.getAge() > 60 &&
                        c.getPhones().stream().anyMatch(p -> p.getType().equals("домашний")));
        System.out.println("Есть хотя бы одна клиентка старше 60 лет с домашним телефоном? " + isFemaleAbove60WithLandline);

        // сортируем телефонну книгу по имени и возрасту
        clients.sort((c1, c2) -> {
            if (c1.getName().equals(c2.getName())) {
                return c1.getAge() - c2.getAge();
            } else {
                return c1.getName().compareTo(c2.getName());
            }
        });

        //выводим получившуюся сортировку
        System.out.println("Телефонная книга, отсортированная по имени и возрасту:");
        clients.forEach(c -> System.out.println(c.getName() + " - " + c.getAge()));
    }
}
