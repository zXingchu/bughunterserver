package bughunter.bughunterserver.service.impl;

import bughunter.bughunterserver.model.repository.BookRepository;
import bughunter.bughunterserver.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService{


    @Autowired
    BookRepository bookRepository;


}
