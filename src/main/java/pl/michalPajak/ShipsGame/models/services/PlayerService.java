package pl.michalPajak.ShipsGame.models.services;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.michalPajak.ShipsGame.models.Player;
import pl.michalPajak.ShipsGame.models.PlayersShipsBoard;
import pl.michalPajak.ShipsGame.models.entities.PlayerEntity;
import pl.michalPajak.ShipsGame.models.repositoris.PlayerRepository;

import java.util.Optional;

@Service
@Data
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    public Player initializePlayer(String playerName, boolean isComputer) {
        Optional<PlayerEntity> optionalPlayerEntity = playerRepository.findPlayerByName(playerName);
        PlayerEntity playerEntity;

        if (!optionalPlayerEntity.isPresent())
            playerEntity = createPlayer(playerName, isComputer);
        else
            playerEntity = optionalPlayerEntity.get();

        Player player = new Player();
        player.setPlayerEntity(playerEntity);
        player.setPlayerShipsBoard(new PlayersShipsBoard());

        return player;
    }

    private PlayerEntity createPlayer(String playerName, boolean isComputer) {
        PlayerEntity playerEntity = new PlayerEntity();
        playerEntity.setName(playerName);
        playerEntity.setIsComputer(isComputer ? 1 : 0);

        playerRepository.save(playerEntity);

        return playerEntity;
    }
}
