import java.io.Serializable;
public class Movie implements Serializable {
    private final String title;
    private final String director;
    private final String[] actors;

    public Movie(String title, String director, String[] actors){
        this.title = title;
        this.director = director;
        this.actors = actors;
    }

    @Override
    public String toString() {
        StringBuilder acts = new StringBuilder();
        for (String actor : actors){
            acts.append(actor).append(", ");
        }
        return "Title: " + title + "\n"+
                "Director: " + director + "\n" +
                "Actors: " + acts.substring(0, acts.length() - 2);
    }
}
