package com.testCRUD.NewCrud.Entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompTaskRepo extends JpaRepository<CompletedTasks, Long>  {

}
