# Docker Compose Spring Boot + MySQL
## Getting Started
**Install Docker** (skip this step if you already have Docker)

Install Docker[https://docs.docker.com/install/]

How to install Docker on Ubuntu[https://docs.docker.com/engine/install/ubuntu/]

## Prepare
**! If you use windows, do all preparings in Git Bash, or use Windows Powershell with ```bash``` command.**
```
git clone git@github.com:Danylo2077/ElGen_2024.git
```
```
сd ElGen_2024
```
```
git checkout DevOps
```
```bash
cat .env.example >> .env
```

Update variables to your needs.
## Install Project
Run docker containers
```
docker compose up -d
```
## Prepare database
```bash
sudo apt-get install mysql-client
```

```bash
docker exec -it mysql-db mysql -uroot -proot ElGen
```

**password: root**

```sql
INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_MODERATOR');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');
```
