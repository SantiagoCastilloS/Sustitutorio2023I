import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReporteCompraClientesComponent } from './reporte-compra-clientes.component';

describe('ReporteCompraClientesComponent', () => {
  let component: ReporteCompraClientesComponent;
  let fixture: ComponentFixture<ReporteCompraClientesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReporteCompraClientesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ReporteCompraClientesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
