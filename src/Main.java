void main() {

    List<Movie> movies = MovieData.load();

    // 1. natural order (Comparable -> compareTo by title)
    Collections.sort(movies);
    print("By title", movies);

    // 2. rating, highest first
    movies.sort(Comparator.comparing(Movie::rating).reversed());
    print("By rating (desc)", movies);

    // 3. year, and title when the year is the same
    movies.sort(Comparator.comparing(Movie::year).thenComparing(Movie::title));
    print("By year, then title", movies);

    // 4. genre (A-Z), and inside each genre the best rating first
    movies.sort(Comparator.comparing(Movie::genre)
            .thenComparing(Movie::rating, Comparator.reverseOrder()));
    print("By genre, then rating (desc)", movies);

    // Extra: a Comparator written as a lambda - shortest movie first
    movies.sort((a, b) -> Integer.compare(a.minutes(), b.minutes()));
    print("Extra - by minutes", movies);
}

static void print(String header, List<Movie> movies) {
    List<String> titles = new ArrayList<>();
    for (Movie movie : movies) {
        titles.add(movie.title());
    }
    IO.println(header + ": " + titles);
}
