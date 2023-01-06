import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FoundationRegisterComponent } from './foundation-register.component';

describe('FoundationRegisterComponent', () => {
  let component: FoundationRegisterComponent;
  let fixture: ComponentFixture<FoundationRegisterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FoundationRegisterComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FoundationRegisterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
