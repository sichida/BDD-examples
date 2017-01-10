import {Routes} from "@angular/router";
import {CreateCharacterComponent} from "./create-character/create-character.component";
import {FindAllCharacterComponent} from "./find-all-character/find-all-character.component";
import {ImportCharacterComponent} from "./import-character/import-character.component";

export const appRoutes: Routes = [
  {path: '', component: FindAllCharacterComponent},
  {path: 'new', component: CreateCharacterComponent},
  {path: 'import', component: ImportCharacterComponent}
];
