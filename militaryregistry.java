
/*
Online Java - IDE, Code Editor, Compiler

Online Java is a quick and easy tool that helps you to build, compile, test your programs online.
*/

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// Родительский класс "Военный состав"
class Military {
    private String lastName;
    private String company;
    private String rank;
    private LocalDate dateOfBirth;
    private LocalDate enlistmentDate;
    private String unit;

    // Конструктор
    public Military(String lastName, String company, String rank, LocalDate dateOfBirth, LocalDate enlistmentDate, String unit) {
        this.lastName = lastName;
        this.company = company;
        this.rank = rank;
        this.dateOfBirth = dateOfBirth;
        this.enlistmentDate = enlistmentDate;
        this.unit = unit;
    }

    // Геттеры и сеттеры

    @Override
    public String toString() {
        return "Фамилия: " + lastName + ", Рота: " + company + ", Звание: " + rank +
                ", Дата рождения: " + dateOfBirth + ", Дата поступления на службу: " + enlistmentDate +
                ", Часть: " + unit;
    }
}

// Дочерний класс "Органы военного управления"
class MilitaryAdministration extends Military {
    private String districtName;
    private String position;
    private int yearsOfService;
    private double bonusAmount;

    // Конструктор
    public MilitaryAdministration(String lastName, String company, String rank, LocalDate dateOfBirth, LocalDate enlistmentDate, String unit,
                                  String districtName, String position, int yearsOfService, double bonusAmount) {
        super(lastName, company, rank, dateOfBirth, enlistmentDate, unit);
        this.districtName = districtName;
        this.position = position;
        this.yearsOfService = yearsOfService;
        this.bonusAmount = bonusAmount;
    }

    @Override
    public String toString() {
        return super.toString() + ", Название округа: " + districtName + ", Должность: " + position +
                ", Выслуга лет: " + yearsOfService + ", Сумма надбавки: " + bonusAmount;
    }
}

// Дочерний класс "Военная служба по контракту"
class MilitaryServiceContract extends Military {
    private String contractPeriod;
    private LocalDate contractDate;
    private int protocolNumber;
    private double salaryAmount;

    // Конструктор
    public MilitaryServiceContract(String lastName, String company, String rank, LocalDate dateOfBirth, LocalDate enlistmentDate, String unit,
                                   String contractPeriod, LocalDate contractDate, int protocolNumber, double salaryAmount) {
        super(lastName, company, rank, dateOfBirth, enlistmentDate, unit);
        this.contractPeriod = contractPeriod;
        this.contractDate = contractDate;
        this.protocolNumber = protocolNumber;
        this.salaryAmount = salaryAmount;
    }

    @Override
    public String toString() {
        return super.toString() + ", Период договора: " + contractPeriod + ", Дата договора: " + contractDate +
                ", Номер протокола: " + protocolNumber + ", Сумма зарплаты: " + salaryAmount;
    }
}

// Дочерний класс "Награжденные"
class Awarded extends Military {
    private String awardName;
    private double prize;
    private double bonusAmount;

    // Конструктор
    public Awarded(String lastName, String company, String rank, LocalDate dateOfBirth, LocalDate enlistmentDate, String unit,
                   String awardName, double prize, double bonusAmount) {
        super(lastName, company, rank, dateOfBirth, enlistmentDate, unit);
        this.awardName = awardName;
        this.prize = prize;
        this.bonusAmount = bonusAmount;
    }

    @Override
    public String toString() {
        return super.toString() + ", Название награды: " + awardName + ", Премия: " + prize +
                ", Сумма надбавки: " + bonusAmount;
    }
}

public class MilitaryRegistry {
    private List<Military> militaryList;

    public MilitaryRegistry() {
        militaryList = new ArrayList<>();
    }

    // Метод для добавления нового военного
    public void addMilitary(Military military) {
        militaryList.add(military);
    }

    // Метод для печати списка военных
    public void printMilitaryList() {
        for (Military military : militaryList) {
            System.out.println(military);
        }
    }

    public static void main(String[] args) {
        // Создаем объект класса MilitaryRegistry
        MilitaryRegistry registry = new MilitaryRegistry();

        // Добавляем военных разных типов
        registry.addMilitary(new MilitaryAdministration("Иванов", "1-ая рота", "Рядовой",
                LocalDate.of(1990, 5, 15), LocalDate.of(2010, 8, 20), "101-я дивизия",
                "Западный округ", "Командир", 8, 500.0));

        registry.addMilitary(new MilitaryServiceContract("Петров", "2-ая рота", "Сержант",
                LocalDate.of(1985, 10, 10), LocalDate.of(2005, 6, 12), "102-я дивизия",
                "5 лет", LocalDate.of(2020, 7, 1), 12345, 2000.0));

        registry.addMilitary(new Awarded("Сидоров", "3-я рота", "Прапорщик",
                LocalDate.of(1988, 3, 25), LocalDate.of(2007, 4, 30), "103-я дивизия",
                "За отличие в бою", 1000.0, 300.0));

        // Выводим список военных
        registry.printMilitaryList();
    }
}