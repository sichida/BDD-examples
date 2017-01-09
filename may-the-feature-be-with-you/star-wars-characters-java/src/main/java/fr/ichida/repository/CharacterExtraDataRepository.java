package fr.ichida.repository;

import fr.ichida.domain.CharacterExtraData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by shoun on 09/01/2017.
 */
@Repository
public interface CharacterExtraDataRepository extends JpaRepository<CharacterExtraData, Integer> {
}
