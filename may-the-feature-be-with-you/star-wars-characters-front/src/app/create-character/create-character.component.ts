import {Component, OnInit} from "@angular/core";
import {StoryCharacter} from "../entity/story-character";
import {StoryCharacterService} from "../service/story-character.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-create-character',
  templateUrl: './create-character.component.html',
  styleUrls: ['./create-character.component.css']
})
export class CreateCharacterComponent implements OnInit {
  public character: StoryCharacter;
  public error:any;

  constructor(private storyCharacterService: StoryCharacterService,
              private router: Router) {
  }

  ngOnInit() {
    this.character = new StoryCharacter();
  }

  register(): void {
    this.storyCharacterService.save(this.character)
      .subscribe(() => this.router.navigate(['/']), error => this.error = error.json());
  }

}
