import { API_URL } from './../../app.constants';
import { Todo } from './../../list-todos/list-todos.component';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TodoDataService {

  constructor(private http: HttpClient) { }

  retriveAllTodos(users: string){
    return this.http.get<Todo[]>(`${API_URL}/users/${users}/todos`);
  }

  deleteTodo(users: string, id: number){
    return this.http.delete(`${API_URL}/users/${users}/todos/${id}`);
  }

  retriveTodo(users: string, id: number){
    return this.http.get<Todo>(`${API_URL}/users/${users}/todos/${id}`);
  }

  updateTodo(users: string, id: number, todo: Todo){
    return this.http.put(`${API_URL}/users/${users}/todos/${id}`, todo);
  }

  createTodo(users: string, todo: Todo){
    return this.http.post(`${API_URL}/users/${users}/todos`, todo);
  }

}
