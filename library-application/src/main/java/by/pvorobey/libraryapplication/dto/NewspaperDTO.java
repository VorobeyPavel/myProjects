package by.pvorobey.libraryapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NewspaperDTO {

    private Long id;
    private String name;
    private String author;
    private LocalDate releaseDate;
    private String publisher;

    public NewspaperDTO(String name, String author, LocalDate releaseDate, String publisher) {
        this.name = name;
        this.author = author;
        this.releaseDate = releaseDate;
        this.publisher = publisher;
    }
}