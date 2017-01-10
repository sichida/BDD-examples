import {Component, OnInit} from '@angular/core';
import {StoryCharacterService} from "../service/story-character.service";
import {StoryCharacter} from "../entity/story-character";
import {Router} from "@angular/router";

@Component({
  selector: 'app-import-character',
  templateUrl: './import-character.component.html',
  styleUrls: ['./import-character.component.css']
})
export class ImportCharacterComponent implements OnInit {
  public results: Array<StoryCharacter> = new Array<StoryCharacter>();

  constructor(private _storyCharacterService: StoryCharacterService,
              private router: Router) {
  }

  ngOnInit() {
  }

  search(query) {
    this._storyCharacterService.search(query)
      .subscribe(response => {
        this.results.length = 0;
        this.results.push(...response.results);
      });
  }

  import(url: string) {
    this._storyCharacterService.import(url)
      .subscribe(() => this.router.navigate(['/']))
  }

}
