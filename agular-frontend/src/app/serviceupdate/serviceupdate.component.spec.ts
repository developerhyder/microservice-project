import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ServiceupdateComponent } from './serviceupdate.component';

describe('ServiceupdateComponent', () => {
  let component: ServiceupdateComponent;
  let fixture: ComponentFixture<ServiceupdateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ServiceupdateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ServiceupdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
