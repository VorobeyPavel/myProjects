package by.pvorobey.libraryapplication.controller;

import by.pvorobey.libraryapplication.dto.BookDTO;
import by.pvorobey.libraryapplication.dto.MagazineDTO;
import by.pvorobey.libraryapplication.dto.NewspaperDTO;
import by.pvorobey.libraryapplication.entity.Book;
import by.pvorobey.libraryapplication.entity.Magazine;
import by.pvorobey.libraryapplication.entity.Newspaper;
import by.pvorobey.libraryapplication.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private LibraryService service;


    @GetMapping("/all/books")
    public List<BookDTO> getAllBooks(){
        return service.getAllBooks();
    }

    @GetMapping("/all/magazines")
    public List<MagazineDTO> getAllMagazines(){
        return service.getAllMagazines();
    }

    @GetMapping("/all/newspapers")
    public List<NewspaperDTO> getAllNewspapers(){
        return service.getAllNewspapers();
    }


    @GetMapping("/book/{id}")
    public BookDTO getBook( @PathVariable long id) {
        return service.getBook(id);
    }

    @GetMapping("/magazine/{id}")
    public MagazineDTO getMagazine( @PathVariable long id) {
        return service.getMagazine(id);
    }

    @GetMapping("/newspaper/{id}")
    public NewspaperDTO getNewspaper( @PathVariable long id) {
        return service.getNewspaper(id);
    }


    @PostMapping("/save/book")
    public Object addBook(@RequestBody Book book){
        service.saveBook(book);
        return book;
    }

    @PostMapping("/save/magazine")
    public Object addMagazine( @RequestBody Magazine magazine){
          service.saveMagazine(magazine);
          return magazine;
    }

    @PostMapping("/save/newspaper")
    public Object addNewspaper( @RequestBody Newspaper newspaper){
        service.saveNewspaper(newspaper);
        return newspaper;
    }



    @PutMapping("/save/book")
    public Book updateBook(@RequestBody Book book){
        service.saveBook(book);
        return book;
    }

    @PutMapping("/save/magazine")
    public Magazine updateMagazine(@RequestBody Magazine magazine){
        service.saveMagazine(magazine);
        return magazine;
    }

    @PutMapping("/save/newspaper")
    public Newspaper updateNewspaper(@RequestBody Newspaper newspaper){
        service.saveNewspaper(newspaper);
        return newspaper;
    }


    @DeleteMapping("/book/{id}")
    public void deleteBook( @PathVariable long id) {
        service.deleteBook(id);
    }

    @DeleteMapping("/magazines/{id}")
    public void deleteMagazine( @PathVariable long id) {
        service.deleteMagazine(id);
    }

    @DeleteMapping("/newspaper/{id}")
    public void deleteNewspaper( @PathVariable long id) {
        service.deleteNewspaper(id);
    }

}
