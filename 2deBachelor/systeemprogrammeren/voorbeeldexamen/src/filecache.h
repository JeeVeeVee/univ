#ifndef FILECACHE_H_
#define FILECACHE_H_

#include "hashtablecache.h"

#define FC_DEFAULT_SIZE 8

typedef struct filecache {
	hashtablecache* cache;
	int cachehits;
	int cachemisses;
} filecache;

/* Maakt een filecache aan met capaciteit FC_DEFAULT_SIZE, initialiseert de datastructuur en geeft een pointer naar deze datastructuur terug */
filecache* fc_create();

/* geeft alle geheugen door structuur fc ingenomen, vrij */
void fc_free(filecache** fc);

/* functie zal nagaan indien de inhoud van bestand met bestandsnaam filename zich in de cache bevindt. Indien de inhoud van dit bestand reeds gecached is in meegegeven file cache fc, dan wordt die bestands-inhoud uitgeprint naar het scherm en wordt het aantal cachehits verhoogd. Indien de inhoud zich nog niet in de cache bevindt, dan wordt functie fc_cachemiss opgeroepen en wordt het aantal cachemisses verhoogd.  */
void fc_readFile(filecache* fc, const char* filename);

/* functie die het bestand met bestandsnaam filename zal inlezen vanop schijf, de inhoud van dit bestand uitschrijft naar het scherm en stockeert in de meegegeven file cache fc. Indien het bestand toch niet gevonden wordt, dan zal de functie niets afprinten. */
void fc_cachemiss(filecache* fc, const char* filename);

void fc_print(filecache* fc);

#endif
