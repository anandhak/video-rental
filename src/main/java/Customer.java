import java.util.ArrayList;
import java.util.List;

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
    String header = header(getName());

    String body = "";
    double totalAmount = 0;
    for (Rental rental: moviesRented){
      double thisAmount = rental.amount();
      totalAmount += thisAmount;
      // show figures for this rental
      String title = rental.getMovie().getTitle();
      body += lineItem(thisAmount, title);
    }


    int frequentRenterPoints = calculateFrequentRenterPoints(this.moviesRented);

    // add footer lines
    String footer= footer(totalAmount, frequentRenterPoints);

    return header + body + footer;
  }

  private int calculateFrequentRenterPoints(List<Rental> moviesRented) {
    int frequentRenterPoints = 0;

    for (Rental rental: moviesRented){
      frequentRenterPoints++;
      // add bonus for a two day new release rental
      Movie movie = rental.getMovie();
      int priceCode = movie.getPriceCode();
      if (priceCode == Movie.NEW_RELEASE && rental.getDaysRented() > 1)
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
