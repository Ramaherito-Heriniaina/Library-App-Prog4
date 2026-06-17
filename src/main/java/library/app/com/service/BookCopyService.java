package library.app.com.service;


import library.app.com.repository.model.BookCopy;
import library.app.com.repository.BookCopyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookCopyService {

    private final BookCopyRepository repository;

    public BookCopyService(BookCopyRepository repository) {this.repository = repository;}

    public List<BookCopy> getAllBookCopies() {return repository.findAll();}

    public void deleteBookCopy(String id) {repository.deleteById(Long.valueOf(id));}
}