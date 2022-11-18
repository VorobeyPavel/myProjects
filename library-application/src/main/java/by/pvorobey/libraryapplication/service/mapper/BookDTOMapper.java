package by.pvorobey.libraryapplication.service.mapper;

import by.pvorobey.libraryapplication.dto.BookDTO;
import by.pvorobey.libraryapplication.entity.Book;


import java.util.List;

public interface BookDTOMapper {

    BookDTO toBookDTO(Book book);

    List<BookDTO> toListBookDTO(List<Book> employees);

}
