package composite_pattern.file_system.solution;

public class Main {

    public static void main(String args[]) {
        Directory movieDirectory = new Directory("Movie");

        FileSystem border = new File("Border.mp4");
        movieDirectory.add(border);

        Directory comedyMovieDirectory = new Directory("ComedyMovie");
        File hulchul = new File("Hulchul.mp4");
        comedyMovieDirectory.add(hulchul);
        movieDirectory.add(comedyMovieDirectory);

        movieDirectory.ls();

    }

    /*
    Movie -> Border.mp4
             ComedyMovie -> Hulchul.mp4
     */
}
