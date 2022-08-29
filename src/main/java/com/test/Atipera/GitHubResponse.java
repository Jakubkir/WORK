package com.test.Atipera;

import java.util.List;

public class GitHubResponse {


    private String status;
    private String message;
    private List<GitHubDetails> details;

    public GitHubResponse(String status, String message, List<GitHubDetails> details) {
        this.status = status;
        this.message = message;
        this.details = details;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public List<GitHubDetails> getDetails() {
        return details;
    }
}
