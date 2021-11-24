#include "stdlib.h"
#include <stdio.h>
#include <math.h>

//hashes.c

int hash1 (int clave){
	return clave % 16;

}

int hash2(char *s, int M) {
  
  long sum = 0, mul = 1;

  for (int i = 0; s[i]!='\0'; i++) {
    mul = (i % 4 == 0) ? 1 : mul * 256;
    sum += s[i] * mul;
  }
  return (int)(labs(sum) % M);
}


int main(int argc, char const *argv[])
{
	/* code */
	printf("hash 1 de la clave %i \n", hash1(56));
	printf("hash 2 de la clave %i \n", hash2("Luis Marin", 54));

	return 0;
}