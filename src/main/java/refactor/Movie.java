package refactor;

/**
 * @Description
 * @Author ThomasChan
 * @Date 2018/12/9 11:08 PM
 * @Version 1.0
 */
public class Movie {

    private String _title;
    private int _priceCode;


    public Movie(String _title, int _priceCode) {
        this._title = _title;
        this._priceCode = _priceCode;
    }


    public String getTitle() {
        return _title;
    }

    public void setTitle(String _title) {
        this._title = _title;
    }

    public int getPriceCode() {
        return _priceCode;
    }

    public void setPriceCode(int _priceCode) {
        this._priceCode = _priceCode;
    }

    public  double getCharge(int daysRented){

        return 0;
    }

    public int getFrequentRenterPoints(int dayRented) {
       return 1;
    }
}
