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

CREATE TABLE comments (
    id integer(11) auto_increment primary key,
    commentary text,
    user_id integer(11) not null,
    post_id integer(11) not null
);

ALTER TABLE comments ADD CONSTRAINT FK_COMMENT_USER FOREIGN KEY (user_id) references users(id);
ALTER TABLE comments ADD CONSTRAINT FK_COMMENT_POST FOREIGN KEY (post_id) references posts(id);
