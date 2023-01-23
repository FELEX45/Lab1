package by.might;

public class BankOperation {

    public enum TypeOperation{
        ADD,
        REMOVE
    }

    public final int date_day;
    public final int date_month;
    public final int date_year;

    public final int time_hour;
    public final int time_min;
    public final int time_second;

    public final String type;
    public final String account;

    private double amount;
    public final String description;

    public BankOperation(int date_day, int date_month, int date_year, int time_hour, int time_min, int time_second, String type, String account, double amount, String description) {
        this.date_day =     Math.abs(date_day);
        this.date_month =   Math.abs(date_month);
        this.date_year =    Math.abs(date_year);
        this.time_hour =    Math.abs(time_hour);
        this.time_min =     Math.abs(time_min);
        this.time_second =  Math.abs(time_second);

        this.type = TypeOperation.valueOf(type).name();
        this.account = account;
        this.amount = amount;
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "by.might.BankOperation{" +
                "date_day=" + date_day +
                ", date_month=" + date_month +
                ", date_year=" + date_year +
                ", time_hour=" + time_hour +
                ", time_min=" + time_min +
                ", time_second=" + time_second +
                ", type='" + type + '\'' +
                ", account='" + account + '\'' +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                '}';
    }
}
