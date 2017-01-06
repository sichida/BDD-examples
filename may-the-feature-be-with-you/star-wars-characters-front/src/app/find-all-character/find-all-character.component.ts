import { Component, OnInit } from '@angular/core';
import {StoryCharacterService} from "../service/story-character.service";
import {StoryCharacter} from "../entity/story-character";

@Component({
  selector: 'app-find-all-character',
  templateUrl: './find-all-character.component.html',
  styleUrls: ['./find-all-character.component.css']
})
export class FindAllCharacterComponent implements OnInit {
  private characters:Array<StoryCharacter> = new Array<StoryCharacter>();

  constructor(private storyCharacterService:StoryCharacterService) { }

  ngOnInit() {
     this.storyCharacterService.findAll()
       .subscribe(result => this.characters.push(...result));
  }

}
