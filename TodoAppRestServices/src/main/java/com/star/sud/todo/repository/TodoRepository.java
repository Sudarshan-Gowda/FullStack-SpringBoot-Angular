package com.star.sud.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.star.sud.todo.dto.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}
