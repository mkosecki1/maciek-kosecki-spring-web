package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TaskMapperTestSuite {
    @Test
    public void testMapToTask() throws Exception {
        //Given
        TaskDto taskDto = new TaskDto(123L,"title_test","content_test");
        //When
        TaskMapper taskMapper = new TaskMapper();
        Task task = taskMapper.mapToTask(taskDto);
        //Then
        Assert.assertEquals("title_test",task.getTitle());
    }

    @Test
    public void testMapToTaskDto() throws Exception {
        //Given
        Task task = new Task(3L,"title_test1","content_test1");
        //When
        TaskMapper taskMapper = new TaskMapper();
        TaskDto taskDto = taskMapper.mapToTaskDto(task);
        //Then
        Assert.assertEquals("title_test1",taskDto.getTitle());
    }

    @Test
    public void testMapToTaskDtoList() throws Exception {
        //Given
        List<Task> taskList = new ArrayList<>();
        taskList.add(new Task(4L,"title_test123","content_test123"));
        //When
        TaskMapper taskMapper = new TaskMapper();
        List<TaskDto> taskDto = taskMapper.mapToTaskDtoList(taskList);
        //Then
        Assert.assertEquals("title_test123",taskDto.get(0).getTitle());
    }

    @Test
    public void testMapToTaskDtoEmptyList() throws Exception {
        //Given
        List<Task> taskList = new ArrayList<>();
        //When
        TaskMapper taskMapper = new TaskMapper();
        List<TaskDto> taskDto = taskMapper.mapToTaskDtoList(taskList);
        //Then
        Assert.assertEquals(0,taskDto.size());
        Assert.assertNotNull(taskDto);
    }

}