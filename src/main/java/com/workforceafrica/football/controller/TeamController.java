package com.workforceafrica.football.controller;

import com.workforceafrica.football.model.Player;
import com.workforceafrica.football.model.Team;
import com.workforceafrica.football.repository.PlayerRepository;
import com.workforceafrica.football.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeamController {

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    TeamRepository teamRepository;

    @GetMapping("/team/{id}/playersinteam")
    List<Player> playersInTeam(@PathVariable Long id) {
        return playerRepository.getTeamPlayers(id);
    }

    @GetMapping("/team/{teamId}/injured")
    List<Player> playersInTeamInjuryStatus(@PathVariable Long teamId) {
       return playerRepository.playersInTeamInjuryStatus(teamId);
    }

    @GetMapping("/team/{teamId}/position")
    int teamPosition(@PathVariable Long teamId) {
        return 1;
    }

    @GetMapping("/teams")
    List<Team> allTeams() {
        return teamRepository.findAll();
    }

}
