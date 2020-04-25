#include "hashtable.h"
#include "hashtablecache.h"
#include "filecache.h"
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include "../leaker/leaker.h"

void testHashTable(){
	hashtable* ht = ht_create(4);
	ht_entry* testEntry = NULL;
	int testInteger = 666;
	const char* testS1 = "key1";
	const char* testS2 = "key2";
	const char* testS3 = "key3";
	const char* testS4 = "key4";
	const char* testS5 = "key5";
	const char* testS6 = "key6";
	char* test1 = "test1";
	char* test2 = "test2";
	char* test3 = "test3";
	ht_add_entry(ht, testS1, test1);
	ht_print(ht);
	printf("\n");
	ht_add_entry(ht, testS2, test2);
	ht_add_entry(ht, testS3, test3);
	ht_add_entry(ht, testS4, test1);
	ht_add_entry(ht, testS5, &testInteger);
	ht_add_entry(ht, testS6, &testInteger);
	ht_print(ht);
	ht_get_entry(ht, testS1, &testEntry);
	printf("get for key %s yields value: %s \n", testS1, (char*)testEntry->value);
	ht_get_entry(ht, testS5, &testEntry);
	printf("get for key %s yields value: %d \n", testS5, *((int*)testEntry->value));
	ht_remove_entry(ht, testS2);
	ht_remove_entry(ht, testS5);
	ht_remove_entry(ht, testS6);
	ht_print(ht);
	ht_free(&ht);
}

void testHashTableCache(){
	hashtablecache* ht = htcache_create_capacity(8);
	htcache_entry* testEntry = NULL;
	int testInteger = 666;
	char* removedFromCache;
	const char* testS1 = "key1";
	const char* testS2 = "key2";
	const char* testS3 = "key3";
	const char* testS4 = "key4";
	const char* testS5 = "key5";
	const char* testS6 = "key6";
	char* test1 = "test1";
	char* test2 = "test2";
	char* test3 = "test3";
	htcache_add_entry(ht, testS1, test1,(void**)&removedFromCache);
	htcache_print(ht);
	printf("\n");
	htcache_add_entry(ht, testS2, test2,(void**)&removedFromCache);
	htcache_add_entry(ht, testS3, test3,(void**)&removedFromCache);
	htcache_add_entry(ht, testS4, test1,(void**)&removedFromCache);
	htcache_add_entry(ht, testS5, &testInteger,(void**)&removedFromCache);
	htcache_add_entry(ht, testS6, &testInteger,(void**)&removedFromCache);
	htcache_print(ht);
	if(htcache_get_entry(ht, testS1, &testEntry))
		printf("get for key %s yields value: %s \n", testS1, (char*)testEntry->value);
	if(htcache_get_entry(ht, testS5, &testEntry))
		printf("get for key %s yields value: %d \n", testS5, *((int*)testEntry->value));
	htcache_remove_entry(ht, testS2);
	htcache_remove_entry(ht, testS5);
	htcache_remove_entry(ht, testS6);
	htcache_print(ht);
	htcache_free(&ht);
}

void testFileCache(){
	filecache* fc = fc_create();
	fc_readFile(fc,"test1.txt");
	fc_readFile(fc,"test2.txt");
	fc_print(fc);
	fc_readFile(fc,"test3.txt");
	fc_readFile(fc,"test4.txt");
	fc_readFile(fc,"test5.txt");
	fc_readFile(fc,"test6.txt");
	fc_print(fc);
	//duplicate reads
	fc_readFile(fc,"test1.txt");
	fc_readFile(fc,"test5.txt");
	fc_readFile(fc,"test3.txt");
	fc_readFile(fc,"test6.txt");
	fc_readFile(fc,"test4.txt");
	fc_print(fc);
	fc_free(&fc);
}

int main(void) {
	testHashTable();
	testHashTableCache();
	testFileCache();
	return 0;
}
