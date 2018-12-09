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
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration<Rental> rentals = _rentals.elements();
        String result = "Rental Record for  " + getName() + "\n";
        while (rentals.hasMoreElements()){
            double thisAmount = 0;
            Rental each = (Rental)rentals.nextElement();
            switch (each.getMovie().getPriceCode()){
                 case Movie.CHILDREN:
                    thisAmount += 1.5;
                    if(each.getDaysRented() > 3){
                        thisAmount += (each.getDaysRented() - 3) * 1.5;
                    }
                    break;
                 case Movie.NEW_RELEASE:
                        thisAmount +=each.getDaysRented() * 3;
                        break;
                 case Movie.REGULAR:
                            thisAmount += 2;
                            if(each.getDaysRented() > 2){
                                thisAmount += (each.getDaysRented() - 2) * 1.5;
                            }
                 break;

            }
            frequentRenterPoints++;
            if(each.getMovie().getPriceCode() == Movie.NEW_RELEASE && each.getDaysRented() > 1)
                frequentRenterPoints ++;
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }
        result += "Amount own is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;

    }

    public static void main(String[] args) {
        Customer c = new Customer("李四");
        Movie m = new Movie("阿凡达", 1);
        Movie m1 = new Movie("齐天大圣", 2);
        Movie m2 = new Movie("情书", 0);
        Rental rental = new Rental(m, 1);
        Rental rental1 = new Rental(m1, 1);
        Rental rental2 = new Rental(m2, 1);
        c.addRental(rental);
        c.addRental(rental1);
        c.addRental(rental2);
        System.out.println(c.statement());
    }
}
