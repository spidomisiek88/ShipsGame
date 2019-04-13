package pl.michalPajak.ShipsGame.models.services;

import lombok.Data;
import org.springframework.stereotype.Service;
import pl.michalPajak.ShipsGame.models.PlayersShipsBoard;

import java.util.HashMap;
import java.util.Map;

@Service
@Data
public class PlayersShipsBoardService {

    PlayersShipsBoard playersShipsBoard;

    public PlayersShipsBoard initializePlayersShipsBoard(int numberOfFieldsHorizontally, int numberOfFieldsVertically) {

        playersShipsBoard = new PlayersShipsBoard();
        playersShipsBoard.setShipsBoard(new HashMap<>());

        for (int i = 0; i < numberOfFieldsVertically; i++) {
            Map<String, Integer> rowOnBoard = new HashMap<>();
            int prefixOvertheRange = 0;
            int numberOfLetters = 0;
            for (int j = 0; j < numberOfFieldsHorizontally; j++) {
                if (j < 26)
                    rowOnBoard.put(new StringBuilder().append((char)(65 + j)).toString(), 0);
                else {
                    if (numberOfLetters > 25) {
                        prefixOvertheRange++;
                        numberOfLetters = 0;
                    }
                    rowOnBoard.put(new StringBuilder().append((char)(65 + prefixOvertheRange))
                            .append((char)(65 + numberOfLetters)).toString(), 0);
                    numberOfLetters++;
                }
            }
            playersShipsBoard.getShipsBoard().put(i, rowOnBoard);
        }

        return playersShipsBoard;
    }
}
