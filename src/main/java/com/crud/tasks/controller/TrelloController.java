package com.crud.tasks.controller;

import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.trello.client.TrelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/trello")
public class TrelloController {

    @Autowired
    private TrelloClient trelloClient;

    @RequestMapping(method = RequestMethod.GET, value = "getTrelloBoards")
    public void getTrelloBoards() {

        List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoards();

        trelloBoards.forEach(trelloBoardDto -> {

            System.out.println(trelloBoardDto.getName().get() + " - " + trelloBoardDto.getId().get());

            System.out.println("This board contains lists: ");

            trelloBoardDto.getLists().forEach(trelloList ->
                    System.out.println(trelloList.getName() + " - " + trelloList.getId() + " - " + trelloList.isClosed()));

        });
    //18.2
  /*      List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoards();
        List<TrelloBoardDto> afterFilter = trelloBoards.stream()
                .filter(trelloBoardDto -> trelloBoardDto.getName().isPresent() && trelloBoardDto.getId().isPresent())
                .filter(trelloBoardDto->trelloBoardDto.getName().toString().contains("Kodilla"))
                .collect(Collectors.toList());
        afterFilter.forEach(trelloBoardDto -> System.out.println(trelloBoardDto.getId().get() + " " + trelloBoardDto.getName().get()));*/

    }
}