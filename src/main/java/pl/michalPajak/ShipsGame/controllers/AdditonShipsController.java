package pl.michalPajak.ShipsGame.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.michalPajak.ShipsGame.models.forms.AdditionShipsForm;
import pl.michalPajak.ShipsGame.models.services.PlayersShipsBoardService;
import pl.michalPajak.ShipsGame.models.sessions.GameSession;

@Controller
public class AdditonShipsController {

    @Autowired
    GameSession gameSession;
    @Autowired
    PlayersShipsBoardService playersShipsBoardService;

    @GetMapping("/ships/addition")
    public String showAdditonShipsForm(Model model) {

        model.addAttribute("additionShipsForm", new AdditionShipsForm());
        model.addAttribute("actualPlayer", gameSession.getActualTurn().getKey());
        model.addAttribute("actualPlayersShipsBoard", gameSession.getActualTurn().getValue());

        return "addition_ships_form";
    }

    @PostMapping(value = "/ships/addition", params = "add")
    public String addShipToBoard(@ModelAttribute AdditionShipsForm additionShipsForm) {

        if (gameSession.getActualTurn().getValue().getShipsCounter() < 10) {
            gameSession.getActualTurn().setValue(playersShipsBoardService
                    .addShipBoard(gameSession.getActualTurn().getValue(),
                            additionShipsForm.getHorizontallyCoordinates(),
                            additionShipsForm.getVerticallyCoordinates()));
        } else {
            gameSession.nextPlayersTurn();
        }

        return "redirect:/ships/addition";
    }
}
