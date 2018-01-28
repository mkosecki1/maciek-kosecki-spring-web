package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.mockito.ArgumentMatchers.any;


@RunWith(MockitoJUnitRunner.Silent.class)
public class DbServiceTestSuite {

    @InjectMocks
    private DbService dbService;

    @Mock
    TaskRepository taskRepository;

    @Test
    public void testGetAllTasks() throws Exception {
        //Given
        List<Task> taskList = new ArrayList<>();
        taskList.add(new Task(1L,"test1","test_1"));
        taskList.add(new Task(2L,"test2","test_2"));
        taskList.add(new Task(3L,"test3","test_3"));
        //When
        Mockito.when(dbService.getAllTasks()).thenReturn(taskList);
        //Then
        Assert.assertEquals(3,taskList.size());
        Assert.assertEquals("test1",taskList.get(0).getTitle());
    }

    @Test
    public void saveTask() throws Exception {
        //Given
        Task task = new Task(1L,"test1","test_1");
        Mockito.when(dbService.saveTask(any(Task.class))).thenReturn(task);
        //When
        Task task1 = dbService.saveTask(task);
        //Then
        Assert.assertEquals(task.getContent(),task1.getContent());
        Assert.assertEquals(task.getId(),task1.getId());

    }

    @Test
    public void testGetTask() throws Exception {
        //Given
        List<Task> taskList = new ArrayList<>();
        taskList.add(new Task(1L,"test1","test_1"));
        taskList.add(new Task(2L,"test2","test_2"));
        //When
        Mockito.when(dbService.getTask(2L)).thenReturn(Optional.ofNullable(taskList.get(1)));;
        Optional<Task> taskResult = dbService.getTask(2L);
        //Then
        Assert.assertEquals(taskList.get(1).getId(),taskResult.get().getId());
        Assert.assertEquals("test2",taskResult.get().getTitle());
    }

    @Test
    public void deleteTask() throws Exception {
        /*
        //Given
        List<Task> taskList = new ArrayList<>();
        Task task = new Task(1L,"test1","test_1");
        taskList.add(task);
        //When
        dbService.deleteTask(task.getId());
        //Then
        Assert.assertEquals(0,taskList.size());
        */
    }

    @Test
    public void testShouldGetTaskListEmpty() {
        //Given
        List<Task> tasks = new ArrayList<>();
        Mockito.when(dbService.getAllTasks()).thenReturn(tasks);
        //When
        List<Task> taskList = dbService.getAllTasks();
        //Then
        Assert.assertEquals(0, taskList.size());
    }

}