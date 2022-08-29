package com.test.Atipera;

import java.util.List;

public class GitHubDetails {
    private String repositoryName;
    private String ownerLogin;
    private List<BranchDetails> branchDetails;

    public GitHubDetails(String repositoryName, String ownerLogin, List<BranchDetails> branchDetails) {
        this.repositoryName = repositoryName;
        this.ownerLogin = ownerLogin;
        this.branchDetails = branchDetails;
    }

    public String getRepositoryName() {
        return repositoryName;
    }

    public String getOwnerLogin() {
        return ownerLogin;
    }

    public List<BranchDetails> getBranchDetails() {
        return branchDetails;
    }
}

