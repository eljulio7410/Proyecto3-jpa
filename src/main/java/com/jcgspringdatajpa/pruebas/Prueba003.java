package com.jcgspringdatajpa.pruebas;

import com.jcgspringdatajpa.entities.entity3.Editor;
import com.jcgspringdatajpa.entities.entity3.Revista;
import com.jcgspringdatajpa.repositories.repository3.EditorRepository;
import com.jcgspringdatajpa.repositories.repository3.RevistaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

//@Component
public class Prueba003 implements CommandLineRunner {


    private final EditorRepository editorRepository;


    private final RevistaRepository revistaRepository;

    public Prueba003(EditorRepository editorRepository, RevistaRepository revistaRepository) {
        this.editorRepository = editorRepository;
        this.revistaRepository = revistaRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Editor editor = new Editor();
        editor.setNombre("editorial xyz");

        Revista revista1 = new Revista();
        revista1.setNombre("Revista A");
        revista1.setEditor(editor);

        Revista revista2 = new Revista();
        revista2.setNombre("Revista B");
        revista2.setEditor(editor);

        editor.getRevistas().add(revista1);
        editor.getRevistas().add(revista2);

        editorRepository.save(editor);

        Optional<Editor> editorGuardado = editorRepository.findById(editor.getId());
        if (editorGuardado.isPresent()){
            Editor editorObtenido = editorGuardado.get();
            System.out.println("Editor obtenido : " + editorObtenido.getNombre());

            editorObtenido.getRevistas().size();

            editorObtenido.setNombre("Editorial ABC");
            editorRepository.save(editorObtenido);
            System.out.println("Editor actualizado : " + editorObtenido.getNombre());

            Revista revista3 = new Revista();
            revista3.setNombre("Revista C");
            revista3.setEditor(editorObtenido);
            revistaRepository.save(revista3);
            System.out.println("revista creada : " + revista3.getNombre());

            Optional<Revista> revistaOptional = revistaRepository.findById(revista1.getId());
            if (revistaOptional.isPresent()){
                Revista revisEliminar = revistaOptional.get();
                revistaRepository.delete(revisEliminar);
                System.out.println("Revista eliminada : " + revisEliminar.getNombre());
            }else {
                System.out.println("Revista no encontrada");
            }
        }
        else {
            System.out.println("Editor no encontrado");
        }
    }
}
