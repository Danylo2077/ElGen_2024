# Docker Compose Spring Boot + MySQL
## Getting Started
**Install Docker** (skip this step if you already have Docker)

Install Docker[https://docs.docker.com/install/]

How to install Docker on Ubuntu[https://docs.docker.com/engine/install/ubuntu/]

**Create the docker group**
```
sudo groupadd docker
sudo usermod -aG docker $USER
```
Reboot system to apply changes

## Prepare

```
git clone git@github.com:Danylo2077/ElGen_2024.git
```
```bash
сd ElGen_2024
git checkout DevOps
cat .env.example >> .env
```

Update variables to your needs.
## Install Project
Run docker containers
```
docker compose up -d
```
