{{/*
Common labels
*/}}
{{- define "network-policies.labels" -}}
helm.sh/chart: {{ include "network-policies.chart" . }}
{{ include "network-policies.selectorLabels" . }}
{{- if .Chart.AppVersion }}
app.kubernetes.io/version: {{ .Chart.AppVersion | quote }}
{{- end }}
app.kubernetes.io/managed-by: {{ .Release.Service }}
{{- end -}}

{{/*
Selector labels
*/}}
{{- define "network-policies.selectorLabels" -}}
app.kubernetes.io/name: {{ include "network-policies.name" . }}
app.kubernetes.io/instance: {{ .Release.Name }}
{{- end -}}

{{/*
Create chart name and version as used by the chart label.
*/}}
{{- define "network-policies.chart" -}}
{{- printf "%s-%s" .Chart.Name .Chart.Version | replace "+" "_" | trunc 63 | trimSuffix "-" -}}
{{- end -}}

{{/*
Create a default fully qualified app name.
We truncate at 63 chars because some Kubernetes name fields are limited to this (by the DNS naming spec).
If release name contains chart name it will be used as a full name.
*/}}
{{- define "network-policies.fullname" -}}
{{- if .Values.fullnameOverride -}}
{{- .Values.fullnameOverride | trunc 63 | trimSuffix "-" -}}
{{- else -}}
{{- $name := default .Chart.Name .Values.nameOverride -}}
{{- if contains $name .Release.Name -}}
{{- .Release.Name | trunc 63 | trimSuffix "-" -}}
{{- else -}}
{{- printf "%s-%s" .Release.Name $name | trunc 63 | trimSuffix "-" -}}
{{- end -}}
{{- end -}}
{{- end -}}

{{/*
Generate a name for a network policy.
Input: A map with "name" key for the base name.
Example: {{ include "network-policies.policyName" (dict "name" "allow-ingress") }}
*/}}
{{- define "network-policies.policyName" -}}
{{- printf "%s-%s" (include "network-policies.fullname" .) .name | trunc 63 | trimSuffix "-" -}}
{{- end -}}
