package com.todoapp.springboottodoapp.tasks;

import com.todoapp.springboottodoapp.tasks.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    //Create new task
    Task saveTask(Task task);

    //Read all task
    List<Task> readTask();

    //Read all task by id
    Optional<Task> findByTaskId(Long id);

    //Update task by id
    Task updateTask(Long id,Task updatedTask);

    //Soft Delete by ID - Change isDeleted to true
    Task softDelete(Long id);

    //Restore task by id
    Task restoreTask(Long id);

    //Complete Delete by ID
    void completeDelete(Long id);

}
