# Hello World

A small Java sample app (reads a name from stdin, prints a greeting) used as a
minimal end-to-end CI/CD reference project: GitHub Actions build → SonarCloud
quality scan → Docker image build/push.

Repository: https://github.com/mahamtahirx/helloworld-pipeline

## Project structure

```
src/main/java/com/helloworld/HelloWorld.java   # app entry point
src/test/java/com/helloworld/HelloWorldTest.java  # unit tests
pom.xml                                        # Maven build
Dockerfile                                     # multi-stage build/runtime image
.github/workflows/ci-cd.yml                    # CI/CD pipeline
```

## Build & run locally

```bash
mvn clean package
echo "Ehtesham" | java -jar target/helloworld-1.0.0.jar
```

## Run with Docker

```bash
docker build -t helloworld:local .
docker run -it helloworld:local
```

## Branches

- `main` — stable/release branch, deploys from CI on every push.
- `develop` — integration branch for ongoing work; also builds, scans and
  publishes an image on every push, tagged with the branch name.

## CI/CD pipeline

On every push/PR to `main` or `develop`:
1. **Build & test** — `mvn clean verify` (compiles + runs the JUnit tests).
2. **SonarCloud scan** — static code quality/security analysis, gated on
   the `SONAR_TOKEN` repo secret.
3. **Docker build & push** (push events only) — builds the image from the
   `Dockerfile` and pushes it to GitHub Container Registry (GHCR) as
   `ghcr.io/<owner>/helloworld:<branch>` and `:<commit-sha>`.

See the repo setup instructions provided separately for exact commands to
create the GitHub repo, wire up the required secret, and push.
