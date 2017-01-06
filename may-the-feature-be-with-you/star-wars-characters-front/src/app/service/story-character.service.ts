import {Injectable} from "@angular/core";
import {StoryCharacter} from "../entity/story-character";
import {Http, Headers, RequestOptions} from "@angular/http";
import {Observable} from "rxjs";
import "rxjs/Rx";

@Injectable()
export class StoryCharacterService {
  private _headers: Headers;

  constructor(private _http: Http) {
    this._headers = new Headers({'Content-Type': 'application/json'});
  }

  save(character: StoryCharacter): Observable<StoryCharacter> {
    let options = new RequestOptions({headers: this._headers});

    return this._http.post('/api/v1/character', JSON.stringify(character), options)
      .map(res => res.json());
  }

  findAll(): Observable<Array<StoryCharacter>> {
    let options = new RequestOptions({headers: this._headers});

    return this._http.get('/api/v1/character', options)
      .map(res => res.json());
  }
}
