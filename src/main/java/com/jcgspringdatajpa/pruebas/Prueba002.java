package com.jcgspringdatajpa.pruebas;

import com.jcgspringdatajpa.entities.entity2.Autor;
import com.jcgspringdatajpa.entities.entity2.Libro;
import com.jcgspringdatajpa.repositories.repository2.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class Prueba002 implements CommandLineRunner {

    @Autowired
    private AutorRepository autorRepository;
    @Override
    public void run(String... args) throws Exception {
        // creamos el autor
        Autor autor = new Autor();
        autor.setNombre("Nombre 01");

        // crear libros y agregarlos al autor
        Libro libro1 = new Libro();
        libro1.setTitulo("Libro 01");

        Libro libro2 = new Libro();
        libro1.setTitulo("Libro 02");

        autor.getLibros().add(libro1);
        autor.getLibros().add(libro2);

        autorRepository.save(autor);

        Optional<Autor> autoGuardado = autorRepository.findById(autor.getId());
        autoGuardado.ifPresent(a -> {
            System.out.println("Autor leido por ID : " + a.getNombre());

            a.setNombre("Nuevo nombre del autor");
            autorRepository.save(a);
            System.out.println("autor actualizado : " + a.getNombre());
        });

        List<Autor> autores = autorRepository.findAll();
        System.out.println("Lista de autores : ");
        for (Autor a:autores){
            System.out.println("-" + a.getNombre());
        }
        autorRepository.delete(autor);
        System.out.println("Autor eliminado");
    }
}
