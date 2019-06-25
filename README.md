# Analysis of GitHub repositories activities  
 
GitHub offers a public REST API and a developer dedicated Web site (https://developer.github.com/v3/) that contains documentation and examples of using this API. 
 
This project uses Github API for following requirements:

 1. A user can search for a public project (also called repository) hosted on theGitHub platform.
 
 2. The user will choose one of the projects returned by the search.
 
 3. The Analyzer application would show three basic types of analytics for the selected project:
    - List of committers (contributors) for this project.
    - Based on the 100 latest commits, the impact of each user on the project (based on number of commits)
    - Based on the 100 latest commits, the projection of commits on a timeline.
 
 4. This result page must be bookmark-able for later direct access.

I've used swagger for Rest documentation. You can reach with this address:
http://localhost:8000/swagger-ui.html#/
or 
http://127.0.0.1:8000/v2/api-docs

**Demo:** http://github-repo-analyzer.herokuapp.com/swagger-ui.html#/
