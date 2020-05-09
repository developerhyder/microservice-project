import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ServiceaddComponent } from './serviceadd.component';

describe('ServiceaddComponent', () => {
  let component: ServiceaddComponent;
  let fixture: ComponentFixture<ServiceaddComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ServiceaddComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ServiceaddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
