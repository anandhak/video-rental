public class Movie {
  public static final int CHILDRENS = 2;
  public static final int REGULAR = 0;
  public static final int NEW_RELEASE = 1;

  private String _title;
  private Price price;

  public Movie(String title, int priceCode) {
    _title = title;
    price = new Price(priceCode);
  }

  public int getPriceCode() {
    return price.getPriceCode();
  }

  public void setPriceCode(int priceCode) {
    price = new Price(priceCode);
  }

  public String getTitle() {
    return _title;
  }

  double amountForMovie(int daysRented) {
    return price.amountForPrice(daysRented);
  }

}
