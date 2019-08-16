import java.util.Scanner;

/**
 *  Данная программа позволяет оценить экономическое состояние компании.
 *  В ходе выполнения кода производится расчёт чистого дохода компании с учетом затрат
 *  на сотрудников, налоги и коммунальные платежи, далее оценивается бюджет организации
 *  на возможность инвестиций.
 */
public class IncomeCalculator
{
    private static int minIncome = 200000;               // Минимальный доход компании
    private static int maxIncome = 900000;               // Максимальный доход компании

    private static int officeRentCharge = 140000;        // Плата за аренду офиса
    private static int telephonyCharge = 12000;          // Плата за телефон
    private static int internetAccessCharge = 7200;      // Плата за доступ в Интернет

    private static int assistantSalary = 45000;          // Зарплата ассистента
    private static int financeManagerSalary = 90000;     // Зарплата финансового менеджера

    private static double mainTaxPercent = 0.24;         // Процент основного налога
    private static double managerPercent = 0.15;         // Процент менеджера

    private static double minInvestmentsAmount = 100000; // Минимальный размер инвестиций

    public static void main(String[] args)
    {

        minIncome =   (int)((minInvestmentsAmount + calculateFixedCharges() * (1 - mainTaxPercent))/ ((1 - mainTaxPercent) * (1 - managerPercent)) + 1);
        System.out.println("Минимальный доход для инвестиций: " + minIncome);

        while(true)
        {
            System.out.println("Введите сумму доходов компании за месяц " +
                "(от 200 до 900 тысяч рублей): ");
            int income = (new Scanner(System.in)).nextInt();        // Получение данных о доходе компании

            if(!checkIncomeRange(income)) {                         // Проверка дохода в пределах границ
                continue;
            }

            double managerSalary = income * managerPercent;         // Расчёт зарплаты менеджера
            double pureIncome = income - managerSalary -            // Расчёт чистого дохода: из общего дохода вычитается зарплата
                calculateFixedCharges();                            // менеджера и фиксированные расходы
            double taxAmount = mainTaxPercent * pureIncome;         // Расчет налога: чистый доход умножается на процент основного налога
            double pureIncomeAfterTax = pureIncome - taxAmount;     // Расчёт чистого дохода после уплаты налога

            boolean canMakeInvestments = pureIncomeAfterTax >=      // Проверка на возможность инвестиций
                minInvestmentsAmount;

            System.out.println("Зарплата менеджера: " + managerSalary);
            System.out.println("Общая сумма налогов: " +
                (taxAmount > 0 ? taxAmount : 0));
            System.out.println("Компания может инвестировать: " +
                (canMakeInvestments ? "да" : "нет"));
            if(pureIncome < 0) {
                System.out.println("Бюджет в минусе! Нужно срочно зарабатывать!");
            }
        }
    }

    private static boolean checkIncomeRange(int income)             // Проверка дохода в пределах границ
    {
        if(income < minIncome)
        {
            System.out.println("Доход меньше нижней границы");
            return false;
        }
        if(income > maxIncome)
        {
            System.out.println("Доход выше верхней границы");
            return false;
        }
        return true;
    }

    private static int calculateFixedCharges()                   // Расчёт фиксированных расходов
    {
        return officeRentCharge +
                telephonyCharge +
                internetAccessCharge +
                assistantSalary +
                financeManagerSalary;
    }
}
