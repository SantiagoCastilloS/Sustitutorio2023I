import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InsertarCuponComponent } from './insertar-cupon.component';

describe('InsertarCuponComponent', () => {
  let component: InsertarCuponComponent;
  let fixture: ComponentFixture<InsertarCuponComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InsertarCuponComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InsertarCuponComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
