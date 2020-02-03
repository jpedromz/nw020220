import { environment } from './../../environments/environment';
import { retry, catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';
import { HttpErrorResponse, HttpClient } from '@angular/common/http';
import { PlanoDeSaude } from './../model/plano-de-saude';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PlanoDeSaudeService {

  private configUrl = environment.pathUrl + 'especialidades';

  constructor(private http: HttpClient) { }

  getPlanosDeSaude() {
    return this.http.get<PlanoDeSaude[]>(this.configUrl)
      .pipe(
        retry(3), // retry a failed request up to 3 times
        catchError(this.handleError) // then handle the error
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
