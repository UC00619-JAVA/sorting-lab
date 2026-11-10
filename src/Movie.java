// Comparable: the movie's natural order is by title (A to Z)
public record Movie(String title, String genre, int year, double rating, int minutes)
    implements Comparable<Movie> {

  @Override
  public int compareTo(Movie other) {
    return this.title.compareTo(other.title);
  }
}
