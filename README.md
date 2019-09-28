# CarRentalWebApp
  Aplicatia este dezvoltata folosind sistemul de build Maven in Eclipse, are la baza notiuni de OOP, Servlets, JSP, MVC, MySQL, Hibernate,
Joda-Time, HTML, CSS si functioneaza dupa cum urmeaza:

  Ca entitati, aplicatia are Admin, Client, Car si Reservation.
  
  Pe pagina de start, user-ul se poate loga sau isi poate crea un cont nou daca nu are deja unul. In functie de credentialele introduse, 
user-ul va fi redirectionat spre pagina de client sau de administrator (ori inapoi pe pagina de logare, daca nu sunt corecte 
credentialele).

  Admin-ul poate sa adauge masini noi, sa stearga masini existente, sa vizualizeze toti clientii, masinile companiei si istoricul complet
al tuturor rezervarilor.

  Clientul va putea sa introduca data de start si de final a rezervarii si va putea selecta dintr-un dropdown masina dorita. Daca datele
de inceput si de sfarsit ale rezervarii nu sunt valide din punct de vedere al formatului, clientul este atentionat despre aceasta si 
este rugat sa reintroduca datele respectand formatul. Daca aceste date sunt valide, aplicatia va verifica in continuare daca masina 
selectata este disponibila in intervalul dorit de client. Daca masina este libera, se va calcula pretul total, rezervarea va fi ulterior
salvata in baza de date iar clientului i se va afisa un mesaj corespunzator. Daca masina nu este disponibila, clientul va primi un mesaj
in acest sens si i se vor propune alte masini care sunt disponibile in perioada dorita (daca exista alte masini libere). De asemenea, 
clientul va putea sa-si stearga rezervarea, daca solicita acest lucru cu cel putin 72 ore inainte de data de inceput a rezervarii si i 
se va afisa un mesaj corespunzator in functie de situatie. 

  Nu in ultimul rand, daca user-ul incearca sa acceseze orice pagina care nu este publica, va fi redirectionat catre pagina de Login. 
  
  Daca user-ul nu doreste sa continue, va avea de asemenea la dispozitie optiunea de logout in paginile prinicipale din aplicatie.
