FROM ubuntu
ENV DEBIAN_FRONTEND=noninteractive
RUN apt update \
    && apt install -y git openjdk-21-jdk gradle \
    && git config --global user.name seminify \
    && git config --global user.email seminify@gmail.com
