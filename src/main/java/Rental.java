class Rental {
  private Movie _movie;
  private int _daysRented;

  public Rental(Movie movie, int daysRented) {
    _movie = movie;
    _daysRented = daysRented;
  }

  public int getDaysRented() {
    return _daysRented;
  }

  public Movie getMovie() {
    return _movie;
  }

  double amount() {
    Movie movie = getMovie();
    int daysRented = getDaysRented();
    return movie.amountForMovie(daysRented);
  }

  int frequentRenterPoints() {
    return getPrice().frequentRenterPoints(getDaysRented());
  }

  private Price getPrice() {
    return getMovie().getPrice();
  }

}
