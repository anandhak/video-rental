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
    StringBuilder body = new StringBuilder();
    double totalAmount = 0;
    for (Rental rental: moviesRented){
      totalAmount += rental.amount();
      body.append(lineItem(rental.amount(), rental.getMovie().getTitle()));
    }

    int frequentRenterPoints = calculateFrequentRenterPoints(this.moviesRented);

    String footer= footer(totalAmount, frequentRenterPoints);
    return header + body + footer;
  }

  private int calculateFrequentRenterPoints(List<Rental> moviesRented) {
    int totalFrequentRenterPoints = 0;
    for (Rental rental: moviesRented){
      totalFrequentRenterPoints += rental.frequentRenterPoints();
    }
    return totalFrequentRenterPoints;
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
