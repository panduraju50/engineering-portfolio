# Network Policies Helm Chart

This Helm chart deploys Kubernetes NetworkPolicies based on the configurations defined in `values.yaml`.

It allows for dynamic creation of policies to control ingress traffic to pods within a specified namespace.

## Chart Structure

-   **`Chart.yaml`**: Contains metadata about the chart (version, name, etc.).
-   **`values.yaml`**: Default configuration values for the chart. This is where you define your network policy rules.
-   **`templates/networkpolicy.yaml`**: The main Helm template that generates NetworkPolicy Kubernetes resources.
-   **`templates/_helpers.tpl`**: Contains helper templates for generating labels, names, etc.
-   **`.helmignore`**: Specifies files to ignore when packaging the chart.
-   **`README.md`**: This file, providing an overview of the chart.

## Configuration

The primary way to configure this chart is by modifying the `values.yaml` file or by providing your own values file during installation/upgrade.

### Key Configuration Sections in `values.yaml`:

1.  **`namespace`**: (String) The Kubernetes namespace where these NetworkPolicies will be applied.
2.  **`networkPolicies`**: (Object) Root object containing all policy definitions.
    *   **`allowFromNamespaces`**: (Object) Defines policies that allow ingress from all pods in specified source namespaces to all pods in the target namespace (`.Values.namespace`).
        *   Each key under `allowFromNamespaces` (e.g., `monitoring-stage`) represents a distinct policy set.
            *   `enabled`: (Boolean) Set to `true` to generate this policy.
            *   `fromNamespaces`: (List of Strings) A list of source namespace names.
            *   `ports`: (List of Objects) A list of ports to allow traffic on.
                *   `protocol`: (String) e.g., `TCP`, `UDP`.
                *   `port`: (Integer) Port number.
    *   **`applications`**: (Object) Defines policies targeting specific applications (pods selected by labels) within the target namespace.
        *   **`allowExternalIPblock`**: (Object, Optional) A special configuration to allow traffic from external IP CIDRs to a specific application.
            *   `enabled`: (Boolean) Set to `true` to generate this policy.
            *   `labels`: (Object) Labels to select the target pods (e.g., `app: service-center`).
            *   `targetsIPblocks`: (Object)
                *   `externalSubnets`: (List of Strings) CIDR blocks (e.g., `"0.0.0.0/0"`).
                *   `ports`: (List of Objects) Ports to allow.
        *   **Other keys under `applications`** (e.g., `allowIngress` or your custom application name): Each key represents a set of ingress rules for a specific application (target pods).
            *   `enabled`: (Boolean) Set to `true` to generate policies for this application.
            *   `labels`: (Object) Labels to select the target pods this policy applies to (e.g., `app: service-center`).
            *   `namespace`: (String, Optional) Namespace of the target pods (defaults to `.Values.namespace`).
            *   `with`: (List of Objects) Defines communication rules. Each item in this list creates a separate NetworkPolicy.
                *   `targets`: (Object) Describes the source of allowed traffic.
                    *   `namespace`: (String, Optional) Namespace of the source pods. If different from the target pod's namespace, a `namespaceSelector` will be used. Defaults to the target application's namespace.
                    *   `labels`: (List of Strings) A list of `app` labels for the source pods. Each label will generate a policy allowing traffic from pods with `app: <label-value>`.
                    *   `ports`: (List of Objects) Ports to allow.

## How to Use

### Prerequisites

-   Helm 3 installed.
-   Kubernetes cluster configured with `kubectl`.

### Installation

1.  **Navigate to the chart directory (or use repository if added):**
    ```bash
    cd path/to/kubernetes/helm-charts/network-policies
    ```

2.  **Lint the chart (optional, good practice):**
    ```bash
    helm lint .
    ```

3.  **Perform a dry run (to see what would be generated):**
    ```bash
    helm install my-release . --dry-run --debug -n <target-namespace-from-values-or-override>
    # Example with values from a file:
    # helm install my-release . --dry-run --debug -f my-custom-values.yaml -n <namespace>
    ```

4.  **Install the chart:**
    ```bash
    helm install my-netpols . -n <target-namespace-from-values-or-override>
    # Example: If values.yaml has `namespace: platform`
    # helm install my-netpols . -n platform

    # To override values during installation:
    # helm install my-netpols . -n platform --set networkPolicies.applications.allowExternalIPblock.enabled=false
    ```

### Upgrading the Chart

If you modify the `values.yaml` or the templates:

```bash
helm upgrade my-netpols . -n <target-namespace>
```

### Uninstalling the Chart

```bash
helm uninstall my-netpols -n <target-namespace>
```

## Templating Logic Overview

-   **Section 1 (`allowFromNamespaces`):** Creates policies allowing all pods in specified `fromNamespaces` to communicate with all pods in the `{{ .Values.namespace }}` on given ports.
-   **Section 2 (`allowExternalIPblock`):** Creates a policy allowing traffic from specified `externalSubnets` to pods matching `labels.app` within `{{ .Values.namespace }}` on given ports.
-   **Section 3 (Other `applications`):** For each enabled application configuration under `networkPolicies.applications` (excluding `allowExternalIPblock`):
    -   It iterates through the `labels` of the *target* application (the pod group the policy is for).
    -   It then iterates through the `with` array, which defines *sources*.
    -   For each source defined in `with.targets.labels`, it creates a NetworkPolicy.
    -   This policy allows ingress to the *target* pods (selected by `applications.<appKey>.labels`) from *source* pods (selected by `with.targets.labels.app` and `with.targets.namespace`).

This structure allows for granular control over ingress traffic based on namespaces and pod labels. Ensure your pod deployments have the corresponding labels for these policies to take effect.
