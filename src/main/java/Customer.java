import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

public class Customer {
  private String _name;
  private List<Rental> moviesRented = new ArrayList<>();

  public Customer(String name) {
    this._name = name;
  }

  public void addRental(Rental rental) {
    moviesRented.add(rental);
  }

  public String getName() {
    return _name;
  }

  public String statement() {
    double totalAmount = 0;
    String name = getName();
    String header = header(name);

    String body = "";
    for (Rental rental: moviesRented){
      double thisAmount = 0;

      // determines the amount for each line
      switch (rental.getMovie().getPriceCode()) {
        case Movie.REGULAR:
          thisAmount += 2;
          if (rental.getDaysRented() > 2)
            thisAmount += (rental.getDaysRented() - 2) * 1.5;
          break;
        case Movie.NEW_RELEASE:
          thisAmount += rental.getDaysRented() * 3;
          break;
        case Movie.CHILDRENS:
          thisAmount += 1.5;
          if (rental.getDaysRented() > 3)
            thisAmount += (rental.getDaysRented() - 3) * 1.5;
          break;
      }
      totalAmount += thisAmount;
      // show figures for this rental
      String title = rental.getMovie().getTitle();
      body += lineItem(thisAmount, title);
    }


    List<Rental> moviesRented = this.moviesRented;

    int frequentRenterPoints = calculateFrequentRenterPoints(moviesRented);

    // add footer lines
    String footer= footer(totalAmount, frequentRenterPoints);

    return header + body + footer;
  }

  private int calculateFrequentRenterPoints(List<Rental> moviesRented) {
    int frequentRenterPoints = 0;

    for (Rental rental: moviesRented){
      // add frequent renter points
      frequentRenterPoints++;
      // add bonus for a two day new release rental
      if (rental.getMovie().getPriceCode() == Movie.NEW_RELEASE && rental.getDaysRented() > 1)
        frequentRenterPoints++;
    }
    return frequentRenterPoints;
  }

  private String lineItem(double amount, String title) {
    return "\t" + title + "\t" + amount + "\n";
  }

  private String header(String name) {
    return "Rental Record for " + name + "\n";
  }

  private String footer(double totalAmount, int frequentRenterPoints) {
    String footer1 = "You owed " + totalAmount + "\n";
    String footer2 = "You earned " + frequentRenterPoints + " frequent renter points";
    return footer1 + footer2;
  }

}
