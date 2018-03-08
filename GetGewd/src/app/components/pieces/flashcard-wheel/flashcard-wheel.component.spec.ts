import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FlashcardWheelComponent } from './flashcard-wheel.component';

describe('FlashcardWheelComponent', () => {
  let component: FlashcardWheelComponent;
  let fixture: ComponentFixture<FlashcardWheelComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FlashcardWheelComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FlashcardWheelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
