#include "hashtable.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "../leaker/leaker.h"  // Memory leak checker

hashtable* ht_create(int capacity){
	//TODO
	return NULL; //for compilation purposes, can be changed
}

void ht_free(hashtable** ht){
	//TODO
}

int ht_add_entry(hashtable* ht, const char* key, void* value){
	//TODO
	return 0; //for compilation purposes, can be changed
}

int ht_remove_entry(hashtable* ht, const char* key){
    //TODO
	return 0; //for compilation purposes, can be changed
}

void ht_print(const hashtable* ht){
    //TODO
}

int ht_get_entry(const hashtable* ht, const char* key, ht_entry** hte){
	//TODO
	return 0; //for compilation purposes, can be changed
}

int ht_rehash(hashtable* ht){
	//TODO
	return 0; //for compilation purposes, can be changed
}

/* hash functie - gegeven */
unsigned int ht_hash(const char* key){
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
