import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { CreateCharacterComponent } from './create-character/create-character.component';

import {StoryCharacterService} from "./service/story-character.service";

@NgModule({
  declarations: [
    AppComponent,
    CreateCharacterComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule
  ],
  providers: [StoryCharacterService],
  bootstrap: [AppComponent]
})
export class AppModule { }
