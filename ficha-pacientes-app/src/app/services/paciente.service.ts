import { environment } from './../../environments/environment.prod';
import { Paciente } from './../model/paciente';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { retry, catchError } from 'rxjs/operators';

import { HttpErrorResponse, HttpResponse, HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PacienteService {
  private configUrl = environment.pathUrl + 'ficha-pacientes';

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private http: HttpClient) { }

  getPacientes() {
    return this.http.get<Paciente[]>(this.configUrl)
      .pipe(
        retry(3), // retry a failed request up to 3 times
        catchError(this.handleError) // then handle the error
      );
  }

  updatePaciente(paciente: Paciente): Observable<Paciente> {
    /* return this.http.put<Paciente>(this.configUrl, paciente, this.httpOptions)
      .pipe(
        retry(1),
        catchError(this.handleError)
      );*/
      return null;
  }

  deletePaciente(id: number): Observable<{}> {
    const url = `${this.configUrl}/${id}`;
    return this.http.delete(url, this.httpOptions)
      .pipe(
        retry(1),
        catchError(this.handleError)
      );
  }

  handleError(error: HttpErrorResponse) {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      // Erro ocorreu no lado do client
      errorMessage = error.error.message;
    } else {
      // Erro ocorreu no lado do servidor
      errorMessage = `Código do erro: ${error.status}, ` + `menssagem: ${error.message}`;
    }
    console.log(errorMessage);
    return throwError(errorMessage);
  }

}
