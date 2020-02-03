import { Especialidade } from './especialidade';
import { PlanoDeSaude } from './plano-de-saude';

export class Paciente {
  id: number;
  nomePaciente: string;
  planoDeSaude: PlanoDeSaude;
  especialidade: Especialidade;
}
