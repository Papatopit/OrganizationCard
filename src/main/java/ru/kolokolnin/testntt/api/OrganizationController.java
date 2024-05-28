package ru.kolokolnin.testntt.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.kolokolnin.testntt.dto.OrganizationDto;
import ru.kolokolnin.testntt.service.OrganizationService;

import java.util.List;

@RestController
@RequestMapping("/organizations")
@RequiredArgsConstructor
public class OrganizationController {

    private final OrganizationService organizationService;

    @PostMapping
    public OrganizationDto createOrganization(@RequestBody OrganizationDto organizationDto) {
        return organizationService.createOrganization(organizationDto);
    }

    @GetMapping("/{id}")
    public OrganizationDto getOrganizationById(@PathVariable Integer id) {
        return organizationService.getOrganizationById(id);
    }

    @GetMapping
    public List<OrganizationDto> getAllOrganizations(@RequestParam(required = false) String searchString) {
        return organizationService.getAllOrganizations(searchString);
    }

    @DeleteMapping("/{id}")
    public void deleteOrganizationById(@PathVariable Integer id) {
        organizationService.deleteOrganizationById(id);
    }
}
