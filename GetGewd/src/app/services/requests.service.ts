import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'

@Injectable()
export class RequestsService {

  constructor(private httpClient:HttpClient) { 
      
  }

}
