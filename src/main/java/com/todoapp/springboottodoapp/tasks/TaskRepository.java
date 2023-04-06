package com.todoapp.springboottodoapp.tasks;

import com.todoapp.springboottodoapp.tasks.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {

}
