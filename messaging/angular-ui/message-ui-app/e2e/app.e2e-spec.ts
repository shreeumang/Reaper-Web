import { MessageUiAppPage } from './app.po';

describe('message-ui-app App', function() {
  let page: MessageUiAppPage;

  beforeEach(() => {
    page = new MessageUiAppPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
