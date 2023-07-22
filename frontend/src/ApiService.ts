import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {catchError, Observable, retry, throwError} from "rxjs";
import {Equipo, RespuestaGoleadores, RespuestaGolesPartidos} from "./interfaces";


@Injectable({
  providedIn: 'root'
})
export class ApiService {

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json;charset=utf-8'
    })
  };
  errorHandl(error:any) {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      errorMessage = error.error.message;
    } else {
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    console.log(errorMessage);
    return throwError(errorMessage);
  }
  constructor(private http: HttpClient) { }

  reporteGolesPartidos(): Observable<RespuestaGolesPartidos> {
    return this.http.post<RespuestaGolesPartidos>('http://localhost:8081/reporteGolesPartidos', null,
      this.httpOptions)
      .pipe(
        retry(1),
        catchError(this.errorHandl)
      );
  }

  reporteGoleadores(): Observable<RespuestaGoleadores> {
    return this.http.post<RespuestaGoleadores>('http://localhost:8081/reporteGoleadores', null,
      this.httpOptions)
      .pipe(
        retry(1),
        catchError(this.errorHandl)
      );
  }

  agregarEquipo(data: Equipo): Observable<Equipo> {
    return this.http.post<Equipo>('http://localhost:8081/agregarEquipo', data,
      this.httpOptions)
      .pipe(
        retry(1),
        catchError(this.errorHandl)
      );
  }

}
