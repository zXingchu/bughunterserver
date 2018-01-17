package bughunter.bughunterserver.model.repository;

import bughunter.bughunterserver.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {


}
