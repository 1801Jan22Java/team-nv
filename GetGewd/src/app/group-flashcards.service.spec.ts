import { TestBed, inject } from '@angular/core/testing';

import { GroupFlashcardsService } from './group-flashcards.service';

describe('GroupFlashcardsService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [GroupFlashcardsService]
    });
  });

  it('should be created', inject([GroupFlashcardsService], (service: GroupFlashcardsService) => {
    expect(service).toBeTruthy();
  }));
});
