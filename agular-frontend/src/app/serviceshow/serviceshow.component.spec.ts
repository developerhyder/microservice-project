import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ServiceshowComponent } from './serviceshow.component';

describe('ServiceshowComponent', () => {
  let component: ServiceshowComponent;
  let fixture: ComponentFixture<ServiceshowComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ServiceshowComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ServiceshowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
