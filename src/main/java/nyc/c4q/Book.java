package nyc.c4q;

/**
 * Created by Ramona Harrison
 * on 9/1/15.
 */
public class Book {
    public String book;
    public String ID;
    public String title;
    public String author;
    public String isbn;
    public String isbn13;
    public String publisher;
    public String publishyear;
    public String checkedout;
    public String checkedoutby;
    public String checkoutdateyear;
    public String checkoutdatemonth;
    public String checkoutdateday;
    public String duedateyear;
    public String duedatemonth;
    public String duedateday;

    public Book(String book, String ID, String title, String author, String isbn, String isbn13, String publisher, String publishyear, String checkedout, String checkedoutby, String checkoutdateyear, String checkoutdatemonth, String checkoutdateday, String duedateyear, String duedatemonth, String duedateday) {
        this.book = book;
        this.ID = ID;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isbn13 = isbn13;
        this.publisher = publisher;
        this.publishyear = publishyear;
        this.checkedout = checkedout;
        this.checkedoutby = checkedoutby;
        this.checkoutdateyear = checkoutdateyear;
        this.checkoutdatemonth = checkoutdatemonth;
        this.checkoutdateday = checkoutdateday;
        this.duedateyear = duedateyear;
        this.duedatemonth = duedatemonth;
        this.duedateday = duedateday;
    }

    public Book() {

    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublishyear() {
        return publishyear;
    }

    public void setPublishyear(String publishyear) {
        this.publishyear = publishyear;
    }

    public String getCheckedout() {
        return checkedout;
    }

    public void setCheckedout(String checkedout) {
        this.checkedout = checkedout;
    }

    public String getCheckedoutby() {
        return checkedoutby;
    }

    public void setCheckedoutby(String checkedoutby) {
        this.checkedoutby = checkedoutby;
    }

    public String getCheckoutdateyear() {
        return checkoutdateyear;
    }

    public void setCheckoutdateyear(String checkoutdateyear) {
        this.checkoutdateyear = checkoutdateyear;
    }

    public String getCheckoutdatemonth() {
        return checkoutdatemonth;
    }

    public void setCheckoutdatemonth(String checkoutdatemonth) {
        this.checkoutdatemonth = checkoutdatemonth;
    }

    public String getCheckoutdateday() {
        return checkoutdateday;
    }

    public void setCheckoutdateday(String checkoutdateday) {
        this.checkoutdateday = checkoutdateday;
    }

    public String getDuedateyear() {
        return duedateyear;
    }

    public void setDuedateyear(String duedateyear) {
        this.duedateyear = duedateyear;
    }

    public String getDuedatemonth() {
        return duedatemonth;
    }

    public void setDuedatemonth(String duedatemonth) {
        this.duedatemonth = duedatemonth;
    }

    public String getDuedateday() {
        return duedateday;
    }

    public void setDuedateday(String duedateday) {
        this.duedateday = duedateday;
    }
}
