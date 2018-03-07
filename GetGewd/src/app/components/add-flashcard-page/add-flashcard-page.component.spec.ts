import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddFlashcardPageComponent } from './add-flashcard-page.component';

describe('AddFlashcardPageComponent', () => {
  let component: AddFlashcardPageComponent;
  let fixture: ComponentFixture<AddFlashcardPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddFlashcardPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddFlashcardPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
