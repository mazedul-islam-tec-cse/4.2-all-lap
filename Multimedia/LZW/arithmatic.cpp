#include<iostream>
#include<string.h>
using namespace std;

int main(){

    char givenSymbol[8] = {'A','B','C','D','E','F','$'};
    double givenLowRange[7] = {0,0.2,0.3,0.5,0.55,0.85,0.9};
    double givenHighRange[7] = {0.2,0.3,0.5,0.55,0.85,0.9,1};

    char inputString[10];

    cout<<"Enter the string : ";
    cin >> inputString;
    cout<<endl;

    double low=0.0, high=1.0, range=1.0;

    int i=0;

    cout << "Symbol\t\t" << "Low\t\t" << "High\t\t" << "Range" << endl;
    cout << "      \t\t" << low << "\t\t"<<high << "\t\t"<<range<<endl;

    while( i < strlen(inputString))
    {
        int j;

        for (j=0; j<strlen(givenSymbol); j++)
        {
            if(inputString[i] == givenSymbol[j])
            {

                break;
            }
        }

        high = low + (range * givenHighRange[j]);
        low = low + (range * givenLowRange[j]);
        range = high - low;

        cout << inputString[i] << "\t\t" << low << "\t\t" << high << "\t\t" << range << endl;

        i++;
    }
}
