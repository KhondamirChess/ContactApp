package org.example;


public class Main {
    private static ArrayList<Contact> list = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        boolean flag = true;


        while (flag){
            System.out.println("1 - Добавить контакт\n" +
                    "2 - Удалить контакт\n" +
                    "3 - Посмотреть все контакты\n" +
                    "4 - Найти контакт по имени\n" +
                    "5 - Посмотреть контакты по группе\n" +
                    "0 - Выход");
            int input = Integer.parseInt(scanner.nextLine());
            switch (input){
                case 1:
                    System.out.println("1 - Добавить контакт");
                    addContact(list);
                    break;
                case 2:
                    System.out.println("2 - Удалить контакт");
                    removeContact(list);
                    break;
                case 3:
                    for (Contact contact : list) {
                        System.out.println(contact);
                    }
                    break;
                case 4:
                    System.out.println("Поиск контакта");
                    searchContact(list);
                    break;
                case 5:
                    System.out.println("Посмотреть контакты по группе");
                    showByGroup(list);
                    break;
                case 0:
                    flag = false;
                    break;
            }
        }

    }

    public static void addContact(ArrayList<Contact> list){
        System.out.println("input name:");
        String name = scanner.nextLine();
        System.out.println("input phone number:");
        int number = Integer.parseInt(scanner.nextLine());
        System.out.println("input email");
        String email = scanner.nextLine();
        System.out.println("input group");
        String group = scanner.nextLine();
        list.add(new Contact(name, number,email,group));
        System.out.println("новый контакт добавлен");
    }

    public static void removeContact(ArrayList<Contact> list){
        String name = scanner.nextLine();
        int startSize = list.size();
        for (Contact contact : list){
            if (contact.getName().equals(name)){
                list.remove(contact);
            }
        }
        int finishSize = list.size();
        if (startSize != finishSize){
            System.out.println("Контакт удален");
        }else {
            System.out.println("Контакт не найден");
        }
    }
    public static void searchContact(ArrayList<Contact> list){
        String name = scanner.nextLine();
        for (Contact contact : list){
            if(contact.getName().equals(name)){
                System.out.println(contact);
            }
        }
    }

    public static void showByGroup(ArrayList<Contact> list){
        String groupName = scanner.nextLine();
        for (Contact contact : list){
            if (contact.getGroup().equalsIgnoreCase(groupName)){
                System.out.println(contact);
            }
        }
    }
}