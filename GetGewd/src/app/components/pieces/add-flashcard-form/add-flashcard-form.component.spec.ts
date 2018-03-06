import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddFlashcardFormComponent } from './add-flashcard-form.component';

describe('AddFlashcardFormComponent', () => {
  let component: AddFlashcardFormComponent;
  let fixture: ComponentFixture<AddFlashcardFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddFlashcardFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddFlashcardFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
