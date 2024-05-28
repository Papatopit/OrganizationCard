package ru.kolokolnin.testntt.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kolokolnin.testntt.domain.Organization;
import ru.kolokolnin.testntt.dto.OrganizationDto;
import ru.kolokolnin.testntt.mapper.OrganizationMapper;
import ru.kolokolnin.testntt.repository.OrganizationRepo;

import java.util.List;
import java.util.Optional;

/**
 * Сервисный слой для управления сущностью Organization.
 */
@Service
@RequiredArgsConstructor
public class OrganizationService {

    private final OrganizationRepo organizationRepository;
    private final OrganizationMapper organizationMapper;

    /**
     * Создает новую организацию.
     *
     * @param organizationDto DTO организации.
     * @return сохраненный DTO организации.
     */
    public OrganizationDto createOrganization(OrganizationDto organizationDto) {
        Organization organization = organizationMapper.organizationDtoToOrganization(organizationDto);
        Organization savedOrganization = organizationRepository.save(organization);
        return organizationMapper.organizationToOrganizationDto(savedOrganization);
    }

    /**
     * Ищет организацию по идентификатору.
     *
     * @param id идентификатор организации.
     * @return DTO организации, если найдена, иначе null.
     */
    public OrganizationDto getOrganizationById(Integer id) {
        Optional<Organization> optionalOrganization = organizationRepository.findById(id);
        return optionalOrganization.map(organizationMapper::organizationToOrganizationDto).orElse(null);
    }

    /**
     * Возвращает список всех организаций, с возможностью поиска по строке.
     *
     * @param searchString строка для поиска по полям организации.
     * @return список DTO организаций, удовлетворяющих критериям поиска.
     */
    public List<OrganizationDto> getAllOrganizations(String searchString) {
        List<Organization> organizations = organizationRepository.findAll();

        if (searchString != null && !searchString.isEmpty()) {
            return organizations.stream()
                    .filter(org -> org.getFullName().toLowerCase().contains(searchString.toLowerCase()) ||
                            org.getInn().toLowerCase().contains(searchString.toLowerCase()) ||
                            org.getShortName().toLowerCase().contains(searchString.toLowerCase()) ||
                            org.getJuridicalAddress().toLowerCase().contains(searchString.toLowerCase()) ||
                            org.getOgrn().toLowerCase().contains(searchString.toLowerCase()))
                    .map(organizationMapper::organizationToOrganizationDto)
                    .toList();
        } else {
            return organizations.stream()
                    .map(organizationMapper::organizationToOrganizationDto)
                    .toList();
        }
    }

    /**
     * Удаляет организацию по идентификатору.
     *
     * @param id идентификатор организации.
     */
    public void deleteOrganizationById(Integer id) {
        organizationRepository.deleteById(id);
    }
}
