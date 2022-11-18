package by.pvorobey.libraryapplication.service;

import by.pvorobey.libraryapplication.dao.BookRepository;
import by.pvorobey.libraryapplication.dao.MagazineRepository;
import by.pvorobey.libraryapplication.dao.NewspaperRepository;
import by.pvorobey.libraryapplication.dto.BookDTO;
import by.pvorobey.libraryapplication.dto.MagazineDTO;
import by.pvorobey.libraryapplication.dto.NewspaperDTO;
import by.pvorobey.libraryapplication.entity.Book;
import by.pvorobey.libraryapplication.entity.Magazine;
import by.pvorobey.libraryapplication.entity.Newspaper;
import by.pvorobey.libraryapplication.exeptions.IdTypeProductNotFoundException;
import by.pvorobey.libraryapplication.service.mapper.BookDTOMapper;
import by.pvorobey.libraryapplication.service.mapper.MagazineDTOMapper;
import by.pvorobey.libraryapplication.service.mapper.NewspaperDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private MagazineRepository magazineRepository;
    @Autowired
    private NewspaperRepository newspaperRepository;

    @Autowired
    private BookDTOMapper bookDTOMapper;
    @Autowired
    private MagazineDTOMapper magazineDTOMapper;
    @Autowired
    private NewspaperDTOMapper newspaperDTOMapper;


    @Override
    public List<BookDTO> getAllBooks() {
        List<Book> bookList = bookRepository.findAll();
        return bookDTOMapper.toListBookDTO((bookList));
    }

    @Override
    public List<MagazineDTO> getAllMagazines() {
        List<Magazine> magazineList = magazineRepository.findAll();
        return magazineDTOMapper.toListMagazineDTO((magazineList));
    }

    @Override
    public List<NewspaperDTO> getAllNewspapers() {
        List<Newspaper> newspaperList = newspaperRepository.findAll();
        return newspaperDTOMapper.toListNewspaperDTO((newspaperList));
    }


    @Override
    public BookDTO getBook(long id) {
        Book book = bookRepository.findById(id).orElseThrow(() ->
                new IdTypeProductNotFoundException("Book with id = " + id + " not found!"));
        return bookDTOMapper.toBookDTO(book);
    }

    @Override
    public MagazineDTO getMagazine(long id) {
        Magazine magazine = magazineRepository.findById(id).orElseThrow(() ->
                new IdTypeProductNotFoundException("Magazine with id = " + id + " not found!"));
        return magazineDTOMapper.toMagazineDTO(magazine);
    }

    @Override
    public NewspaperDTO getNewspaper(long id) {
        Newspaper newspaper = newspaperRepository.findById(id).orElseThrow(() ->
                new IdTypeProductNotFoundException("Newspaper with id = " + id + " not found!"));
        return newspaperDTOMapper.toNewspaperDTO(newspaper);
    }


    @Override
    public void saveBook(Book book) {
        if (book.getId()!=null){
            newspaperRepository.findById(book.getId()).orElseThrow(()->
                    new IdTypeProductNotFoundException("Book with id = " + book.getId() + " not found!"));
        }
        bookRepository.save(book);
    }

    @Override
    public void saveMagazine(Magazine magazine) {
        if (magazine.getId()!=null){
            newspaperRepository.findById(magazine.getId()).orElseThrow(()->
                    new IdTypeProductNotFoundException("Book with id = " + magazine.getId() + " not found!"));
        }
        magazineRepository.save(magazine);
    }

    @Override
    public void saveNewspaper(Newspaper newspaper) {
        if (newspaper.getId()!=null){
            newspaperRepository.findById(newspaper.getId()).orElseThrow(()->
            new IdTypeProductNotFoundException("Book with id = " + newspaper.getId() + " not found!"));
        }
        newspaperRepository.save(newspaper);
    }


    @Override
    public void deleteBook(long id) {
        bookRepository.findById(id).orElseThrow(() ->
                new IdTypeProductNotFoundException("Book with id = " + id + " not found!"));
        bookRepository.deleteById(id);
    }

    @Override
    public void deleteMagazine(long id) {
        magazineRepository.findById(id).orElseThrow(() ->
                new IdTypeProductNotFoundException("Magazine with id = " + id + " not found!"));
        magazineRepository.deleteById(id);
    }

    @Override
    public void deleteNewspaper(long id) {
        newspaperRepository.findById(id).orElseThrow(() ->
                new IdTypeProductNotFoundException("Newspaper with id = " + id + " not found!"));
        newspaperRepository.deleteById(id);
    }



    /*public JpaRepository getRepository(String type){

        JpaRepository repository = switch (type) {
            case "book" -> bookRepository;
            case "magazine" -> magazineRepository;
            case "newspaper" -> newspaperRepository;
            default -> throw new InvalidTypeProductException("invalid parameter \"type\"");
        };
        return  repository;
    }*/


}
