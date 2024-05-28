package ru.kolokolnin.testntt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kolokolnin.testntt.domain.Director;

@Repository
public interface DirectorRepo extends JpaRepository<Director, Integer> {
}
