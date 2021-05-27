import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

  @Test
  public void test() {
    Customer customer = new Customer("Bob");

    customer.addRental(new Rental(new Movie("Jaws", new RegularPrice()), 2));
    customer.addRental(new Rental(new Movie("GoldenEye", new RegularPrice()), 3));
    customer.addRental(new Rental(new Movie("ShortNew", new NewReleasePrice()), 1));
    customer.addRental(new Rental(new Movie("LongNew", new NewReleasePrice()), 2));
    customer.addRental(new Rental(new Movie("Bambi", new ChildrensPrice()), 3));
    customer.addRental(new Rental(new Movie("Toy Story", new ChildrensPrice()), 4));

    assertEquals("Rental Record for Bob\n" +
      "\tJaws\t2.0\n" +
      "\tGoldenEye\t3.5\n" +
      "\tShortNew\t3.0\n" +
      "\tLongNew\t6.0\n" +
      "\tBambi\t1.5\n" +
      "\tToy Story\t3.0\n" +
      "You owed 19.0\n" +
      "You earned 7 frequent renter points", customer.statement());
  }
}
