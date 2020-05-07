package com.star.sud.webservices.todo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.star.sud.todo.dto.Todo;
import com.star.sud.webservices.todo.service.TodoHardCodedService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TodoController {

	@Autowired
	private TodoHardCodedService hardCodedService;

	@GetMapping(value = "/users/{username}/todos")
	public List<Todo> getTodos(@PathVariable String username) {
		return hardCodedService.findAll();
	}

	@GetMapping(value = "/users/{username}/todos/{id}")
	public Todo getTodosById(@PathVariable String username, @PathVariable long id) {
		return hardCodedService.findById(id);
	}

	@PutMapping(value = "/users/{username}/todos/{id}")
	public ResponseEntity<Todo> updateTodos(@PathVariable String username, @RequestBody Todo todo,
			@PathVariable long id) {
		Todo updateTodos = hardCodedService.saveTodos(todo);
		return new ResponseEntity<Todo>(updateTodos, HttpStatus.OK);
	}

	@PostMapping(value = "/users/{username}/todos")
	public ResponseEntity<Void> saveTodos(@PathVariable String username, @RequestBody Todo todo) {
		todo.setUsername(username);
		Todo saveTodos = hardCodedService.saveTodos(todo);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveTodos.getId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping(value = "/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodos(@PathVariable String username, @PathVariable long id) {
		return hardCodedService.deleteTodo(id);
	}

}
