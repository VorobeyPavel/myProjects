package by.pvorobey.libraryapplication.service.mapper.impl;


import by.pvorobey.libraryapplication.dto.MagazineDTO;
import by.pvorobey.libraryapplication.entity.Magazine;
import by.pvorobey.libraryapplication.service.mapper.MagazineDTOMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class MagazineDTOMapperImpl implements MagazineDTOMapper {

    @Override
    public MagazineDTO toMagazineDTO(Magazine magazine) {
        return MagazineDTO.builder()
                .id(magazine.getId())
                .name(magazine.getName())
                .author(magazine.getAuthor())
                .releaseDate(magazine.getReleaseDate())
                .publisher(magazine.getPublisher())
                .build();
    }

    @Override
    public List<MagazineDTO> toListMagazineDTO(List<Magazine> magazines) {
        return magazines.stream().map(this::toMagazineDTO).collect(Collectors.toList());
    }

}