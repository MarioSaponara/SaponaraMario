#1.Inserimento di un nuovo utente
#INSERT INTO utente (cF, nome, cognome, telefono, dataNascita, luogoNascita, indirizzo, email) VALUES
#				("ERGGJJGKU688768", 'Lucia', 'Bianchi',"1786554467","12/08/1985","Avellino",'via Rocca','lucai@gmail.it');

#2.Visualizzazione delle informazioni anagrafiche e del modello di telefono posseduto
select u.cF, u.nome, u.cognome, u.telefono, u.dataNascita, u.luogoNascita, s.name as Modello from utente as u
inner join smartphone as s on u.cF =s.utente;

#3.Update sia delle informazioni anagrafiche che del telefono

#Query con vado aggiornare il contatto con codice fiscale 3543BOGHFOGFGFK
#e i suoi relativi telefoni posseduti
update utente as u
inner join smartphone as s
on u.cF= s.utente
set u.nome="Marco", u.cognome="Randillo", u.telefono="111223456", u.dataNascita="23/12/1989 ", u.luogoNascita="Riccione", s.ram="23Gb", s.notes="telefono gusto"
where u.cF="3543BOGHFOGFGFK";

#Aggiorno i dati di un determinato utente
update utente 
set telefono="1234567894",indirizzo="via Rossi", email="nuovoindirizzo@gmail.it" 
where cF="DSFO596DRJFGFGK";

#Aggiorno i dati di un determinato telefono
update smartphone 
set ram="3Gb", cpu="3 GHz Quad core CPU", notes="telefono aggiornato"
where id="1";

#4.Visualizzazione delle informazioni relative al telefono
select s.name, s.ram, s.cpu, s.displayPpi, s.displaySize, s.displayResolution, s.size, s.weight, u.cognome, u.nome, u.telefono
from smartphone as s inner join utente as u on u.cF =s.utente order by u.cognome, u.nome;