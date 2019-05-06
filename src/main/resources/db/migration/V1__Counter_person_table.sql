
    drop table if exists countperson cascade;

    create table countperson(
                    id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
                    name text not null,
                    counter int not null,
                );
