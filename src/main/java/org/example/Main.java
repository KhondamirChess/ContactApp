package org.example;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    private static final ArrayList<Contact> list = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean flag = true;


        while (flag) {
            System.out.println("""
                    1 - Добавить контакт
                    2 - Удалить контакт
                    3 - Посмотреть все контакты
                    4 - Найти контакт по имени
                    5 - Посмотреть контакты по группе
                    0 - Выход""");
            int input = Integer.parseInt(scanner.nextLine());
            switch (input) {
                case 1:
                    addContact(list);
                    break;
                case 2:
                    removeContact(list);
                    break;
                case 3:
                    showAllContacts(list);
                    break;
                case 4:
                    searchContact(list);
                    break;
                case 5:

                    showByGroup(list);
                    break;
                case 0:
                    flag = false;
            }
        }

    }

    public static void addContact(ArrayList<Contact> list) {
        System.out.println("1 - Добавить контакт");
        boolean addFlag = true;
        while (addFlag) {
            System.out.println("input name:");
            String name = scanner.nextLine();
            if (name.isEmpty()) {
                System.out.println("Неправильный ввод имени");
                break;
            }
            System.out.println("input phone number:");
            int number;
            try {
                number = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Неправильный ввод телефона");
                break;
            }
            System.out.println("input email");
            String email = scanner.nextLine();
            if (email.isEmpty()) {
                System.out.println("Неправильный ввод email");
                break;
            }
            System.out.println("""
                    input group
                    1. Family
                    2. Work
                    3. Friends
                    """);
            int group = Integer.parseInt(scanner.nextLine());
            String groupName = "";
            switch (group) {
                case 1:
                    groupName = "Family";
                    break;
                case 2:
                    groupName = "Work";
                    break;
                case 3:
                    groupName = "Friends";
                    break;
                default:
                    System.out.println("Incorrect input");
                    addFlag = false;
                    break;
            }
            if (!addFlag) break;
            addFlag = false;
            if (list.contains(new Contact(name, number, email, groupName))) {
                System.out.println("Контакт уже существует.");
                return;
            }
            list.add(new Contact(name, number, email, groupName));
        }
        System.out.println("новый контакт добавлен");
    }

    public static void removeContact(ArrayList<Contact> list) {
        System.out.println("2 - Удалить контакт");
        String name = scanner.nextLine();
        int startSize = list.size();
        list.removeIf(contact -> contact.getName().equals(name));
        int finishSize = list.size();
        if (startSize != finishSize) {
            System.out.println("Контакт удален");
        } else {
            System.out.println("Контакт не найден");
        }
    }

    public static void showAllContacts(ArrayList<Contact> list) {
        if (list.isEmpty()) {
            System.out.println("Список контактов пуст.");
            return;
        }

        for (Contact contact : list) {
            System.out.println(contact);
        }

    }

    public static void searchContact(ArrayList<Contact> list) {
        System.out.println("Поиск контакта");
        String name = scanner.nextLine();
        for (Contact contact : list) {
            if (contact.getName().equals(name)) {
                System.out.println(contact);
            }
        }
    }

    public static void showByGroup(ArrayList<Contact> list) {
        System.out.println("Посмотреть контакты по группе");
        System.out.println("""
                input group
                1. Family
                2. Work
                3. Friends
                """);
        int group = Integer.parseInt(scanner.nextLine());
        String groupName = "";
        switch (group) {
            case 1:
                groupName = "Family";
                break;
            case 2:
                groupName = "Work";
                break;
            case 3:
                groupName = "Friends";
                break;
            default:
                System.out.println("Incorrect input");
        }
        for (Contact contact : list) {
            if (contact.getGroup().equalsIgnoreCase(groupName)) {
                System.out.println(contact);
            }
        }
    }
}