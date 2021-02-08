import com.kodilla.good.patterns.challenges.MovieStore;

import java.util.stream.Collectors;

public class GoodPatternsMain {

    public static void main(String[] args) {

        MovieStore movieStore = new MovieStore();

        String listToPrint = movieStore.getMovies().entrySet().stream()
                .flatMap(entry -> entry.getValue().stream())
                .collect(Collectors.joining("!"));

        System.out.println(listToPrint);
    }
}


