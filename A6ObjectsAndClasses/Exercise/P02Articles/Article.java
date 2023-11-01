package A6ObjectsAndClasses.Exercise.P02Articles;

public class Article {

    private String title;

    private String content;

    private String author;

    public Article(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void editContent(String newContent) {
        setContent(newContent);
    }

    public void changeAuthor(String newAuthor) {
        setAuthor(newAuthor);
    }

    public void rename(String newTitle) {
        setTitle(newTitle);
    }

    @Override
    public String toString() {
        return this.title + " " + "-" + " " + this.content + ":" + " " + this.author;
    }
}
