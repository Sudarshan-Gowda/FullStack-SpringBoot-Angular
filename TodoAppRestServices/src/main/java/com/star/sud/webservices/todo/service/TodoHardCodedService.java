package com.star.sud.webservices.todo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.star.sud.todo.dto.Todo;
import com.star.sud.todo.repository.TodoRepository;

@Service
public class TodoHardCodedService {

	private static final Logger log = LoggerFactory.getLogger(TodoHardCodedService.class);

	@Autowired
	private TodoRepository repository;

	public List<Todo> findAll() {
		return repository.findAll();
	}

	public Todo updateTodo(Long id, Todo todo) {
		try {

			Todo todos = repository.findById(id).orElseThrow(() -> new Exception("No record found exception"));
			todos.setDescription(todo.getDescription());
			todos.setTargetDate(todo.getTargetDate());
			repository.save(todos);
			return todos;
		} catch (Exception e) {
			log.error("updateTodo", e);
			return null;
		}

	}

	public Todo saveTodos(Todo todo) {
		try {
			Todo todos = repository.save(todo);
			return todos;
		} catch (Exception e) {
			log.error("createTodo", e);
			return null;
		}

	}

	public ResponseEntity<Void> deleteTodo(Long id) {
		try {
			Todo todos = repository.findById(id).orElseThrow(() -> new Exception("No record found exception"));
			repository.delete(todos);
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			log.error("deleteTodo", e);
			return ResponseEntity.notFound().build();
		}

	}

	public Todo findById(long id) {
		try {
			Todo todos = repository.findById(id).orElseThrow(() -> new Exception("No record found exception"));
			return todos;
		} catch (Exception e) {
			log.error("findById", e);
			return null;
		}
	}
}
