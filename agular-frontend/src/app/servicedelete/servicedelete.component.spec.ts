import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ServicedeleteComponent } from './servicedelete.component';

describe('ServicedeleteComponent', () => {
  let component: ServicedeleteComponent;
  let fixture: ComponentFixture<ServicedeleteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ServicedeleteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ServicedeleteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
