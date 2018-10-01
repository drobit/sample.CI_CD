#!/bin/bash -exo pipefail

export KUBECONFIG=/tmp/.kubeconfig
export PROJECT=$(gcloud info --format='value(config.project)')
sed s/PROJECT/$PROJECT/g pipeline-deploy.json | curl -d@- -X \
    POST --header "Content-Type: application/json" --header \
    "Accept: /" http://localhost:8080/gate/pipelines
