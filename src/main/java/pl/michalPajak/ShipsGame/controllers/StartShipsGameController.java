package pl.michalPajak.ShipsGame.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.michalPajak.ShipsGame.models.forms.GameMenuForm;
import pl.michalPajak.ShipsGame.models.enums.GameMode;
import pl.michalPajak.ShipsGame.models.services.StartGameService;

@Controller
public class StartShipsGameController {

    @Autowired
    StartGameService startGameService;

    @GetMapping("/ships/menu")
    public String showGameModeMenuForm(Model model) {

        model.addAttribute("gameMenuForm", new GameMenuForm());
        model.addAttribute("gameModePlayerToPlayer", GameMode.PLAYERTOPLAYER);
        model.addAttribute("gameModePlayerToComputer", GameMode.PLAYERTOCOMPUTER);
        model.addAttribute("gameModeComputerToComputer", GameMode.COMPUTERTOCOMPUTER);
        model.addAttribute("gameModeMultiplayer", GameMode.MULTIPLAYER);

        return "game_menu_form";
    }

    @PostMapping("/ships/menu/game_mode")
    public String handlingGameModeMenuForm(@ModelAttribute GameMenuForm gameModeMenuForm, Model model) {

        startGameService.initializeGameBoard(gameModeMenuForm);

        return "addition_ships_form";
    }
}
