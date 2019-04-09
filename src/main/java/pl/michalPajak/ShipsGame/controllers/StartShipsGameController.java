package pl.michalPajak.ShipsGame.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.michalPajak.ShipsGame.models.GameMenuForm;
import pl.michalPajak.ShipsGame.models.enums.GameMode;

@Controller
public class ShipsGameController {

    @GetMapping("/ships/menu")
    public String showGameModeMenuForm(Model model) {

        model.addAttribute("gameModeMenuForm", new GameMenuForm());
        model.addAttribute("gameModePlayerToPlayer", GameMode.PLAYERTOPLAYER);
        model.addAttribute("gameModePlayerToComputer", GameMode.PLAYERTOCOMPUTER);
        model.addAttribute("gameModeComputerToComputer", GameMode.COMPUTERTOCOMPUTER);
        model.addAttribute("gameModeMultiplayer", GameMode.MULTIPLAYER);

        return "game_menu_form";
    }

    @PostMapping("/ships/menu/game_mode")
    public String handlingGameModeMenuForm(@ModelAttribute GameMenuForm gameModeMenuForm, Model model) {



        return "add_ships_form";
    }
}
