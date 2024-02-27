package com.jcgspringdatajpa.repositories.repository3;


import com.jcgspringdatajpa.entities.entity3.Editor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditorRepository extends JpaRepository<Editor,Long> {
}
