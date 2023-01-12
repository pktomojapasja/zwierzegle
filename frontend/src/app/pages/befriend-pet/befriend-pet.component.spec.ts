import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BefriendPetComponent } from './befriend-pet.component';

describe('BefriendPetComponent', () => {
  let component: BefriendPetComponent;
  let fixture: ComponentFixture<BefriendPetComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BefriendPetComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BefriendPetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
