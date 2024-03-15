
/*
Online Java - IDE, Code Editor, Compiler

Online Java is a quick and easy tool that helps you to build, compile, test your programs online.
*/

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Military {
    private static final String FILENAME = "soldiers.txt";

    public static void main(String[] args) {
        List<Soldier> soldiers = loadSoldiersFromFile();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Добавить солдата");
            System.out.println("2. Вывести список солдат, отсортированный по фамилиям");
            System.out.println("3. Вывести список солдат, отсортированный по зарплатам");
            System.out.println("4. Сохранить список солдат в файл");
            System.out.println("5. Загрузить список солдат из файла");
            System.out.println("6. Выход");
            System.out.print("Выберите действие: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // очистка буфера

            switch (choice) {
                case 1:
                    System.out.println("Введите данные солдата:");
                    Soldier newSoldier = inputSoldierFromUser(scanner);
                    soldiers.add(newSoldier);
                    break;
                case 2:
                    System.out.println("Список солдат, отсортированный по фамилиям:");
                    Collections.sort(soldiers);
                    for (Soldier soldier : soldiers) {
                        System.out.println(soldier.toString());
                    }
                    break;
                case 3:
                    System.out.println("Список солдат, отсортированный по зарплатам:");
                    Collections.sort(soldiers, Soldier.salaryComparator);
                    for (Soldier soldier : soldiers) {
                        System.out.println(soldier.toString());
                    }
                    break;
                case 4:
                    saveSoldiersToFile(soldiers);
                    System.out.println("Список солдат сохранен в файл.");
                    break;
                case 5:
                    soldiers = loadSoldiersFromFile();
                    System.out.println("Список солдат загружен из файла.");
                    break;
                case 6:
                    System.out.println("Программа завершена.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Неверный ввод. Попробуйте еще раз.");
            }
        }
    }

    private static Soldier inputSoldierFromUser(Scanner scanner) {
        System.out.print("Фамилия: ");
        String lastName = scanner.nextLine();
        System.out.print("Рота: ");
        String company = scanner.nextLine();
        System.out.print("Звание: ");
        String rank = scanner.nextLine();
        System.out.print("Дата рождения (гггг-мм-дд): ");
        LocalDate dateOfBirth = LocalDate.parse(scanner.nextLine());
        System.out.print("Дата поступления на службу (гггг-мм-дд): ");
        LocalDate enlistmentDate = LocalDate.parse(scanner.nextLine());
        System.out.print("Часть: ");
        String unit = scanner.nextLine();
        System.out.print("Зарплата: ");
        int salary = scanner.nextInt();
        scanner.nextLine(); // очистка буфера

        return new Soldier(lastName, company, rank, dateOfBirth, enlistmentDate, unit, salary);
    }

    private static void saveSoldiersToFile(List<Soldier> soldiers) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
            outputStream.writeObject(soldiers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Soldier> loadSoldiersFromFile() {
        List<Soldier> soldiers = new ArrayList<>();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILENAME))) {
            Object obj = inputStream.readObject();
            if (obj instanceof List) {
                soldiers = (List<Soldier>) obj;
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Файл не найден или произошла ошибка при чтении файла.");
        }
        return soldiers;
    }
}

class Soldier implements Comparable<Soldier>, Serializable {
    private String lastName;
    private String company;
    private String rank;
    private LocalDate dateOfBirth;
    private LocalDate enlistmentDate;
    private String unit;
    private int salary;

    public Soldier(String lastName, String company, String rank, LocalDate dateOfBirth, LocalDate enlistmentDate, String unit, int salary) {
        this.lastName = lastName;
        this.company = company;
        this.rank = rank;
        this.dateOfBirth = dateOfBirth;
        this.enlistmentDate = enlistmentDate;
        this.unit = unit;
        this.salary = salary;
    }

    @Override
    public int compareTo(Soldier other) {
        return this.lastName.compareTo(other.lastName);
    }

    @Override
    public String toString() {
        return String.format("Soldier:\n" +
                "Фамилия: %s\n" +
                "Рота: %s\n" +
                "Звание: %s\n" +
                "Дата рождения: %s\n" +
                "Дата поступления на службу: %s\n" +
                "Часть: %s\n" +
                "Зарплата: %d",
                lastName, company, rank, dateOfBirth.toString(), enlistmentDate.toString(), unit, salary);
    }

    public static Comparator<Soldier> salaryComparator = new Comparator<Soldier>() {
        @Override
        public int compare(Soldier s1, Soldier s2) {
            return s1.getSalary() - s2.getSalary();
        }
    };

    public int getSalary() {
        return salary;
    }
}