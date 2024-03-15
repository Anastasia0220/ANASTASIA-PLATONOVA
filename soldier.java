
/*
Online Java - IDE, Code Editor, Compiler

Online Java is a quick and easy tool that helps you to build, compile, test your programs online.
*/

import java.time.LocalDate;

public class Soldier {
    // Свойства
    private String lastName;
    private String company;
    private String rank;
    private LocalDate dateOfBirth;
    private LocalDate enlistmentDate;
    private String unit;

    // Конструктор
    public Soldier(String lastName, String company, String rank, LocalDate dateOfBirth, LocalDate enlistmentDate, String unit) {
        this.lastName = lastName;
        this.company = company;
        this.rank = rank;
        this.dateOfBirth = dateOfBirth;
        this.enlistmentDate = enlistmentDate;
        this.unit = unit;
    }

    // Методы геттеры и сеттеры
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getEnlistmentDate() {
        return enlistmentDate;
    }

    public void setEnlistmentDate(LocalDate enlistmentDate) {
        this.enlistmentDate = enlistmentDate;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    // Переопределение метода toString() для вывода полной информации об объекте
    @Override
    public String toString() {
        return String.format("Soldier:\n" +
                "Фамилия: %s\n" +
                "Рота: %s\n" +
                "Звание: %s\n" +
                "Дата рождения: %s\n" +
                "Дата поступления на службу: %s\n" +
                "Часть: %s",
                lastName, company, rank, dateOfBirth.toString(), enlistmentDate.toString(), unit);
    }

    public static void main(String[] args) {
        // Пример использования класса
        Soldier soldier = new Soldier("Иванов", "1-ая рота", "Рядовой", LocalDate.of(1990, 5, 15),
                LocalDate.of(2010, 8, 20), "101-я дивизия");
        System.out.println(soldier.toString());
    }
}