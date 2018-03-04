import { Injectable } from '@angular/core';
import { AuthService } from './core/auth.service';

@Injectable()
export class UidService {

  uid: any;

  constructor(private authService: AuthService) { }

}
