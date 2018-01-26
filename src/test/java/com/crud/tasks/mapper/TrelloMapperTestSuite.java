package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TrelloMapperTestSuite {

    private TrelloMapper trelloMapper = new TrelloMapper();

    @Test
    public void testMapToBoards() throws Exception {
        //Given
        List<TrelloListDto> trelloListDto = new ArrayList<>();
        trelloListDto.add(new TrelloListDto("01", "List test", false));
        List<TrelloBoardDto> trelloBoardDto = new ArrayList<>();
        trelloBoardDto.add(new TrelloBoardDto("1","Test1", trelloListDto));
        //When
        List<TrelloBoard> trelloBoards = trelloMapper.mapToBoards(trelloBoardDto);
        //Then
        Assert.assertEquals(1,trelloBoards.size());
        Assert.assertEquals("1",trelloBoards.get(0).getId());
        Assert.assertEquals("Test1",trelloBoards.get(0).getName());
        Assert.assertEquals(false,trelloBoards.get(0).getLists().get(0).isClosed());
    }

    @Test
    public void testMapToBoardsDto() throws Exception {
        //Given
        List<TrelloList> trelloList = new ArrayList<>();
        trelloList.add(new TrelloList("01", "List test", false));
        List<TrelloBoard> trelloBoard = new ArrayList<>();
        trelloBoard.add(new TrelloBoard("001","Test001",trelloList));
        //When
        List<TrelloBoardDto> trelloBoardDto = trelloMapper.mapToBoardsDto(trelloBoard);
        //Then
        Assert.assertEquals(1,trelloBoardDto.size());
        Assert.assertEquals("001",trelloBoardDto.get(0).getId());
        Assert.assertEquals("Test001",trelloBoardDto.get(0).getName());
        Assert.assertEquals(false,trelloBoardDto.get(0).getLists().get(0).isClosed());
    }

    @Test
    public void testMapToList() throws Exception {
        //Given
        List<TrelloListDto> trelloListDto = new ArrayList<>();
        trelloListDto.add(new TrelloListDto("02", "List test 2", false));
        //When
        List<TrelloList> trelloList = trelloMapper.mapToList(trelloListDto);
        //Then
        Assert.assertEquals(1,trelloList.size());
        Assert.assertEquals("02",trelloList.get(0).getId());
        Assert.assertEquals("List test 2",trelloList.get(0).getName());
        Assert.assertEquals(false,trelloList.get(0).isClosed());
    }

    @Test
    public void testMapToListDto() throws Exception {
        //Given
        List<TrelloList> trelloList = new ArrayList<>();
        trelloList.add(new TrelloList("03", "List test 3", false));
        //When
        List<TrelloListDto> trelloListDto = trelloMapper.mapToListDto(trelloList);
        //Then
        Assert.assertEquals(1,trelloListDto.size());
        Assert.assertEquals("03",trelloListDto.get(0).getId());
        Assert.assertEquals("List test 3",trelloListDto.get(0).getName());
        Assert.assertEquals(false,trelloListDto.get(0).isClosed());
    }

    @Test
    public void testMapToCardDto() throws Exception {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("Test 4","Test no 44","4","44");
        //When
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);
        //Then
        Assert.assertEquals("Test 4",trelloCard.getName());
        Assert.assertEquals("Test no 44",trelloCard.getDescription());
        Assert.assertEquals("4",trelloCard.getPos());
        Assert.assertEquals("44",trelloCard.getListId());
    }

    @Test
    public void testMapToCard() throws Exception {
        //Given
        TrelloCard trelloCard = new TrelloCard("Test 5","Test no 55","5","55");
        //When
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard);
        //Then
        Assert.assertEquals("Test 5",trelloCardDto.getName());
        Assert.assertEquals("Test no 55",trelloCardDto.getDescription());
        Assert.assertEquals("5",trelloCardDto.getPos());
        Assert.assertEquals("55",trelloCardDto.getListId());
    }

}