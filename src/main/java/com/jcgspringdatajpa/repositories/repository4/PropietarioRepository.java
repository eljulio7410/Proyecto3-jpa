package com.jcgspringdatajpa.repositories.repository4;

import com.jcgspringdatajpa.entities.entity4.Propietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropietarioRepository extends JpaRepository<Propietario,Long>{
}
