import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewAlarm } from './new-alarm';

describe('NewAlarm', () => {
  let component: NewAlarm;
  let fixture: ComponentFixture<NewAlarm>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [NewAlarm]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NewAlarm);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
