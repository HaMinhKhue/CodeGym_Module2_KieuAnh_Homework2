import java.util.Date;

public class Meat extends Material {
    double unit=1;
    double weight=1;

    public Meat() {
        super();
    }

    public Meat(String name, String ID, Date date) {
        super(name, ID, date);
    }

    public Meat(String name, String ID, Date date, double unit, double weight) {
        super(name, ID, date);
        this.unit = unit;
        this.weight = weight;
    }

    public double getUnit() {
        return unit;
    }

    public void setUnit(double unit) {
        this.unit = unit;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public double getTotalPrice() {
        return this.cost*unit*weight;
    }
    @Override
    public long getExpirationTime(){
        return (long) (date.getTime()+Material.Fifteen_Days);
    }

    @Override
    public double getDiscountPercentage() {
        if(getExpirationTimeFormNow()<=Material.Three_Days)
            return (double)50/100;
        if (getExpirationTimeFormNow()>Material.Three_Days&&getExpirationTimeFormNow()<=Material.Fifteen_Days)
            return (double)30/100;
        return (double)10/100;
    }
}
