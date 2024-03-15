
/*
Online Java - IDE, Code Editor, Compiler

Online Java is a quick and easy tool that helps you to build, compile, test your programs online.
*/

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Soldier implements Comparable<Soldier> {
    // Свойства
    private String lastName;
    private String company;
    private String rank;
    private LocalDate dateOfBirth;
    private LocalDate enlistmentDate;
    private String unit;
    private int salary;

    // Конструктор
    public Soldier(String lastName, String company, String rank, LocalDate dateOfBirth, LocalDate enlistmentDate, String unit, int salary) {
        this.lastName = lastName;
        this.company = company;
        this.rank = rank;
        this.dateOfBirth = dateOfBirth;
        this.enlistmentDate = enlistmentDate;
        this.unit = unit;
        this.salary = salary;
    }

    // Геттеры и сеттеры

    // Переопределение метода compareTo для сравнения по фамилии
    @Override
    public int compareTo(Soldier other) {
        return this.lastName.compareTo(other.lastName);
    }

    // Переопределение метода toString для вывода информации об объекте
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

    // Метод для сравнения по зарплатам
    public static Comparator<Soldier> salaryComparator = new Comparator<Soldier>() {
        @Override
        public int compare(Soldier s1, Soldier s2) {
            return s1.getSalary() - s2.getSalary();
        }
    };

    // Геттер для зарплаты
    public int getSalary() {
        return salary;
    }

    public static void main(String[] args) {
        // Пример использования сортировки по фамилиям
        List<Soldier> soldiers = new ArrayList<>();
        soldiers.add(new Soldier("Иванов", "1-ая рота", "Рядовой", LocalDate.of(1990, 5, 15),
                LocalDate.of(2010, 8, 20), "101-я дивизия", 200000));
        soldiers.add(new Soldier("Петров", "2-ая рота", "Сержант", LocalDate.of(1985, 8, 25),
                LocalDate.of(2005, 6, 10), "101-я дивизия", 300000));

        System.out.println("Сортировка по фамилиям:");
        Collections.sort(soldiers);
        for (Soldier soldier : soldiers) {
            System.out.println(soldier.toString());
        }

        // Пример использования сортировки по зарплатам
        System.out.println("\nСортировка по зарплатам:");
        Collections.sort(soldiers, Soldier.salaryComparator);
        for (Soldier soldier : soldiers) {
            System.out.println(soldier.toString());
        }
    }
}