package lw01.unguided;

public class CarWash extends WashService {
    public CarWash(String id, int days) {
        super(id, days);
    }

    @Override
    public int calculateCharge() {
        int days = getDays();
        if (days <= 3) {
            return (35000 * days) + 15000;
        } else {
            return (35000 * 3) + (25000 * (days - 3));
        }
    }

    @Override
    public String label() {
        return "Car";
    }
    
}
