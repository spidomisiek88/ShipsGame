package pl.michalPajak.ShipsGame.models.services;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.michalPajak.ShipsGame.models.entities.PlayerEntity;
import pl.michalPajak.ShipsGame.models.enums.GameMode;
import pl.michalPajak.ShipsGame.models.repositoris.PlayerRepository;

import java.util.Optional;

@Service
@Data
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    GameMode gameMode;

    public PlayerEntity initializePlayer(String playerName, boolean isComputer) { //gameMenuForm.getFirstPlayerName(), GameMode.COMPUTERTOCOMPUTER.equals(gameMenuForm.getGameMode())
        Optional<PlayerEntity> optionalPlayerEntity = playerRepository.findPlayerByName(playerName);
        PlayerEntity playerEntity;

        if (!optionalPlayerEntity.isPresent()) {
            playerEntity = createPlayer(playerName, isComputer);
        }

        playerEntity = optionalPlayerEntity.get();

        return playerEntity;
    }

    public PlayerEntity createPlayer(String playerName, boolean isComputer) {
        PlayerEntity playerEntity = new PlayerEntity();
        playerEntity.setName(playerName);
        playerEntity.setIsComputer(isComputer ? 1 : 0);

        playerRepository.save(playerEntity);

        return playerEntity;
    }
}
