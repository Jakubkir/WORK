package com.test.Atipera;

import org.springframework.web.bind.annotation.*;

import java.net.http.HttpHeaders;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1")
public class GitHubController {

    private final GitHubQueryHandler gitHubQueryHandler;

    public GitHubController( GitHubQueryHandler gitHubQueryHandler) {
        this.gitHubQueryHandler = gitHubQueryHandler;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/user/{userName}")
    public GitHubResponse getRepository(@PathVariable String userName, @RequestHeader(HttpHeaders.Accept)acceptHeader) {

        if( acceptHeader == "application/xml") {
            return new GitHubResponse("406", "Invalid http header. Accept: application/xml. Valid value: application/json", null);
        }

        return gitHubRepository.GetRepository();
    }

}