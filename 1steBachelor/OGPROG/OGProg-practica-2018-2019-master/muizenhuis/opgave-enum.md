# State Design Pattern (met enums)

Vertrek van een copie van je oplossing van de [state design pattern-oefening](opgave.md). Pas ze
aan zodat de interface *Toestand* vervangen wordt door
een opsomtype (`enum1`) met dezelfde naam, waarvan elk van de toestanden
een element is (`BASIS`, `LINKS_START`, …)

* Gebruik een opsomtype waarbij het gedrag van elk van de elementen verschilt, 
zoals bij het *Modus*-voorbeeld uit de cursusnota's, of *SortChoice* 
uit het *Mail*-voorbeeld (versie 3).

* Vervang in de constructor van *MuizenhuisCompanion* de lijn

      toestand = new Toestanden.Basis();
      
  door
  
      toestand = Toestand.BASIS;
      
  Voor de rest laat je alle gegeven klassen ongewijzigd.    
 
* Zorg ervoor dat de code gemeenschappelijk is voor alle toepassingen - het verwerken
van de invoer die 'niets doet' - niet telkens moet worden herhaald.         

* Je kan de meeste code die nu in de klasse *Toestanden* staat, recycleren in de nieuwe versie. Uiteindelijk
heb je de klasse *Toestanden* niet meer nodig. 

Als je vooraf goed nadenkt over wat je allemaal moet wijzigen, heb je voor deze opgave
niet meer dan 20 minuten nodig.



 