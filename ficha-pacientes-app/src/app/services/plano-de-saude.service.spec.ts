import { TestBed } from '@angular/core/testing';

import { PlanoDeSaudeService } from './plano-de-saude.service';

describe('PlanoDeSaudeService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: PlanoDeSaudeService = TestBed.get(PlanoDeSaudeService);
    expect(service).toBeTruthy();
  });
});
