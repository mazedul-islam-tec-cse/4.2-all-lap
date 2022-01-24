#include<iostream>
using namespace std;


int main()
{
    string input;
    cout<<"input : "<<endl<<"\t";
    getline(cin,input);

    int size;
    size=input.size();

    int arrayOut[size];
    int m=1,z=0;
    char first=input[0];

    cout<<endl<<"Output : "<<endl<<"\t";
    for(int i=0;i<size;i++)
    {
        if(first!='\0' && first==input[i+1])
        {
            m++;

        }

        if(first!=input[i+1])
        {
            cout<<first<<m;

            m=1;
            first=input[i+1];
            z=z+1;
        }
    }
    cout<<endl;

}
