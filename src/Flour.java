import java.util.Date;

public class Flour extends Material {
    double quantity=1;

    public Flour(String name, String ID, Date date) {
        super(name, ID, date);
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    @Override
    public double getTotalPrice() {
        return quantity*cost;
    }
    public long getExpirationTime(){
        return (long) (date.getTime()+Material.One_Year);
    }

    @Override
    public double getDiscountPercentage() {
        if(getExpirationTimeFormNow()<=Material.Two_Months)
            return (double)40/100;
        if (getExpirationTimeFormNow()>Material.Two_Months&&getExpirationTimeFormNow()<=Material.Four_Months)
            return (double)20/100;
        return (double)5/100;
    }
}