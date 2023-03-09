package com.colutti.exploringbasejparepository.repositories;

import com.colutti.exploringbasejparepository.entities.Person;
import io.hypersistence.utils.spring.repository.BaseJpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends BaseJpaRepository<Person, Long>, PagingAndSortingRepository<Person, Long> {
}
