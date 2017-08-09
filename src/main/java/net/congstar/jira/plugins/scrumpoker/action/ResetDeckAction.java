package net.congstar.jira.plugins.scrumpoker.action;

import net.congstar.jira.plugins.scrumpoker.data.ScrumPokerStorage;

/**
 * Start a new Scrum poker session and discard all cards previously presented by users.
 */
public class ResetDeckAction extends ScrumPokerAction {

    private static final long serialVersionUID = 1L;

    private final ScrumPokerStorage scrumPokerStorage;

    public ResetDeckAction(ScrumPokerStorage scrumPokerStorage) {
        this.scrumPokerStorage = scrumPokerStorage;
    }

    @Override
    protected String doExecute() throws Exception {
        String issueKey = getHttpRequest().getParameter(PARAM_ISSUE_KEY);
        scrumPokerStorage.sessionForIssue(issueKey).resetDeck();
        return openScrumPokerForIssue(issueKey);
    }

}
