package ru.kolokolnin.testntt.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kolokolnin.testntt.domain.Director;
import ru.kolokolnin.testntt.dto.DirectorDto;
import ru.kolokolnin.testntt.mapper.DirectorMapper;
import ru.kolokolnin.testntt.repository.DirectorRepo;

import java.util.List;
import java.util.Optional;
/**
 * Сервисный слой для управления сущностью Director.
 */
@Service
@RequiredArgsConstructor
public class DirectorService {

    private final DirectorRepo directorRepository;
    private final DirectorMapper directorMapper;

    /**
     * Возвращает список всех директоров.
     *
     * @return список всех директоров в виде DTO.
     */
    public List<DirectorDto> findAll() {
        return directorRepository.findAll()
                .stream()
                .map(directorMapper::mapToDto)
                .toList();
    }

    /**
     * Ищет директора по идентификатору.
     *
     * @param id идентификатор директора.
     * @return DTO директора, если найден, иначе null.
     */
    public DirectorDto findById(Integer id) {
        Optional<Director> director = directorRepository.findById(id);
        return director.map(directorMapper::mapToDto).orElse(null);
    }

    /**
     * Сохраняет нового или обновленного директора.
     *
     * @param directorDto DTO директора.
     * @return сохраненный DTO директора.
     */
    public DirectorDto save(DirectorDto directorDto) {
        Director director = directorMapper.mapToModel(directorDto);
        director = directorRepository.save(director);
        return directorMapper.mapToDto(director);
    }

    /**
     * Удаляет директора по идентификатору.
     *
     * @param id идентификатор директора.
     */
    public void deleteById(Integer id) {
        directorRepository.deleteById(id);
    }

}
