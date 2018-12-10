package refactor;

/**
 * @Description
 * @Author ThomasChan
 * @Date 2018/12/10 9:46 AM
 * @Version 1.0
 */
public class ChildMovie extends Movie{
    public ChildMovie(String _title, int _priceCode) {
        super(_title, _priceCode);
    }
    public double getCharge(int daysRented) {
        double result = 1.5;
        if(daysRented > 3){
            result += (daysRented - 3) * 1.5;
        }
        return result;
    }
}
