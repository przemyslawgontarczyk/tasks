package com.crud.tasks.controller;

import com.crud.tasks.domain.CreatedTrelloCardDto;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.service.TrelloService;
import com.crud.tasks.trello.facade.TrelloFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/trello")
@CrossOrigin(origins = "*")
public class TrelloController {

    @Autowired
    private TrelloFacade trelloFacade;

    @RequestMapping(method = RequestMethod.GET, value = "getTrelloBoards")
    public List<TrelloBoardDto> getTrelloBoards() {
        return trelloFacade.fetchTrelloBoards();
    }


    //18.2
  /*      List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoards();
        List<TrelloBoardDto> afterFilter = trelloBoards.stream()
                .filter(trelloBoardDto -> trelloBoardDto.getName().isPresent() && trelloBoardDto.getId().isPresent())
                .filter(trelloBoardDto->trelloBoardDto.getName().toString().contains("Kodilla"))
                .collect(Collectors.toList());
        afterFilter.forEach(trelloBoardDto -> System.out.println(trelloBoardDto.getId().get() + " " + trelloBoardDto.getName().get()));*/


    @RequestMapping(method = RequestMethod.POST, value = "createTrelloCard")
    public CreatedTrelloCardDto createTrelloCard(@RequestBody TrelloCardDto trelloCardDto) {

        return trelloFacade.createCard(trelloCardDto);
    }
}