CREATE TABLE users (
    id integer(11) auto_increment primary key,
    name varchar(100) not null,
    email varchar(100) not null
);

CREATE TABLE posts (
    id integer(11) auto_increment primary key,
    title varchar(255) not null,
    description TEXT,
    user_id integer(11) not null
);

ALTER TABLE posts ADD CONSTRAINT FK_POST_USER FOREIGN KEY (user_id) references users(id);
