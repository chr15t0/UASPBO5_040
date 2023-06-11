package UAS;

public class NonFictionBooks extends Book {
    private String Type;
    private String Topic;
    public NonFictionBooks(String Title, String Author, String Publisher, int YearPublished,String Type, String Topic) {
        super(Title, Author, Publisher, YearPublished);
        this.Type = Type;
        this.Topic = Topic;
    }

    public String getType(){
        return Type;
    }
    public String getTopic(){
        return Topic;
    }
}
