package ru.kolokolnin.testntt.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kolokolnin.testntt.domain.FilialOrganization;
import ru.kolokolnin.testntt.dto.FilialOrganizationDto;
import ru.kolokolnin.testntt.mapper.FilialOrganizationMapper;
import ru.kolokolnin.testntt.repository.FilialOrganizationRepo;

import java.util.List;
import java.util.Optional;

/**
 * Сервисный слой для управления сущностью FilialOrganization.
 */
@Service
@RequiredArgsConstructor
public class FilialOrganizationService {

    private final FilialOrganizationRepo filialOrganizationRepo;
    private final FilialOrganizationMapper filialOrganizationMapper;

    /**
     * Возвращает список всех филиальных организаций.
     *
     * @return список всех филиальных организаций в виде DTO.
     */
    public List<FilialOrganizationDto> findAll() {
        return filialOrganizationRepo.findAll()
                .stream()
                .map(filialOrganizationMapper::mapToDto)
                .toList();
    }

    /**
     * Ищет филиальную организацию по идентификатору.
     *
     * @param id идентификатор филиальной организации.
     * @return DTO филиальной организации, если найдена, иначе null.
     */
    public FilialOrganizationDto findById(Integer id) {
        Optional<FilialOrganization> filialOrganization = filialOrganizationRepo.findById(id);
        return filialOrganization.map(filialOrganizationMapper::mapToDto).orElse(null);
    }

    /**
     * Сохраняет новую или обновленную филиальную организацию.
     *
     * @param filialOrganizationDto DTO филиальной организации.
     * @return сохраненный DTO филиальной организации.
     */
    public FilialOrganizationDto save(FilialOrganizationDto filialOrganizationDto) {
        FilialOrganization filialOrganization = filialOrganizationMapper.mapToEntity(filialOrganizationDto);
        filialOrganization = filialOrganizationRepo.save(filialOrganization);
        return filialOrganizationMapper.mapToDto(filialOrganization);
    }

    /**
     * Удаляет филиальную организацию по идентификатору.
     *
     * @param id идентификатор филиальной организации.
     */
    public void deleteById(Integer id) {
        filialOrganizationRepo.deleteById(id);
    }
}
