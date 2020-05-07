import { BasicAuthserviceService } from './../service/basic-authservice.service';
import { TodoDataService } from './../service/data/todo-data.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

export class Todo {
  constructor(public id: number,
              public username: string,
              public description: string,
              public isDone: boolean,
              public targetDate: Date){
  }
}

@Component({
  selector: 'app-list-todos',
  templateUrl: './list-todos.component.html',
  styleUrls: ['./list-todos.component.css']
})
export class ListTodosComponent implements OnInit {

  todos: Todo[] ;
  user: string;
  alertMessage: string;


  constructor(private todoService: TodoDataService ,
              private router: Router,
              private basicAuthService: BasicAuthserviceService) {

  }

  ngOnInit(): void {
    this.refreshTodos();
  }

  deleteToDo(id){

    this.todoService.deleteTodo(this.basicAuthService.getAuthenticatedUser(), id).subscribe(
      response => {
        this.alertMessage = `Successfully Deleted the Todo id : ${id}`;
        this.refreshTodos();
      },
      error => {
        this.alertMessage = 'Failed to delete!, Please try after some time!';
      }
    );
  }

  updateToDo(id){
     this.router.navigate(['todos/', id]);
  }

  createToDo(){
    this.router.navigate(['todos/', -1]);
  }

  refreshTodos(){
    this.todoService.retriveAllTodos(this.basicAuthService.getAuthenticatedUser()).subscribe(
      response => {
        this.todos = response;
      }
    );
  }

}
