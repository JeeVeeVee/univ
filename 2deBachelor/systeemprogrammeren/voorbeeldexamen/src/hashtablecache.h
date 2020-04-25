#ifndef HASHTABLE_CACHE_H_
#define HASHTABLE_CACHE_H_

typedef struct htcache_entry {
	char* key;
	void* value;
} htcache_entry;

typedef struct hashtablecache {
	htcache_entry** ht_array;
	int ht_array_length;
} hashtablecache;

/* Initialiseert de hashtabel cache met gegeven grootte */
hashtablecache* htcache_create_capacity(int p_Capacity);

/* Geeft het geheugen ingenomen door de hashtabel cache vrij. */
void htcache_free(hashtablecache** ht);

/* Voegt een entry toe in de hashtabel cache, maakt een diepe kopie van de key en een ondiepe kopie van de value! */
/* Return waarde: 1 indien element toegevoegd, -1 indien mislukt, 0 indien de key al bestond. In dit laatste geval pas je niets aan in de hashtabel cache.*/
int htcache_add_entry(hashtablecache* ht, const char* key, void* value, void** removed_value);

/* verwijdert een entry uit de hashtabel cache */
/* Return waarde: 1 indien element verwijderd, -1 indien mislukt, 0 indien key niet gevonden.*/
int htcache_remove_entry(hashtablecache* ht, const char* key);

/* Print per rij het rijnummer, gevolgd door de key en hun corresponderende value in die rij. */
void htcache_print(const hashtablecache* ht);

/* Slaat in hte de pointer op die wijst naar de htcache_entry met opgegeven key. */
/* Return waarde: 0 indien gelukt, -1 indien de key niet bestaat. */
int htcache_get_entry(const hashtablecache* ht, const char* key, htcache_entry** hte);

unsigned int htcache_hash(const char* key);

#endif
