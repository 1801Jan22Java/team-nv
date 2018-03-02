import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { JoinGroupTableComponent } from './join-group-table.component';

describe('JoinGroupTableComponent', () => {
  let component: JoinGroupTableComponent;
  let fixture: ComponentFixture<JoinGroupTableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ JoinGroupTableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(JoinGroupTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
