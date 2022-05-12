package com.kritika.demo.Repoistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kritika.demo.model.Book;

@Repository
public interface BookRepoistory extends JpaRepository<Book, Integer>
{
	
}
