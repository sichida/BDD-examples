import { StarWarsCharactersFrontPage } from './app.po';

describe('star-wars-characters-front App', function() {
  let page: StarWarsCharactersFrontPage;

  beforeEach(() => {
    page = new StarWarsCharactersFrontPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
