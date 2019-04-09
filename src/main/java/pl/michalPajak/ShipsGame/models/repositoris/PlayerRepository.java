package pl.michalPajak.ShipsGame.models.repositoris;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.michalPajak.ShipsGame.models.entities.PlayerEntity;

import java.util.Optional;

@Repository
public interface PlayerRepository extends CrudRepository<PlayerEntity, Integer>{

    @Query(nativeQuery = true, value = "SELECT * FROM `player` WHERE player_name = ?1")
    Optional<PlayerEntity> findPlayerByName(String userName);
}
