package refactor;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @Description
 * @Author ThomasChan
 * @Date 2018/12/9 11:15 PM
 * @Version 1.0
 */
public class Customer {
    private String name;
    private Vector _rentals = new Vector();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental){
        this._rentals.addElement(rental);
    }

    public String getName() {
        return name;
    }

    public String statement(){
        Enumeration<Rental> rentals = _rentals.elements();
        StringBuilder result = new StringBuilder("Rental Record for  " + getName() + "\n");
        while (rentals.hasMoreElements()){
            Rental aRental = rentals.nextElement();
            result.append("\t")
                    .append(aRental.getMovie().getTitle())
                    .append("\t")
                    .append(String.valueOf(aRental.getAmount()))
                    .append("\n");
        }
        result.append("Amount own is ").append(String.valueOf(getTotalAmount())).append("\n");
        result.append("You earned ").append(String.valueOf(getTotalPoints())).append(" frequent renter points");
        return result.toString();
    }


    private double getTotalAmount(){
        double totalAmount = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()){
            Rental aRental = (Rental) rentals.nextElement();
            totalAmount += aRental.getAmount();
        }
        return totalAmount;
    }

    private int getTotalPoints(){
        int frequentRenterPoints = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()){
            Rental aRental = (Rental) rentals.nextElement();
            frequentRenterPoints += aRental.getFrequentRenterPoints();
        }
        return frequentRenterPoints;
    }


}
