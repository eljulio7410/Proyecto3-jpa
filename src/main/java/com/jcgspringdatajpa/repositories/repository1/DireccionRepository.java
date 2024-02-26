package com.jcgspringdatajpa.repositories.repository1;

import com.jcgspringdatajpa.entities.entity1.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DireccionRepository extends JpaRepository<Direccion,Long> {
}
