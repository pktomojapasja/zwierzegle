import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HowAdoptComponent } from './how-adopt.component';

describe('HowAdoptComponent', () => {
  let component: HowAdoptComponent;
  let fixture: ComponentFixture<HowAdoptComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HowAdoptComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HowAdoptComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
