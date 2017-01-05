/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { StoryCharacterService } from './story-character.service';

describe('StoryCharacterService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [StoryCharacterService]
    });
  });

  it('should ...', inject([StoryCharacterService], (service: StoryCharacterService) => {
    expect(service).toBeTruthy();
  }));
});
