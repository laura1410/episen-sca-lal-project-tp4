import { Component } from '@angular/core';
import { FormsModule }   from '@angular/forms';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';
  field:string;
  data:string;

  constructor(private http: HttpClient) { }

  sendData() {
    this.field = this.data
    console.log(this.field);
    this.http.post<any>('http://localhost:8080/add/order', this.data).subscribe(data => {
      console.log("Success");
    })
  }
}
