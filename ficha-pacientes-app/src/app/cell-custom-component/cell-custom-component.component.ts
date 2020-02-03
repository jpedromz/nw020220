import { MatSnackBar } from '@angular/material/snack-bar';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-cell-custom-component',
  templateUrl: './cell-custom-component.component.html',
  styleUrls: ['./cell-custom-component.component.scss']
})
export class CellCustomComponentComponent implements OnInit {

  data: any;
  params: any;

  constructor(private snackBar: MatSnackBar) {}

  agInit(params) {
    this.params = params;
    this.data = params.value;
  }

  ngOnInit() {}

  editRow() {
    let rowData = this.params;
    let i = rowData.rowIndex;
    this.openSnackBar('Registro salvo com sucesso!', 'sucesso');
    console.log(rowData);
  }

  deleteRow() {
    let rowData = this.params;
    this.openSnackBar('Registro removido com sucesso!', 'sucesso');
    console.log(rowData);
  }

  openSnackBar(message: string, action: string) {
    this.snackBar.open(message, action, {
      duration: 2000,
    });
  }

}
