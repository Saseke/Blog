CREATE TABLE file(
    id INT  auto_increment PRIMARY KEY ,
    title VARCHAR (100),
    content VARCHAR (1000),
    date DATE
);
CREATE TABLE user(
    id int auto_increment PRIMARY KEY ,
    username VARCHAR (100) NOT NULL ,
    password VARCHAR (100) NOT NULL ,
    description VARCHAR (200) NOT NULL ,
    date TIMESTAMP
);

--     CONSTRAINT username_user FOREIGN KEY (username) REFERENCES  file(user)
