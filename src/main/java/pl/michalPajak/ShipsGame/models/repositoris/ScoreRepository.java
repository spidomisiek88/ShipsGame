package pl.michalPajak.ShipsGame.models.repositoris;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.michalPajak.ShipsGame.models.entities.ScoreEntity;

@Repository
public interface ScoreRepository extends CrudRepository<ScoreEntity, Integer> {
}
