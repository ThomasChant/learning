import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import refactor.*;

/**
 * @Description
 * @Author ThomasChan
 * @Date 2018/12/9 11:36 PM
 * @Version 1.0
 */
public class CaculateTest {

    Movie m ;
    Movie m1 ;
    Movie m2 ;


    @Before
    public void setup(){

         m = new NewReleaseMovie("阿凡达", 1);
         m1 = new ChildMovie("齐天大圣", 2);
         m2 = new RegularMovie("情书", 0);
    }
    @Test
    public void test1(){
        {
            Customer c = new Customer("李四");
            Rental rental = new Rental(m, 3);
            Rental rental1 = new Rental(m1, 2);
            Rental rental2 = new Rental(m2, 10);
            c.addRental(rental);
            c.addRental(rental1);
            c.addRental(rental2);
            Assert.assertEquals("Rental Record for  李四\n" +
                    "\t阿凡达\t9.0\n" +
                    "\t齐天大圣\t1.5\n" +
                    "\t情书\t14.0\n" +
                    "Amount own is 24.5\n" +
                    "You earned 4 frequent renter points", c.statement());
        }
        {
            Customer c = new Customer("李四");
            Rental rental = new Rental(m, 1);
            Rental rental1 = new Rental(m1, 1);
            Rental rental2 = new Rental(m2, 1);
            c.addRental(rental);
            c.addRental(rental1);
            c.addRental(rental2);
            Assert.assertEquals("Rental Record for  李四\n" +
                    "\t阿凡达\t3.0\n" +
                    "\t齐天大圣\t1.5\n" +
                    "\t情书\t2.0\n" +
                    "Amount own is 6.5\n" +
                    "You earned 3 frequent renter points", c.statement());
        }

        {
            Customer c = new Customer("李四");
            Rental rental = new Rental(m, 2);
            Rental rental1 = new Rental(m1, 3);
            Rental rental2 = new Rental(m2, 2);
            c.addRental(rental);
            c.addRental(rental1);
            c.addRental(rental2);
            Assert.assertEquals("Rental Record for  李四\n" +
                    "\t阿凡达\t6.0\n" +
                    "\t齐天大圣\t1.5\n" +
                    "\t情书\t2.0\n" +
                    "Amount own is 9.5\n" +
                    "You earned 4 frequent renter points", c.statement());
        }

        {
            Customer c = new Customer("李四");
            Rental rental = new Rental(m, 10);
            Rental rental1 = new Rental(m1, 10);
            Rental rental2 = new Rental(m2, 10);
            c.addRental(rental);
            c.addRental(rental1);
            c.addRental(rental2);
            Assert.assertEquals("Rental Record for  李四\n" +
                    "\t阿凡达\t30.0\n" +
                    "\t齐天大圣\t12.0\n" +
                    "\t情书\t14.0\n" +
                    "Amount own is 56.0\n" +
                    "You earned 4 frequent renter points", c.statement());
        }
    }
}
