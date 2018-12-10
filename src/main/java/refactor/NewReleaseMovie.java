package refactor;

/**
 * @Description
 * @Author ThomasChan
 * @Date 2018/12/10 9:46 AM
 * @Version 1.0
 */
public class NewReleaseMovie extends Movie{
    public NewReleaseMovie(String _title, int _priceCode) {
        super(_title, _priceCode);
    }
    public double getCharge(int daysRented) {
        return daysRented * 3;
    }

    public int getFrequentRenterPoints(int dayRented) {
        return dayRented > 1 ? 2 : 1;
    }
}
