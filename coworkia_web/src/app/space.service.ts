import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Site } from './space/site';

@Injectable({
  providedIn: 'root',
})
export class SpaceService {
  private apiUrl = 'http://localhost:8080/api/sites';

  constructor(private http: HttpClient) {}

  getSites(): Observable<Site[]> {
    return this.http.get<Site[]>(this.apiUrl);
  }
}
