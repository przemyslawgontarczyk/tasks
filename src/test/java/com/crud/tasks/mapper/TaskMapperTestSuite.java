package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskMapperTestSuite {

    @Autowired
    private TaskMapper taskMapper;

    @Test
    public void shouldMapToTask() {
        // Given
        Long id = 1L;
        String title = "Test Task ";
        String content = "bla bla";
        TaskDto taskDto = new TaskDto(id, title, content);

        //When
        Task mappedTask = taskMapper.mapToTask(taskDto);

        //Then
        assertEquals(id, mappedTask.getId());
        assertEquals(title, mappedTask.getTitle());
        assertEquals(content, mappedTask.getContent());
    }

    @Test
    public void shouldMapToTaskDto() {
        // Given
        Long id = 1L;
        String title = "Numero 1";
        String content = "blalalala";
        Task task = new Task(id, title, content);

        //When
        TaskDto mappedTaskDto = taskMapper.mapToTaskDto(task);

        //Then
        assertEquals(id, mappedTaskDto.getId());
        assertEquals(title, mappedTaskDto.getTitle());
        assertEquals(content, mappedTaskDto.getContent());
    }

    @Test
    public void shouldMapToTaskDtoList() {
        // Given
        int taskCount = 20;
        List<Task> taskList = new ArrayList<>();
        for (int i = 1; i <= taskCount; i++) {
            taskList.add(new Task((long)i, "Task " + i, "bla bla " + i));
        }

        // When
        List<TaskDto> mappedTaskDtoList = taskMapper.mapToTaskDtoList(taskList);

        // Then
        assertEquals(taskCount, mappedTaskDtoList.size());
        for (int i = 1; i <= taskCount; i++) {
            long taskId = mappedTaskDtoList.get(i - 1).getId();
            assertEquals((long) i, taskId);
            assertEquals("Task " + i, mappedTaskDtoList.get(i - 1).getTitle());
            assertEquals("bla bla " + i, mappedTaskDtoList.get(i - 1).getContent());
        }
    }
}