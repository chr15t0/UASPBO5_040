package UAS;

public class FictionBook extends Book{
    private String Type;
    private String Genre;
    public FictionBook(String Title, String Author, String Publisher, int YearPublished, String Type, String Genre){
        super(Title, Author, Publisher, YearPublished);
        this.Type = Type;
        this.Genre = Genre;
    }
    public String getType(){
        return Type;
    }
    public String getGenre(){
        return Genre;
    }
}
