#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
	CREATE DATABASE user;
	CREATE DATABASE fraud;
	CREATE DATABASE notification;
  GRANT ALL PRIVILEGES ON DATABASE user TO uservice;
  GRANT ALL PRIVILEGES ON DATABASE fraud TO uservice;
  GRANT ALL PRIVILEGES ON DATABASE notification TO uservice;
EOSQL
