package com.test.Atipera;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class GitHubBrancheService {
    public List<Branch> getBranches(String userName, String repoName) {
        String url = String.format("https://api.github.com/repos/%s/%s/branches", userName, repoName);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = (HttpResponse<String>) client.sendAsync(request, HttpResponse.BodyHandlers.ofString());

        List<Branch> branches = g.fromJson(response, Branch.class);

        if(branches == null || branches.toArray().length == 0)
            return null;

        return branches;
    }
}