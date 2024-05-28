package ru.kolokolnin.testntt.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kolokolnin.testntt.dto.DirectorDto;
import ru.kolokolnin.testntt.service.DirectorService;

import java.util.List;

@RestController
@RequestMapping("/directors")
@RequiredArgsConstructor
public class DirectorController {

    private final DirectorService directorService;

    @GetMapping
    public ResponseEntity<List<DirectorDto>> getAllDirectors() {
        List<DirectorDto> directors = directorService.findAll();
        return ResponseEntity.ok(directors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DirectorDto> getDirectorById(@PathVariable Integer id) {
        DirectorDto director = directorService.findById(id);
        if (director != null) {
            return ResponseEntity.ok(director);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<DirectorDto> createDirector(@RequestBody DirectorDto directorDto) {
        DirectorDto savedDirector = directorService.save(directorDto);
        return ResponseEntity.ok(savedDirector);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DirectorDto> updateDirector(@PathVariable Integer id, @RequestBody DirectorDto directorDto) {
        directorDto.setId(id);
        DirectorDto updatedDirector = directorService.save(directorDto);
        return ResponseEntity.ok(updatedDirector);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDirector(@PathVariable Integer id) {
        directorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
