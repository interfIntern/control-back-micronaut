#!/usr/bin/env bash
docker build . -t mn-control-api
echo
echo
echo "To run the docker container execute:"
echo "    $ docker run -p 8080:8080 mn-control-api"