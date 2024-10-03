package structures;
import java.util.Calendar;
import stores.*;
import structures.CustomArrayList;
/** The MoviesObj merely contains data on a movie which is either initialised, or set.
 *  The class only has setters and getters for each piece of data. It uses CustomArrayList to
 *  store productionCompanies and productionCountries.
 */
public class MoviesObj {
    //Variables which are initialised
    private String title;
    private String originalTitle;
    private String overview;
    private String tagline;
    private String status;
    private Genre[] genres;
    private Calendar release;
    private long budget;
    private long revenue;
    private String[] languages;
    private String originalLanguage;
    private double runtime;
    private String homepage;
    private boolean adult;
    private boolean video;
    private String poster;
    //Variables which must be set and are not initialised
    private double voteAverage;
    private int voteCount;
    private String imdbID;
    private double popularity;
    private CustomArrayList productionCompanies = new CustomArrayList<>();
    private CustomArrayList<String>  productionCountries = new CustomArrayList<>();
    private int collectionID;

    public MoviesObj(String title, String originalTitle, String overview, String tagline,
    String status, Genre[] genres, Calendar release, long budget, long revenue, String[] languages,
    String originalLanguage, double runtime, String homepage, boolean adult, boolean video,
    String poster) {
        this.title = title;
        this.originalTitle = originalTitle;
        this.overview = overview;
        this.tagline = tagline;
        this.status = status;
        this.genres = genres;

        this.release = release;
        this.budget = budget;
        this.revenue = revenue;
        this.languages = languages;
        this.originalLanguage = originalLanguage;
        this.runtime = runtime;
        this.homepage = homepage;
        this.adult = adult;
        this.video = video;
        this.poster = poster;
    }

    public String getTitle() {
        return title;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getOverview() {
        return overview;
    }

    public String getTagline() {
        return tagline;
    }

    public String getStatus() {
        return status;
    }

    public Genre[] getGenres() {
        return this.genres;
    }

    public Calendar getRelease() {
        return release;
    }

    public long getBudget() {
        return budget;
    }

    public long getRevenue() {
        return revenue;
    }

    public String[] getLanguages() {
        return languages;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public double getRuntime() {
        return runtime;
    }

    public String getHomepage() {
        return homepage;
    }

    public boolean isAdult() {
        return adult;
    }

    public boolean isVideo() {
        return video;
    }

    public String getPoster() {
        return poster;
    }

    public double getVoteAverage() {
        return voteAverage;
    }
    
    public int getVoteCount() {
        return voteCount;
    }
    
    public double getPopularity() {
        return popularity;
    }

    public void setVote(double voteAverage, int voteCount) {
        this.voteAverage = voteAverage;
        this.voteCount = voteCount;
    }

    public void setIMDB(String imdbID) {
        this.imdbID = imdbID;
    }
    public String getIMDB() {
        return imdbID;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }
    public double getPopularity(int id) {
        return popularity;
    }

    public void addProductionCompany(Company company) {
        this.productionCompanies.add(company);
    }

    public void addProductionCountry(String country) {
        this.productionCountries.add(country);
    }

    public Object[] getProductionCompanies() {
        return productionCompanies.toArray(); 
    }
    public Object[] getProductionCountries() {
        return productionCountries.toArray();
    }

    public void addToCollection(int collectionID) {
        this.collectionID = collectionID;
    }

    public int getCollectionID() {
        return collectionID;
    }
}
 
