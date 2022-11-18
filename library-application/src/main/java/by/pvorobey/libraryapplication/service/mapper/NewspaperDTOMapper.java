package by.pvorobey.libraryapplication.service.mapper;

import by.pvorobey.libraryapplication.dto.MagazineDTO;
import by.pvorobey.libraryapplication.dto.NewspaperDTO;
import by.pvorobey.libraryapplication.entity.Magazine;
import by.pvorobey.libraryapplication.entity.Newspaper;

import java.util.List;

public interface NewspaperDTOMapper {

    NewspaperDTO toNewspaperDTO(Newspaper newspaper);

    List<NewspaperDTO> toListNewspaperDTO(List<Newspaper> newspapers);
}
