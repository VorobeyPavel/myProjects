package by.pvorobey.libraryapplication;

import by.pvorobey.libraryapplication.dao.BookRepository;
import by.pvorobey.libraryapplication.dao.MagazineRepository;
import by.pvorobey.libraryapplication.dao.NewspaperRepository;
import by.pvorobey.libraryapplication.dto.MagazineDTO;
import by.pvorobey.libraryapplication.dto.NewspaperDTO;
import by.pvorobey.libraryapplication.entity.Magazine;
import by.pvorobey.libraryapplication.entity.Newspaper;
import by.pvorobey.libraryapplication.exeptions.IdTypeProductNotFoundException;
import by.pvorobey.libraryapplication.service.LibraryService;
import by.pvorobey.libraryapplication.service.mapper.BookDTOMapper;
import by.pvorobey.libraryapplication.service.mapper.MagazineDTOMapper;
import by.pvorobey.libraryapplication.service.mapper.NewspaperDTOMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@SpringBootTest
class LibraryApplicationTests {

    @MockBean
    BookDTOMapper bookDTOMapper;
    @MockBean
    MagazineDTOMapper magazineDTOMapper;
    @MockBean
    NewspaperDTOMapper newspaperDTOMapper;

    @Autowired
    LibraryService libraryService;

    @MockBean
    BookRepository bookRepository;
    @MockBean
    MagazineRepository magazineRepository;
    @MockBean
    NewspaperRepository newspaperRepository;


    @Test
    void getIdTypeProductNotFoundException() {
        when(bookRepository.findById(5L)).thenThrow(IdTypeProductNotFoundException.class);

        assertThrows(IdTypeProductNotFoundException.class, ()-> libraryService.getBook(5L));
    }

    @Test
    void getAllEmployees(){
        Magazine employeeOne = new Magazine(7L,"Time","Kovaleva", LocalDate.now(), "Cassell");
        Magazine employeeTwo = new Magazine(4L,"People","Smirnova", LocalDate.now(), "Penguin Books");
        List<Magazine> employees = Arrays.asList(employeeOne,employeeTwo);
        List<MagazineDTO> employeesDTO = magazineDTOMapper.toListMagazineDTO(employees);

        when(magazineRepository.findAll()).thenReturn(employees);

        List<MagazineDTO> actual = libraryService.getAllMagazines();

        verify(magazineRepository, times(1)).findAll();

        assertEquals(employeesDTO,actual);
    }


    @Test
    void getEmployeeById() {

        Newspaper newspaper = new Newspaper(7L,"Daily News","Jensen Murphy", LocalDate.now(), "Cassell");
        NewspaperDTO newspaperDTO = new NewspaperDTO(4L,"The New York Times","Larry King", LocalDate.now(), "Penguin Books");

        when(newspaperRepository.findById(4L)).thenReturn(Optional.of(newspaper));
        when(newspaperDTOMapper.toNewspaperDTO(newspaper)).thenReturn(newspaperDTO);

        NewspaperDTO byId = libraryService.getNewspaper(4L);

        verify(newspaperRepository, times(1)).findById(4L);
        verify(newspaperDTOMapper, times(1)).toNewspaperDTO(newspaper);

        assertEquals(newspaperDTO, byId);
    }


}
