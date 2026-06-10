package library.app.com.repository.model;


public class Book {

    private Long id;
    private String title;
    private String isbn;
    private Integer publicationYear;
    private Integer totalCopies;
    private Integer availableCopies;

    private Author author;
    private Category category;

    public Book() {
    }

    public Book(Long id, String title, String isbn,
                Integer publicationYear,
                Integer totalCopies,
                Integer availableCopies,
                Author author,
                Category category) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
        this.totalCopies = totalCopies;
        this.availableCopies = availableCopies;
        this.author = author;
        this.category = category;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getIsbn() { return isbn; }
    public Integer getPublicationYear() { return publicationYear; }
    public Integer getTotalCopies() { return totalCopies; }
    public Integer getAvailableCopies() { return availableCopies; }
    public Author getAuthor() { return author; }
    public Category getCategory() { return category; }

    public void setId(Long id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public void setPublicationYear(Integer publicationYear) { this.publicationYear = publicationYear; }
    public void setTotalCopies(Integer totalCopies) { this.totalCopies = totalCopies; }
    public void setAvailableCopies(Integer availableCopies) { this.availableCopies = availableCopies; }
    public void setAuthor(Author author) { this.author = author; }
    public void setCategory(Category category) { this.category = category; }
}