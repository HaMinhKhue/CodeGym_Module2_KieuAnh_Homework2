import java.util.Date;

public abstract class Material implements Discount{
    public static final double One_Year = 365.2425 * 86400 * 1000;
    public static final double Four_Months = Material.One_Year / 3;
    public static final double Two_Months = Material.Four_Months / 6;
    public static final double Fifteen_Days = 15 * 86400 * 1000;
    public static final double Five_Days = 5 * 86400 * 1000;
    public static final double Three_Days = Material.Five_Days / 5;

    String name;
    String ID;
    Date date;
    double cost=10;

    public Material() {
    }

    public Material(String name, String ID, Date date) {
        this.name = name;
        this.ID = ID;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public abstract double getTotalPrice();

    public Date getExpirationDate() {
        return new Date(getExpirationTime());
    }

    public abstract long getExpirationTime();

    public long getExpirationTimeFormNow() {
        return getExpirationTime() - new Date().getTime();
    }
    @Override
    public abstract double getDiscountPercentage();
    public double getReduction(){
        return getTotalPrice()*getDiscountPercentage();
    }
    public double getDiscountPrice(){
        return getTotalPrice()-getReduction();
    }
}
