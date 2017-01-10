import {Component, OnInit} from "@angular/core";
import {StoryCharacter} from "../entity/story-character";
import {StoryCharacterService} from "../service/story-character.service";
import {Router, ActivatedRoute, Params} from "@angular/router";

@Component({
  selector: 'app-create-character',
  templateUrl: './create-character.component.html',
  styleUrls: ['./create-character.component.css']
})
export class CreateCharacterComponent implements OnInit {
  public character: StoryCharacter;
  public error: any;

  constructor(private storyCharacterService: StoryCharacterService,
              private router: Router,
              private route: ActivatedRoute) {
  }

  ngOnInit() {
    if (this.route.snapshot.params['name']) {
      this.storyCharacterService.get(this.route.snapshot.params['name'])
        .subscribe((character: StoryCharacter) => this.character = character);
    } else {
      this.character = new StoryCharacter();
    }
  }

  register(): void {
    if (this.character.id) {
      this.storyCharacterService.edit(this.character)
        .subscribe(() => this.router.navigate(['/']), error => this.error = error.json());
    } else {
      this.storyCharacterService.save(this.character)
        .subscribe(() => this.router.navigate(['/']), error => this.error = error.json());
    }
  }

}
