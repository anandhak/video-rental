public abstract class Price {
  public static final int SINGLE_POINT = 1;

  abstract double amountForPrice(int daysRented);

  int frequentRenterPoints(int daysRented) {
    return SINGLE_POINT;
  }
}

class RegularPrice extends Price {
  double amountForPrice(int daysRented) {
    double amount = 0;
    amount += 2;
    if (daysRented > 2)
      amount += (daysRented - 2) * 1.5;
    return amount;
  }

}


class NewReleasePrice extends Price {
  double amountForPrice(int daysRented) {
    return daysRented * 3;
  }

  int frequentRenterPoints(int daysRented) {
    int frequentRenterPoints = 1;
    if (daysRented > 1) {
      frequentRenterPoints = 2;
    }
    return frequentRenterPoints;
  }
}


class ChildrensPrice extends Price {
  double amountForPrice(int daysRented) {
    double amount = 1.5;
    if (daysRented > 3)
      amount += (daysRented - 3) * 1.5;
    return amount;
  }
}

