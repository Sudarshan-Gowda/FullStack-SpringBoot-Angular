import { BasicAuthserviceService } from './../service/basic-authservice.service';
import { ActivatedRoute, Router } from '@angular/router';
import { TodoDataService } from './../service/data/todo-data.service';
import { Component, OnInit } from '@angular/core';
import { Todo } from '../list-todos/list-todos.component';

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent implements OnInit {

  id: number;
  todo: Todo;

  constructor(private todoservice: TodoDataService,
              private route: ActivatedRoute, private router: Router,
              private authService: BasicAuthserviceService) { }

  ngOnInit(): void {
    this.id = + this.route.snapshot.params['id'];

    this.todo = new Todo(this.id, '', '', false, new Date());
    if (this.id !== -1) {
      this.todoservice.retriveTodo(this.authService.getAuthenticatedUser(), this.id).subscribe(
        data => {
          this.todo = data;
        }
      );
    }
  }

  saveTodo() {
    this.id = + this.route.snapshot.params['id'];
    if (this.id === -1){
        this.createToDo();
    }else{
      this.todoservice.updateTodo(this.authService.getAuthenticatedUser(), this.id, this.todo).subscribe(
        respose => {
          console.log(respose);
          this.router.navigate(['todos']);
        }
      );
    }
  }

  createToDo() {
    this.todoservice.createTodo(this.authService.getAuthenticatedUser(), this.todo).subscribe(
      response => {
        this.router.navigate(['todos']);
      }
    );
  }

}
