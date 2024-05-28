# ElGen_2024
## Backend
**Before you start working**
1. Clean your DB using ```flyway:clean```
2. Migrate new migration to your DB using ```flyway:migrate```

**Also, use new endpoints:**

POST```localhost:8080/api/auth/signup``` to signUp new user

**JSON**
```json
{
    "username": "yourexample",
    "password": "yourexample",
    "email": "your@example.com"
}
```

POST ```http://localhost:8080/api/auth/signin``` to signIn user

**JSON**
```json
{
    "username": "yourexample",
    "password": "yourexample"
}
```

P.S. remember your passwords because they will be encrypted 😜
