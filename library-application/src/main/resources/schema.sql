create table book (
                       id BIGSERIAL PRIMARY KEY,
                       name varchar(128),
                       author varchar(128),
                       releaseDate DATE,
                       publisher varchar(128)
);

create table magazine (
                      id BIGSERIAL PRIMARY KEY,
                      name varchar(128),
                      author varchar(128),
                      releaseDate DATE,
                      publisher varchar(128)
);

create table newspaper (
                      id BIGSERIAL PRIMARY KEY,
                      name varchar(128),
                      author varchar(128),
                      releaseDate DATE,
                      publisher varchar(128)
);



/*DROP table book;
DROP TABLE magazine;
DROP TABLE newspaper;*/
