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
import ru.kolokolnin.testntt.dto.FilialOrganizationDto;
import ru.kolokolnin.testntt.service.FilialOrganizationService;

import java.util.List;

@RestController
@RequestMapping("/filial-organizations")
@RequiredArgsConstructor
public class FilialOrganizationController {

    private final FilialOrganizationService filialOrganizationService;

    @GetMapping
    public ResponseEntity<List<FilialOrganizationDto>> getAllFilialOrganizations() {
        List<FilialOrganizationDto> filialOrganizations = filialOrganizationService.findAll();
        return ResponseEntity.ok(filialOrganizations);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FilialOrganizationDto> getFilialOrganizationById(@PathVariable Integer id) {
        FilialOrganizationDto filialOrganization = filialOrganizationService.findById(id);
        return filialOrganization != null ? ResponseEntity.ok(filialOrganization) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<FilialOrganizationDto> createFilialOrganization(@RequestBody FilialOrganizationDto filialOrganizationDto) {
        FilialOrganizationDto savedFilialOrganization = filialOrganizationService.save(filialOrganizationDto);
        return ResponseEntity.ok(savedFilialOrganization);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FilialOrganizationDto> updateFilialOrganization(@PathVariable Integer id, @RequestBody FilialOrganizationDto filialOrganizationDto) {
        filialOrganizationDto.setId(id);
        FilialOrganizationDto updatedFilialOrganization = filialOrganizationService.save(filialOrganizationDto);
        return ResponseEntity.ok(updatedFilialOrganization);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFilialOrganization(@PathVariable Integer id) {
        filialOrganizationService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
