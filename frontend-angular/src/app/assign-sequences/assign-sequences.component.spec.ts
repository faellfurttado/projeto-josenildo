import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AssignSequencesComponent } from './assign-sequences.component';

describe('AssignSequencesComponent', () => {
  let component: AssignSequencesComponent;
  let fixture: ComponentFixture<AssignSequencesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AssignSequencesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AssignSequencesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
