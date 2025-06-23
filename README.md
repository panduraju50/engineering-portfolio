# Full Stack & SRE Automation Engineer Portfolio

Welcome to my portfolio project! This repository showcases a variety of skills relevant to a Full Stack Developer and Site Reliability Engineer (SRE), with a particular focus on Kubernetes, CI/CD, and automation.

## Project Overview

This project aims to demonstrate:

*   **Frontend Development:** (Placeholder for a simple web application)
*   **Backend Development:** (Placeholder for a supporting API)
*   **Kubernetes:** Deployment manifests, service definitions, and crucially, **Network Policies**.
*   **CI/CD Automation:** Example pipelines using GitHub Actions and Jenkins.
*   **Infrastructure as Code (IaC) Principles:** Managing configurations through code.

## Table of Contents

*   [Project Structure](#project-structure)
*   [Frontend](#frontend)
*   [Backend](#backend)
*   [Kubernetes Configuration](#kubernetes-configuration)
    *   [Network Policies](./network-policy/README.md)
    *   [Network Policies Helm Chart](./kubernetes/helm-charts/network-policies/README.md)
*   [CI/CD Pipelines](#cicd-pipelines)
    *   [GitHub Actions](./.github/workflows/README.md)
    *   [Jenkins](./jenkins/README.md)
*   [How to Use](#how-to-use)
*   [Future Enhancements](#future-enhancements)

## Project Structure

The repository is organized as follows:

```
.
├── .github/
│   └── workflows/        # GitHub Actions CI/CD pipelines
│       ├── ci.yml
│       └── README.md
├── backend/              # Backend application code
│   ├── main.py
│   ├── requirements.txt
│   └── .gitkeep
├── frontend/             # Frontend application code
│   ├── app.js
│   ├── index.html
│   ├── style.css
│   └── .gitkeep
├── jenkins/              # Jenkinsfile and related CI/CD scripts
│   ├── Jenkinsfile
│   └── README.md
├── kubernetes/           # Kubernetes manifests and configurations
│   ├── configs/
│   │   └── .gitkeep
│   ├── deployments/
│   │   └── .gitkeep
│   ├── helm-charts/
│   │   └── network-policies/       # Helm chart for Network Policies
│   │       ├── Chart.yaml
│   │       ├── values.yaml
│   │       ├── templates/
│   │       │   ├── networkpolicy.yaml
│   │       │   └── _helpers.tpl
│   │       ├── .helmignore
│   │       └── README.md
│   ├── ingresses/
│   │   └── .gitkeep
│   ├── namespaces/
│   │   └── .gitkeep
│   ├── network-policies/ # Specific K8s Network Policy YAMLs (can link to /network-policy)
│   │   ├── README.md
│   │   └── .gitkeep
│   ├── services/
│   │   └── .gitkeep
│   ├── storage/
│   │   └── .gitkeep
│   └── README.md
├── network-policy/       # Dedicated section for Network Policy examples and documentation
│   ├── default-deny-all.yaml
│   ├── allow-frontend-to-backend.yaml
│   └── README.md
└── README.md             # This main README file
```

## Frontend

*   Location: [`./frontend/`](./frontend/)
*   Description: Contains placeholder files for a simple frontend application.
*   Technologies: (HTML, CSS, JavaScript - adaptable to React, Vue, Angular, etc.)

## Backend

*   Location: [`./backend/`](./backend/)
*   Description: Contains placeholder files for a backend API.
*   Technologies: (Python - adaptable to Flask, Django, Node.js/Express, Java/Spring Boot, etc.)

## Kubernetes Configuration

*   Location: [`./kubernetes/`](./kubernetes/)
*   Description: Holds all Kubernetes manifest files (deployments, services, ingresses, configs, etc.).
*   **Network Policies:**
    *   A key focus of this portfolio. Detailed examples and explanations are in the [`./network-policy/README.md`](./network-policy/README.md) section.
    *   Sample YAMLs are provided in [`./network-policy/`](./network-policy/).
    *   The `kubernetes/network-policies/` directory can hold specific instances or link to the main ones.
*   **Helm Charts:**
    *   The primary Helm chart in this project is for managing Network Policies.
    *   Location: [`./kubernetes/helm-charts/network-policies/`](./kubernetes/helm-charts/network-policies/)
    *   See the [Network Policies Helm Chart README](./kubernetes/helm-charts/network-policies/README.md) for detailed usage instructions.

## CI/CD Pipelines

This project includes examples of CI/CD pipelines:

*   **GitHub Actions:**
    *   Location: [`./.github/workflows/`](./.github/workflows/)
    *   See the [GitHub Actions README](./.github/workflows/README.md) for more details.
    *   A sample workflow `ci.yml` provides a basic structure for build, test, and deployment steps.
*   **Jenkins:**
    *   Location: [`./jenkins/`](./jenkins/)
    *   See the [Jenkins README](./jenkins/README.md) for more details.
    *   A sample `Jenkinsfile` outlines a declarative pipeline.

## How to Use

1.  **Clone the repository:**
    ```bash
    git clone <repository-url>
    cd <repository-name>
    ```
2.  **Explore the sections:** Navigate through the directories to see the code and configurations.
3.  **Frontend/Backend:**
    *   Develop the placeholder applications further based on your chosen frameworks.
4.  **Kubernetes:**
    *   Ensure you have a Kubernetes cluster (e.g., Minikube, Kind, Docker Desktop K8s, or a cloud provider's K8s).
    *   Apply manifests: `kubectl apply -f ./kubernetes/namespaces/your-namespace.yaml` (if you create one)
    *   Apply Network Policies:
        *   Manually: `kubectl apply -f ./network-policy/default-deny-all.yaml -n your-namespace`
        *   Via Helm Chart: Navigate to `kubernetes/helm-charts/network-policies/` and use `helm install <release-name> . -n <namespace-defined-in-values>`. See the chart's README for more details.
    *   Deploy applications using `kubectl apply -f ./kubernetes/deployments/` and `./kubernetes/services/`.
5.  **CI/CD:**
    *   **GitHub Actions:** Workflows will trigger automatically on push/pull_request to configured branches.
    *   **Jenkins:** Set up a Jenkins server and configure a new pipeline job pointing to the `Jenkinsfile` in this repository.

## Future Enhancements

*   Develop full-fledged frontend and backend applications.
*   Implement more complex Network Policy scenarios.
*   Integrate with monitoring and logging tools (e.g., Prometheus, Grafana, ELK stack).
*   Add automated security scanning to CI/CD pipelines.
*   Expand Helm charts for full application deployment.
*   Include examples of other SRE practices like SLOs/SLIs, incident management, etc.

---

This portfolio is a living project and will be updated as I explore and implement new concepts. Feel free to browse and provide feedback!
