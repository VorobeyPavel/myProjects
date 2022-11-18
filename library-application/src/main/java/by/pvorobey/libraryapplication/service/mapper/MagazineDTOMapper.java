package by.pvorobey.libraryapplication.service.mapper;

import by.pvorobey.libraryapplication.dto.MagazineDTO;
import by.pvorobey.libraryapplication.entity.Magazine;

import java.util.List;

public interface MagazineDTOMapper {

    MagazineDTO toMagazineDTO(Magazine magazine);

    List<MagazineDTO> toListMagazineDTO(List<Magazine> magazines);

}
