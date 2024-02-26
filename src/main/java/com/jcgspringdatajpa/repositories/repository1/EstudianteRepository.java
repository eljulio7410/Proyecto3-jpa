package com.jcgspringdatajpa.repositories.repository1;

import com.jcgspringdatajpa.entities.entity1.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante,Long> {
}
