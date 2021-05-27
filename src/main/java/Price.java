public abstract class Price {
  public static final int CHILDRENS = 2;
  public static final int REGULAR = 0;
  public static final int NEW_RELEASE = 1;
  private final int priceCode;

  public Price(int priceCode) {
    this.priceCode = priceCode;
  }

  public int getPriceCode() {
    return priceCode;
  }

  abstract double amountForPrice(int daysRented);
}

class RegularPrice extends Price {

  public RegularPrice(int priceCode) {
    super(priceCode);
  }

  double amountForPrice(int daysRented) {
    double amount = 0;
    amount += 2;
    if (daysRented > 2)
      amount += (daysRented - 2) * 1.5;
    return amount;
  }

}


class NewReleasePrice extends Price {

  public NewReleasePrice(int priceCode) {
    super(priceCode);
  }

  double amountForPrice(int daysRented) {
    return daysRented * 3;
  }

}


class ChildrensPrice extends Price {

  public ChildrensPrice(int priceCode) {
    super(priceCode);
  }

  double amountForPrice(int daysRented) {
    double amount = 1.5;
    if (daysRented > 3)
      amount += (daysRented - 3) * 1.5;
    return amount;
  }

}

