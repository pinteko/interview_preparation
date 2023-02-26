insert into films(title, duration) values
                                       ('Born', '90 minutes'),
                                       ('Avatar', '120 minutes'),
                                       ('Lucy', '90 minutes'),
                                       ('The Last Samurai', '120 minutes'),
                                       ('Interstellar', '120 minutes');

insert into seance(film_id, duration, start_show, price)
values (1, (select duration from films where id = 1), timestamp '2023-02-25 18:00', 2);

insert into seance(film_id, duration, start_show, price)
values (2, (select duration from films where id = 2),
        (select end_show from seance where id = id - 1),
        (select price from seance where id = id - 1) + 1);

/*Работу не доделал. Идея в том, чтобы автоматически брать предыдущее значение
  окончания сеанса, и начинать следующий только после пред.значения,
  дабы избежать накладывания друг на друго по времени.
  В последних инсертах я пытался обратиться к предыдущей строке,
  это не работает, не знаю как реализовать... и возможно ли это*/
