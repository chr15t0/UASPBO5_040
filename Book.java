package UAS;

public class Book {
    private String Title;
    private String Author;
    private String Publisher;
    private int YearPublished;

    public Book(String Title, String Author, String Publisher, int YearPublished) {
        this.Title = Title;
        this.Author = Author;
        this.Publisher = Publisher;
        this.YearPublished = YearPublished; 
    }
    public String getTitle() {
        return Title;
    }
    public String getAuthor() {
        return Author;
    }
    public String getPublisher(){
        return Publisher;
    }
    public int getYearPublished(){
        return YearPublished;
    }
    
}

