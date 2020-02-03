import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CellCustomComponentComponent } from './cell-custom-component.component';

describe('CellCustomComponentComponent', () => {
  let component: CellCustomComponentComponent;
  let fixture: ComponentFixture<CellCustomComponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CellCustomComponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CellCustomComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
