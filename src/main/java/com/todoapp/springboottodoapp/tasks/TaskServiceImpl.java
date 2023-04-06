package com.todoapp.springboottodoapp.tasks;

import com.todoapp.springboottodoapp.exceptions.TaskNotFoundException;
import com.todoapp.springboottodoapp.tasks.Task;
import com.todoapp.springboottodoapp.tasks.TaskRepository;
import com.todoapp.springboottodoapp.tasks.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    //Save new task
    public Task saveTask(Task task){
        return taskRepository.save(task);
    }

    @Override
    //Read all task
    public List<Task> readTask(){
        return (List<Task>) taskRepository.findAll();
    }

    @Override
    //Read all task by id
    public Optional<Task> findByTaskId(Long id){
        return Optional.ofNullable(taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException()));
    }

    @Override
    //Update task by id
    public Task updateTask(Long id,Task updateTask){
        Task existingTask = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException());
        existingTask.setTitle(updateTask.getTitle());
        existingTask.setDescription(updateTask.getDescription());
        existingTask.setDueDate(updateTask.getDueDate());
        existingTask.setCategory(updateTask.getCategory());
        return taskRepository.save(existingTask);
    }

    @Override
    //Soft Delete by ID - Change isDeleted to true
    public Task softDelete(Long id){
        Task existingTask = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException());
        existingTask.setIsDeleted(true);
        return taskRepository.save(existingTask);
    }

    @Override
    //Restore Soft Delete by ID - Change isDeleted to false
    public Task restoreTask(Long id){
        Task existingTask = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException());
        existingTask.setIsDeleted(false);
        return taskRepository.save(existingTask);
    }

    @Override
    //Complete Delete by ID
    public void completeDelete(Long id){
        Task existingTask = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException());
        existingTask.setIsDeleted(true);
        taskRepository.delete(existingTask);
    }
}
