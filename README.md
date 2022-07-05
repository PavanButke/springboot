# copoun-security

## Endpoints

How to Generate Token
[POST] http://localhost:9011/token 
{
    "username": "Admin",
    "password": "Admin"
}

Hit the send ; You'll get token.

How to use this token to access all coupons available in DB?

copy the token

go in Headers in Key: Authorization and in Value: Bearer Paste_Generated_Token

[GET] http://localhost:9011/copoun-api/copouns/

