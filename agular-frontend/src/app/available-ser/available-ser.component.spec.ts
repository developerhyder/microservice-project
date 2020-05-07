import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AvailableSerComponent } from './available-ser.component';

describe('AvailableSerComponent', () => {
  let component: AvailableSerComponent;
  let fixture: ComponentFixture<AvailableSerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AvailableSerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AvailableSerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
