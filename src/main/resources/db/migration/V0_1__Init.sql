CREATE TABLE "user" (
  EMAIL VARCHAR(50) PRIMARY KEY,
  PASSWORD VARCHAR(255) NOT NULL,
  FULLNAME VARCHAR(100),
  ENABLED BOOLEAN,
  AVATAR BYTEA,
  BIRTHDAY TIMESTAMP
)