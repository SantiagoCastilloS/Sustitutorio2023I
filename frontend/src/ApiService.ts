import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {catchError, Observable, retry, throwError} from "rxjs";
import {Compra, Cupon, RespuestaCompraClientes} from "./interfaces";



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

  reporteCompraClientes(): Observable<RespuestaCompraClientes> {
    return this.http.post<RespuestaCompraClientes>('http://localhost:8081/reporteCompraClientes', null,
      this.httpOptions)
      .pipe(
        retry(1),
        catchError(this.errorHandl)
      );
  }

  insertarCupon(data: Cupon): Observable<Cupon> {
    return this.http.post<Cupon>('http://localhost:8081/insertarCupon', data,
      this.httpOptions)
      .pipe(
        retry(1),
        catchError(this.errorHandl)
      );
  }
  actualizarCompra(data: Compra): Observable<Compra> {
    return this.http.post<Compra>('http://localhost:8081/actualizarCompra', data,
      this.httpOptions)
      .pipe(
        retry(1),
        catchError(this.errorHandl)
      );
  }

}
