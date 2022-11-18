package by.pvorobey.libraryapplication.service;

import by.pvorobey.libraryapplication.dto.BookDTO;
import by.pvorobey.libraryapplication.dto.MagazineDTO;
import by.pvorobey.libraryapplication.dto.NewspaperDTO;
import by.pvorobey.libraryapplication.entity.Book;
import by.pvorobey.libraryapplication.entity.Magazine;
import by.pvorobey.libraryapplication.entity.Newspaper;

import java.util.List;

public interface LibraryService {

    List<MagazineDTO> getAllMagazines();

    List<BookDTO> getAllBooks();

    List<NewspaperDTO> getAllNewspapers();


    BookDTO getBook(long id);

    MagazineDTO getMagazine(long id);

    NewspaperDTO getNewspaper(long id);


    void saveBook(Book book);

    void saveMagazine(Magazine object);

    void saveNewspaper(Newspaper newspaper);


    void deleteBook(long id);

    void deleteMagazine(long id);

    void deleteNewspaper(long id);
}
