package com.jcgspringdatajpa.repositories.repository2;

import com.jcgspringdatajpa.entities.entity2.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository  extends JpaRepository<Autor,Long> {
}
