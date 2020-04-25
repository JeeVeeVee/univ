#include "filecache.h"

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "../leaker/leaker.h"  // Memory leak checker

filecache* fc_create(){
	//TODO
	return NULL; //for compilation purposes, can be changed
}

void fc_free(filecache** fc){
	//TODO
}

void fc_readFile(filecache* fc, const char* filename){
	//TODO
}

void fc_cachemiss(filecache* fc, const char* filename){
	//TODO
}

void fc_print(filecache* fc){
	if(fc!=NULL){
		printf("fc_print %p\n", fc);
		printf("\tcache hits: %d, cache misses: %d\n", fc->cachehits, fc->cachemisses);
		htcache_print(fc->cache);
	}
}
