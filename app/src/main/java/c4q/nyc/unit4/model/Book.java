package c4q.nyc.unit4.model;

/**
 * Created by c4q on 12/20/17.
 */

/**
 * POJO - data model for the Book class:
 */
public class Book {

    // fields:
    private String title;
    private String author;
    private int year;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
