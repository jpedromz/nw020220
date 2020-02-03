import { CellCustomComponentComponent } from './../cell-custom-component/cell-custom-component.component';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Paciente } from './../model/paciente';
import { Especialidade } from './../model/especialidade';
import { PlanoDeSaude } from './../model/plano-de-saude';
import { Component, OnInit } from '@angular/core';
import { PacienteService } from '../services/paciente.service';

@Component({
  selector: 'app-paciente',
  templateUrl: './paciente.component.html',
  styleUrls: ['./paciente.component.scss']
})
export class PacienteComponent {

  gridApi;

  especialidades: Array<Especialidade> = [
    {id: 1, nome: 'Clínica'},
    {id: 2, nome: 'Ortopedia'},
    {id: 3, nome: 'Urologia'}
  ];

  planos: Array<PlanoDeSaude> = [
    {id: 1, nome: 'Unimed'},
    {id: 2, nome: 'Amil'}
  ];

  pacientes: Array<Paciente> = [
    {id: 1,  nomePaciente: 'Jose da Silva', planoDeSaude: this.planos[0], especialidade: this.especialidades[2]},
    {id: 2,  nomePaciente: 'Regiana Duarte', planoDeSaude: this.planos[1], especialidade: this.especialidades[1]},
    {id: 3,  nomePaciente: 'Carlos Drummond', planoDeSaude: this.planos[0], especialidade: this.especialidades[1]},
    {id: 4,  nomePaciente: 'Cecília Meireles', planoDeSaude: this.planos[1], especialidade: this.especialidades[0]},
    {id: 5,  nomePaciente: 'Paula Santos', planoDeSaude: this.planos[1], especialidade: this.especialidades[0]},
    {id: 6,  nomePaciente: 'Anderson Silva', planoDeSaude: this.planos[0], especialidade: this.especialidades[1]},
    {id: 7,  nomePaciente: 'Maria do Carmo', planoDeSaude: this.planos[0], especialidade: this.especialidades[1]},
  ];

  rowData = this.pacientes;
  columnDefs = [
    {headerName: 'Id.', field: 'id', sortable: true },
    {headerName: 'Nome', field: 'nomePaciente', sortable: true, filter: true },
    {headerName: 'Plano de Saúde', field: 'planoDeSaude', sortable: true, filter: true,
      cellEditor: 'agSelectCellEditor',
      cellEditorParams: {
        values: this.extractValues(this.planos)
      },
      valueFormatter: (params) => {
          return params.value.nome;
      },
      valueParser: (params) => {
          return this.planos.find((p: { nome: any; }) => p.nome === params);
      }
   },
    {headerName: 'Especialidade', field: 'especialidade', sortable: true, filter: true,
      cellEditor: 'agSelectCellEditor',
      cellEditorParams: {
        values: this.especialidades.map(e => e.nome)
      },
      valueFormatter: (params) => {
          return params.value.nome;
      },
      valueParser: (params) => {
          return this.especialidades.find(p => p.nome === params);
      }
    },
    { headerName: 'Actions', field: 'action', cellRendererFramework: CellCustomComponentComponent }
  ];

  gridOptions = {
    defaultColDef: {
        editable: true,
        resizable: true
    },
    columnDefs: this.columnDefs,
    rowData: this.pacientes
  };

  constructor(private snackBar: MatSnackBar, pacienteService: PacienteService) {
    pacienteService.getPacientes().subscribe((pacientes: Paciente[]) => {
      this.rowData = pacientes;
    });
  }

  onBtRemove() {
    let selectedRows = this.gridApi.getSelectedNodes();
    if (!selectedRows || selectedRows.length === 0) { return; }

    const selectedRow = selectedRows[0];

    this.pacientes.splice(selectedRow.rowIndex, 1);

    this.gridApi.purgeServerSideCache();
}

onBtAdd() {
    let selectedRows = this.gridApi.getSelectedNodes();
    if (!selectedRows || selectedRows.length === 0) { return; }

    const selectedRow = selectedRows[0];

    // insert new row in the source data, at the top of the page
    this.pacientes.splice(selectedRow.rowIndex, 0, new Paciente());

}

onSaveBtn() {

}


onGridReady(params) {
  this.gridApi = params.api;
}

openSnackBar(message: string, action: string) {
  this.snackBar.open(message, action, {
    duration: 2000,
  });
}

extractValues(mappings) {
  return this.planos.map(plano => plano.nome);
  }

}
