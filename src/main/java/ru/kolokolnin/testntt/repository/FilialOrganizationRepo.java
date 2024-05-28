package ru.kolokolnin.testntt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kolokolnin.testntt.domain.FilialOrganization;

@Repository
public interface FilialOrganizationRepo extends JpaRepository<FilialOrganization, Integer> {
}
