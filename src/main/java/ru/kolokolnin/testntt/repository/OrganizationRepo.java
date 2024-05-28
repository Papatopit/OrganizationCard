package ru.kolokolnin.testntt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kolokolnin.testntt.domain.Organization;

@Repository
public interface OrganizationRepo extends JpaRepository<Organization, Integer> {
}
