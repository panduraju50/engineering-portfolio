# Kubernetes Manifests

This directory contains all Kubernetes manifest files (YAMLs) for deploying the application and its related services.

## Structure

- **/namespaces**: Contains namespace definitions.
- **/deployments**: Contains deployment YAMLs for application components.
- **/services**: Contains service YAMLs to expose applications.
- **/ingresses**: Contains ingress YAMLs for external access.
- **/configs**: Contains ConfigMap and Secret definitions.
- **/storage**: Contains PersistentVolume and PersistentVolumeClaim definitions.
- **/network-policies**: Contains NetworkPolicy definitions (this might link to or duplicate from the top-level `network-policy` directory, or be the primary location if preferred).
- **/helm-charts**: This directory will house Helm charts for packaging and deploying applications.
  - **/my-network-policy-chart**: Placeholder for the user-provided Network Policy Helm chart.

This structured approach helps in managing and understanding the various components of the Kubernetes deployment.
