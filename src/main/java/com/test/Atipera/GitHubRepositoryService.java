package com.test.Atipera;

import org.springframework.stereotype.Repository;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GitHubRepositoryService {
    private final GitHubBrancheService gitHubBrancheService;

    public GitHubRepositoryService(GitHubBrancheService gitHubBrancheService) {
        this.gitHubBrancheService = gitHubBrancheService;
    }

    public <Gson> GitHubResponse getRepository(String userName) {

        String url = String.format("https://api.github.com/users/%s/repos", userName);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = (HttpResponse<String>) client.sendAsync(request, HttpResponse.BodyHandlers.ofString());

        if(response == null)  return null;

        // https://github.com/google/gson
        Gson g = new Gson();
        List<Repository> gitHubRepository = g.fromJson(response, Repository.class);
        List<Repository> gitHubRepositoryWithOutForks = gitHubRepository.stream().filter(o -> o.fork == false).collect(Collectors.toList());

        List<GitHubDetails> gitHubDetails = new ArrayList<GitHubDetails>();
        for (Repository repo : gitHubRepositoryWithOutForks)
        {
            List<Branch> branches = gitHubBrancheService.getBranches(userName, repo.name);

            if(branches == null) {
                gitHubDetails.add(new GitHubDetails(repo.name, repo.owner.login, null));
                continue;
            }

            List<BranchDetails> branchDetails = new ArrayList<BranchDetails>();

            for (Branch branch : branches)
            {
                branchDetails.add(new BranchDetails(branch.name, branch.commit.sha));
            }

            gitHubDetails.add(new GitHubDetails(repo.name, repo.owner.login, branchDetails));

        }

        return new GitHubResponse("200", "", gitHubDetails);
    }
}

