package by.pvorobey.libraryapplication.dao;

import by.pvorobey.libraryapplication.entity.Newspaper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewspaperRepository extends JpaRepository<Newspaper, Long> {
}
