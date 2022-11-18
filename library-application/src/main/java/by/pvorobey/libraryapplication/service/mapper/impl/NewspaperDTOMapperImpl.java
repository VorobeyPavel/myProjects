package by.pvorobey.libraryapplication.service.mapper.impl;

import by.pvorobey.libraryapplication.dto.NewspaperDTO;
import by.pvorobey.libraryapplication.entity.Newspaper;
import by.pvorobey.libraryapplication.service.mapper.NewspaperDTOMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class NewspaperDTOMapperImpl implements NewspaperDTOMapper {

    @Override
    public NewspaperDTO toNewspaperDTO(Newspaper newspaper) {
        return NewspaperDTO.builder()
                .id(newspaper.getId())
                .name(newspaper.getName())
                .author(newspaper.getAuthor())
                .releaseDate(newspaper.getReleaseDate())
                .publisher(newspaper.getPublisher())
                .build();
    }

    @Override
    public List<NewspaperDTO> toListNewspaperDTO(List<Newspaper> newspaper) {
        return newspaper.stream().map(this::toNewspaperDTO).collect(Collectors.toList());
    }

}
