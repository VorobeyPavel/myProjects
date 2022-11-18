package by.pvorobey.libraryapplication.service.mapper.impl;

import by.pvorobey.libraryapplication.dto.BookDTO;
import by.pvorobey.libraryapplication.entity.Book;
import by.pvorobey.libraryapplication.service.mapper.BookDTOMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class BookDTOMapperImpl implements BookDTOMapper {

    @Override
    public BookDTO toBookDTO(Book book) {
        return BookDTO.builder()
                .id(book.getId())
                .name(book.getName())
                .author(book.getAuthor())
                .releaseDate(book.getReleaseDate())
                .publisher(book.getPublisher())
                .build();
    }

    @Override
    public List<BookDTO> toListBookDTO(List<Book> employees) {
        return employees.stream().map(this::toBookDTO).collect(Collectors.toList());
    }

}
