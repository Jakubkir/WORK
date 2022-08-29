package com.test.Atipera;

import java.util.List;

public class GitHubQueryHandler {

    private final GitHubRepositoryService gitHubRepositoryService;

    public GitHubQueryHandler(GitHubRepositoryService gitHubRepositoryService) {
        this.gitHubRepositoryService = gitHubRepositoryService;
    }

    public GitHubResponse getRepository(String userName) {
        GitHubResponse gitHubResponse = gitHubRepositoryService.getRepository(userName);

        if(gitHubResponse == null) {
            return new GitHubResponse("404", String.format("Invalid data. Not find data for userName: %s", userName).null)
        }

        return new GitHubResponse("200", "", (List<GitHubDetails>) gitHubResponse);
    }
}