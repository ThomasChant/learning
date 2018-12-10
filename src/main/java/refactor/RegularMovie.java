package refactor;

/**
 * @Description
 * @Author ThomasChan
 * @Date 2018/12/10 9:46 AM
 * @Version 1.0
 */
public class RegularMovie extends Movie{
    public RegularMovie(String _title, int _priceCode) {
        super(_title, _priceCode);
    }
    public double getCharge(int daysRented) {
        double result = 2;
        if(daysRented > 2){
            result += (daysRented - 2) * 1.5;
        }
        return result;
    }
}
