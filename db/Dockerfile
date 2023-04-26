FROM ubuntu:22.04 AS builder

WORKDIR /usr/src/work

COPY ddl ./ddl
RUN touch schema.sql
RUN for file in `ls -1 ./ddl/*.sql`; do cat $file >> schema.sql; done

COPY dml ./dml
RUN touch data.sql
RUN for file in `ls -1 ./dml/*.sql`; do cat $file >> data.sql; done

RUN cat schema.sql - data.sql > init.sql

FROM mariadb:10.11

COPY --from=builder /usr/src/work/init.sql /docker-entrypoint-initdb.d
