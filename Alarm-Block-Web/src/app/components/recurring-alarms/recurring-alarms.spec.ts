import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RecurringAlarms } from './recurring-alarms';

describe('RecurringAlarms', () => {
  let component: RecurringAlarms;
  let fixture: ComponentFixture<RecurringAlarms>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RecurringAlarms]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RecurringAlarms);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
