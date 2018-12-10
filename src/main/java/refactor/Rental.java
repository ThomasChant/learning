package refactor;

/**
 * @Description
 * @Author ThomasChan
 * @Date 2018/12/9 11:14 PM
 * @Version 1.0
 */
public class Rental {

    private Movie _movie;
    private int _daysRented;

    public Rental(Movie _movie, int _daysRented) {
        this._movie = _movie;
        this._daysRented = _daysRented;
    }

    public Movie getMovie() {
        return _movie;
    }

    public void setMovie(Movie _movie) {
        this._movie = _movie;
    }

    public int getDaysRented() {
        return _daysRented;
    }

    public void setDaysRented(int _daysRented) {
        this._daysRented = _daysRented;
    }

    public double getAmount() {
        return getMovie().getCharge(getDaysRented());
    }


    public int getFrequentRenterPoints(){
        return getMovie().getFrequentRenterPoints(getDaysRented());
    }
}
