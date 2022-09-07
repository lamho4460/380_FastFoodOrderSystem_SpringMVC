/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Scars
 * Created: 2021/5/6
 */
CREATE TABLE ticket (
 id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
 name VARCHAR(255) NOT NULL,
 subject VARCHAR(255) NOT NULL,
 body VARCHAR(255) NOT NULL,
 quantity boolean,
 price float,
 PRIMARY KEY (id)
);

CREATE TABLE comment (commentid INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),name VARCHAR(50) NOT NULL, id INT NOT NULL, comment VARCHAR(255) NOT NULL,
PRIMARY KEY(commentid),
FOREIGN KEY (name) REFERENCES users(username),
FOREIGN KEY (ID) REFERENCES ticket(id)
);