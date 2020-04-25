#include "hashtablecache.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "../leaker/leaker.h"  // Memory leak checker

hashtablecache* htcache_create_capacity(int p_Capacity){
    //TODO
	return NULL; //for compilation purposes, can be changed
}

void htcache_free(hashtablecache** ht){
	//TODO
}

int htcache_add_entry(hashtablecache* ht, const char* key, void* value, void** removed_value){
	//TODO
	return 0; //for compilation purposes, can be changed
}

int htcache_remove_entry(hashtablecache* ht, const char* key){
	//TODO
	return 0; //for compilation purposes, can be changed
}

int htcache_get_entry(const hashtablecache* ht, const char* key, htcache_entry** hte){
	//TODO
	return 0; //for compilation purposes, can be changed
}

void htcache_print(const hashtablecache* ht){
	//TODO
}

/* hash functie - gegeven */
unsigned int htcache_hash(const char* key){
	unsigned int hash = 0;
	unsigned int i = 0;
	for(i=0; i < strlen(key); i++){
		hash += key[i];
		hash += (hash << 10);
		hash ^= (hash >> 6);
	}
	hash += (hash << 3);
	hash ^= (hash >> 11);
	hash += (hash << 15);
	return hash;
}
