package com.api.book.bootrestbook.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entities.Book;

@Component
public class BookService {
    
    @Autowired
    private BookRepository bookRepo;
    // private static List<Book> list = new ArrayList<>();
    // static{
    //     list.add(new Book(12,"Java Reference","xyz"));
    //     list.add(new Book(36,"Head First Java","abc"));
    //     list.add(new Book(50,"Think in java","lmn"));
    // }

    // get all books
    public List<Book> getAllBooks()
    {
        List<Book> list = (List<Book>)this.bookRepo.findAll();
        return list;
    }

    // get single book by id
    public Book getBookByID(int id)
    {
        Book book=null;
        try
        {
            // book=list.stream().filter(e->e.getId()==id).findFirst().get();
            book = this.bookRepo.findById(id);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return book;
    }

    public Book addBook(Book b)
    {
        @SuppressWarnings("null")
        Book result = bookRepo.save(b);
        return result;
    }

    // delete book
    public void deletBook(int bid)
    {
        // list.stream().filter(book->{
        //     if(book.getId() != bid)
        //     {
        //         return true;
        //     }
        //     else
        //         return false;
        // }).collect(Collectors.toList());

        bookRepo.deleteById(bid);
    }

    public void updateBook(Book book,int bookId)
    {
        // list = list.stream().map(b->{
        //     if(b.getId() == bookId)
        //     {
        //         b.setTitle(book.getTitle());
        //         b.setAuthor(book.getAuthor());
        //     }
        //     return b;
        // }).collect(Collectors.toList());

        book.setId(bookId);
        bookRepo.save(book);

    }


}
