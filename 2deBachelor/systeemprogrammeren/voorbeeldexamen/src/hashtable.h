#ifndef HASHTABLE_H_
#define HASHTABLE_H_

#define MAX_LIST_LENGTH 2
#define REHASHINCREASEFACTOR 2

typedef struct ht_entry {
	char* key;
	void* value;
	struct ht_entry* next;
} ht_entry;

typedef struct hashtable {
	ht_entry** ht_array;
	int ht_array_length;
	int* list_length_array;
} hashtable;

/* Initialiseert de hashtabel met gegeven grootte */
hashtable* ht_create(int capacity);

/* Geeft het geheugen ingenomen door de hashtabel vrij. */
void ht_free(hashtable** ht);

/* Voegt een entry toe in de hashtabel, maakt een diepe kopie van de key en een ondiepe kopie van de value. Indien aantal elementen in een linked list > MAX_LIST_LENGTH, voer een rehash uit */
/* Return waarde: 1 indien element toegevoegd, -1 indien mislukt, 0 indien de key al bestond. In dit laatste geval pas je niets aan in de hashtabel.*/
int ht_add_entry(hashtable* ht, const char* key, void* value);

/* verwijdert een entry uit de hashtabel met sleutel key */
/* Return waarde: 1 indien element verwijderd, -1 indien mislukt, 0 indien key niet gevonden.*/
int ht_remove_entry(hashtable* ht, const char* key);

/* Print per rij het rijnummer, gevolgd door de keys en hun corresponderende value-adressen in die rij. */
void ht_print(const hashtable* ht);

/* Slaat in hte de pointer op die wijst naar de ht_entry met opgegeven key. */
/* Return waarde: 0 indien gelukt, -1 indien de key niet bestaat. */
int ht_get_entry(const hashtable* ht, const char* key, ht_entry** hte);

int ht_rehash(hashtable* ht);

unsigned int ht_hash(const char* key);

#endif
