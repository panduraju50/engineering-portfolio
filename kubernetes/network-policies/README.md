# Kubernetes Network Policies

This directory contains specific NetworkPolicy manifest files.

For a general overview of Network Policies and how they are used in this project, please see the [main Network Policy documentation](../../network-policy/README.md).

## Sample Policies included here:

*   Refer to policies in the top-level `network-policy` directory or copy/link them here.
    *   `default-deny-all.yaml`: A policy to deny all ingress and egress traffic by default in a namespace.
    *   `allow-frontend-to-backend.yaml`: An example policy allowing frontend pods to communicate with backend pods, and backend pods to a database.

You can apply these policies using `kubectl apply -f <filename>.yaml -n <namespace>`.

Remember to tailor these policies (namespaces, labels, ports) to your specific application deployment.
