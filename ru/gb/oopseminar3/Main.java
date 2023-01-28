package ru.gb.oopseminar3;


import java.util.*;
import ru.gb.oopseminar3.add.ANSIConstants;
import java.util.concurrent.TimeUnit;


public class Main {
    public static void main(String[] args) throws Exception{
        Main m = new Main();
        Human h1 = new Human(1, "Анна Ивановна", "жен");
        Human h2 = new Human(2, "Инна Ивановна", "жен");
        Human h3 = new Human(3, "Иван Петрович", "муж");
        Human h4 = new Human(4, "Ольга Андреевна", "жен");
        Human h5 = new Human(5, "Петр Сергеевич", "муж");
        Human h6 = new Human(6, "Ирина Павловна", "жен");
        Human h7 = new Human(7, "Степан Андреевич", "муж");
        Human h8 = new Human(8, "Андрей Львович", "муж");
        Human h9 = new Human(9, "София Иосифовна", "жен");
        Human h10 = new Human(10, "Неизвестно", "Неизвестно");
        Set<Human> setHuman = new LinkedHashSet<>(Arrays.asList(h1, h2, h3,
                h4, h5, h6, h7, h8, h9));

        Person h1_1 = new Person (h1.getID(), h1.getName(), h1.getSex(), null, new LinkedHashSet<>(Arrays.asList(h2)), null, new LinkedHashSet<>(Arrays.asList(h3, h4)));
        Person h2_1 = new Person (h2.getID(), h2.getName(), h2.getSex(), null, new LinkedHashSet<>(Arrays.asList(h1)), null, new LinkedHashSet<>(Arrays.asList(h3, h4)));
        Person h3_1 = new Person (h3.getID(), h3.getName(), h3.getSex(), h4, null, new LinkedHashSet<>(Arrays.asList(h1, h2)), new LinkedHashSet<>(Arrays.asList(h5, h6)));
        Person h4_1 = new Person (h4.getID(), h4.getName(), h4.getSex(), h3, new LinkedHashSet<>(Arrays.asList(h7)), new LinkedHashSet<>(Arrays.asList(h1, h2)), new LinkedHashSet<>(Arrays.asList(h8, h9)));
        Person h5_1 = new Person (h5.getID(), h5.getName(), h5.getSex(), h6, null, new LinkedHashSet<>(Arrays.asList(h3)), new LinkedHashSet<>(Arrays.asList(h10)));
        Person h6_1 = new Person (h6.getID(), h6.getName(), h6.getSex(), h5, null, new LinkedHashSet<>(Arrays.asList(h3)), new LinkedHashSet<>(Arrays.asList(h10)));
        Person h7_1 = new Person (h7.getID(), h7.getName(), h7.getSex(), null, new LinkedHashSet<>(Arrays.asList(h4)), new LinkedHashSet<>(Arrays.asList(h10)), new LinkedHashSet<>(Arrays.asList(h8, h9)));
        Person h8_1 = new Person (h8.getID(), h8.getName(), h8.getSex(), h9, null, new LinkedHashSet<>(Arrays.asList(h4, h7)), new LinkedHashSet<>(Arrays.asList(h10)));
        Person h9_1 = new Person (h9.getID(), h9.getName(), h9.getSex(), h8, null, new LinkedHashSet<>(Arrays.asList(h4, h7)), new LinkedHashSet<>(Arrays.asList(h10)));
        Set<Person> setPerson = new LinkedHashSet<>(Arrays.asList(h1_1, h2_1, h3_1, h4_1, h5_1, h6_1, h7_1, h8_1, h9_1));

        m.displayMenu(setHuman, setPerson);
    }
    public void displayMenu(Set<Human> human, Set<Person> person) throws Exception {
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("\n" + ANSIConstants.ANSI_WHITE_BACKGROUND +
                    ANSIConstants.ANSI_BLACK + "ИССЛЕДОВАНИЕ ПО ГЕНЕАЛОГИЧЕСКОМУ ДРЕВУ"
                    + ANSIConstants.ANSI_RESET + "\n" +  "\n" + "*".repeat(45) +
                    "\nВыберите тип исследования: " + "\n" + "-".repeat(45) +
                    "\n1.Запрос ближайших родственников" +
                    "\n2.Запрос родственной связи для двоих человек" +
                    "\n3.Вывести все компоненты древа на экран" +
                    "\n4.Выход" + "\n" + "-".repeat(45) + "\n");
            System.out.print("Укажите нужный пункт меню: ");
            int choice = in.nextInt();
            in.nextLine();
            System.out.println("-".repeat(45));
            String s = "";
            Person x = null;
            Person y = null;
            Integer flag = 0;
            Integer flag1 = 0;
            switch (choice) {
                case 1:
                    System.out.println(human);
                    System.out.print("-".repeat(45) +
                            "\nУкажите ID нужного человека из списка выше: ");
                    int choice1 = in.nextInt();
                    in.nextLine();
                    for (Person item : person) {
                        if (item.getID() == choice1) {
                            s = "-".repeat(37) +
                                    ANSIConstants.ANSI_GREEN +
                                    "\nДля " + item.getName() +
                                    " найдены следующие ближайшие родственники: \n" +
                                    ANSIConstants.ANSI_RESET +
                                    "\nСупруг:        \t" +
                                    item.getNamesFromHumanOnly(item.getSpouse()) +
                                    "\nДети:          \t" +
                                    item.getNamesFromSetOnly(item.getChildren()) +
                                    "\nРодители:      \t" +
                                    item.getNamesFromSetOnly(item.getParents()) +
                                    "\nБратья/Сестры: \t" +
                                    item.getNamesFromSetOnly(item.getBrothers_sisters()) +
                                    "\n" + "-".repeat(45);
                            System.out.println(s);
                            TimeUnit.SECONDS.sleep(4);
                            flag = 1;
                            displayAddMenu(s, human, person);
                            break;
                        }
                    }
                    if (flag == 0) {
                        System.out.println(ANSIConstants.ANSI_RED
                                + "Неверно указан ID для поиска! Попробуйте снова!"
                                + ANSIConstants.ANSI_RESET);
                        TimeUnit.SECONDS.sleep(3);
                        displayMenu(human, person);
                    }
                    break;
                case 2:
                    System.out.println(human);
                    System.out.print("-".repeat(45)
                            + "\nУкажите ID первого человека из списка выше: ");
                    int choice2 = in.nextInt();
                    in.nextLine();
                    System.out.print("-".repeat(45)
                            + "\nУкажите ID второго человека из списка выше: ");
                    int choice3 = in.nextInt();
                    in.nextLine();
                    System.out.println("-".repeat(45));
                    for (Person item: person) {
                        if (item.getID() == choice2) {
                            x = item;
                            flag1 = flag1 + 1;
                        }
                        if (item.getID() == choice3) {
                            y = item;
                            flag1 = flag1 + 1;
                        }
                    }
                    if (flag1 < 2) {
                        System.out.println(ANSIConstants.ANSI_RED
                                + "Неверно указан(ы) ID для поиска! Попробуйте снова!"
                                + ANSIConstants.ANSI_RESET);
                        TimeUnit.SECONDS.sleep(3);
                        displayMenu(human, person);
                    }
                    if (x.spouse != null) {
                        if (x.spouse.getName() == y.getName()) {
                            if (y.getSex() == "муж") {
                                flag = 1;
                                s = ANSIConstants.ANSI_GREEN + "Для "
                                        + x.getName() + " " + y.getName()
                                        + " является супругом"
                                        + ANSIConstants.ANSI_RESET;
                            }
                            else if (y.getSex() == "жен") {
                                flag = 1;
                                s = ANSIConstants.ANSI_GREEN + "Для "
                                        + x.getName() + " " + y.getName()
                                        + " является супругой"
                                        + ANSIConstants.ANSI_RESET;
                            }
                            System.out.println(s);
                            displayAddMenu(s, human, person);
                        }
                    }
                    if (x.children != null) {
                        if (x.getNamesFromSetOnly(x.getChildren()).contains(y.getName())) {
                            if (y.getSex() == "муж") {
                                flag = 1;
                                s = ANSIConstants.ANSI_GREEN + "Для "
                                        + x.getName() + " " + y.getName()
                                        + " является сыном" + ANSIConstants.ANSI_RESET;
                            }
                            else if (y.getSex() == "жен") {
                                flag = 1;
                                s = ANSIConstants.ANSI_GREEN + "Для "
                                        + x.getName() + " " + y.getName()
                                        + " является дочерью" + ANSIConstants.ANSI_RESET;
                            }
                            System.out.println(s);
                            displayAddMenu(s, human, person);
                        }
                    }
                    if (x.parents != null) {
                        if (x.getNamesFromSetOnly(x.getParents()).contains(y.getName())) {
                            if (y.getSex() == "муж") {
                                flag = 1;
                                s = ANSIConstants.ANSI_GREEN + "Для "
                                        + x.getName() + " " + y.getName()
                                        + " является папой" + ANSIConstants.ANSI_RESET;
                            }
                            else if (y.getSex() == "жен") {
                                flag = 1;
                                s = ANSIConstants.ANSI_GREEN + "Для "
                                        + x.getName() + " " + y.getName()
                                        + " является мамой" + ANSIConstants.ANSI_RESET;
                            }
                            System.out.println(s);
                            displayAddMenu(s, human, person);
                        }
                    }
                    if (x.brothers_sisters != null) {
                        if (x.getNamesFromSetOnly(x.getBrothers_sisters()).contains(y.getName())) {
                            if (y.getSex() == "муж") {
                                flag = 1;
                                s = ANSIConstants.ANSI_GREEN + "Для "
                                        + x.getName() + " " + y.getName()
                                        + " является братом" + ANSIConstants.ANSI_RESET;
                            } else if (y.getSex() == "жен") {
                                flag = 1;
                                s = ANSIConstants.ANSI_GREEN + "Для "
                                        + x.getName() + " " + y.getName()
                                        + " является сестрой" + ANSIConstants.ANSI_RESET;
                            }
                            System.out.println(s);
                            displayAddMenu(s, human, person);
                        }
                    }
                    if (flag == 0) {
                        s = ANSIConstants.ANSI_GREEN + "Для "
                            + x.getName() + " " + y.getName()
                            + " не является ближайшим родственником "
                            + ANSIConstants.ANSI_RESET;
                        System.out.println(s);
                        displayAddMenu(s, human, person);
                    }
                    break;
                case 3:
                    System.out.println("Полный список по генеалогическому древу: ");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(person);
                    TimeUnit.SECONDS.sleep(4);
                    displayMenu(human, person);
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println(ANSIConstants.ANSI_RED
                            + "Неверно указан пункт меню! Попробуйте снова!"
                            + ANSIConstants.ANSI_RESET);
                    TimeUnit.SECONDS.sleep(2);
                    displayMenu(human, person);
            }
        } catch (InputMismatchException e) {
            System.out.println("-".repeat(53) + ANSIConstants.ANSI_RED +
                    "\nНеверный выбор! Необходимо ввести числовое значение!\n"
                    + ANSIConstants.ANSI_RESET + "-".repeat(53));
            TimeUnit.SECONDS.sleep(2);
            displayMenu(human, person);
        }
    }
    public void displayAddMenu(String str, Set<Human> human, Set<Person> person) throws Exception {
        Scanner inn = new Scanner(System.in);
        System.out.println("\n" + "=".repeat(45) +
                "\nСохранить эту информацию в Notes? " + "\n" + "=".repeat(45) +
                "\n1.Да, сохранить в текущий Notes" +
                "\n2.Очистить текущий Notes и сохранить" +
                "\n3.Нет, вернуться в Главное меню" +
                "\n4.Нет, выйти\n" + "-".repeat(45) + "\n");
        System.out.print("Укажите нужный пункт меню: ");
        int choice = inn.nextInt();
        inn.nextLine();
        System.out.println("-".repeat(45));
        Repository r = new Repository();
        switch (choice) {
            case 1:
                r.saveResultsOfSearch(str);
                displayMenu(human, person);
                break;
            case 2:
                r.clearFile();
                System.out.println(ANSIConstants.ANSI_GREEN + "Notes очищен!"
                        + ANSIConstants.ANSI_RESET);
                r.saveResultsOfSearch(str);
            case 3:
                displayMenu(human, person);
            case 4:
                System.exit(0);
        }
    }
}