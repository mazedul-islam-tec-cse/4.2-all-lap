#include <bits/stdc++.h>
using namespace std;

char d[26][10];

int getcode(char *s)
{
    int i;
    for(i=0;i<26;i++)
    {
        if(strcmp(d[i],s)==0)
            return i+1;
    }
    return 0;
}int main()
{


    FILE *fptr;
    char filename[15];
    char ch;
    char a[4];
    int ii=0;

    /*  open the file for reading */
    fptr = fopen("lzwin.txt", "r");
    if (fptr == NULL)
    {
        printf("Cannot open file \n");

    }
    ch = fgetc(fptr);
    while (ch != EOF)
    {
        //printf ("%c", ch);
        a[ii]=ch;
        ii++;
        ch = fgetc(fptr);
    }



    char s1[10],s2[10],s3[10];
    printf("%s\b\b\b\b     \n",a);
    int i,j,l[26];

    for(i=0;i<26;i++)
        l[i]=0;

    int div = 0;

    if (a[0] >= 'A' && a[0] <= 'Z'){ // for lowercase letter

        div = 65;
        for(i=0;i<strlen(a);i++)
            l[a[i]- 65]++;
    }

     else if (a[0] >= 'a' && a[0] <= 'z'){ // for uppercase letter
        div = 97;
        for(i=0;i<strlen(a);i++)
            l[a[i]- 97]++;
    }

    j=0;
    for(i=0;i<26;i++)
        if(l[i]>0)
        {
            d[j][0]=i+div;
            d[j++][1]='\0';
        }
    for(i=j;i<26;i++)
        d[i][0]='\0';

    i=0;
    s1[0]=a[i++];
    s1[1]='\0';
    strcpy(s2,s1);

    while(a[i]!='\0')
    {
        s2[0]=a[i];
        s2[1]='\0';
        i++;

        strcpy(s3,s1);
        strcat(s3,s2);

        if(getcode(s3)>0)
        {
            strcpy(s1,s3);
            continue;
        }
        else
        {
            strcpy(d[j++],s3);
            printf("%d",getcode(s1));
            strcpy(s1,s2);
        }
    }

    printf("%d\b\b\b\b     \n\n\n",getcode(s2));


    fclose(fptr);
    printf("\n");
}
