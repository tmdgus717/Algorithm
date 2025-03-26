#include<bits/stdc++.h>
using namespace std;
//분할정복 문제 -> 재귀 or 스택 : 큰 문제를 하위문제로 쪼갠다. 
//쿼드트리 
//typedef long long int ll;
int n;
string s;
char a[104][104];


string quard(int size, int y, int x){
	if(size == 1) return string(1,a[y][x]);
	char b = a[y][x];
	string ret="";
	for(int i = y; i < y + size; i++){
		for(int j = x; j < x + size; j++){
			if(b != a[i][j]){
				ret += "(";
				ret += quard(size/2,y,x);
				ret += quard(size/2,y,x+size/2);
				ret += quard(size/2,y+size/2,x);
				ret += quard(size/2,y+size/2,x+size/2);
				ret += ")";
				return ret;
			}		
		}
	}
	return string(1,a[y][x]);
	
}

int main(){
	cin >> n;
	for(int i = 0; i < n; i++){
		cin >> s;
		for(int j = 0; j < s.size(); j++){
			a[i][j] = s[j];
		}
	}	
	
	cout << quard(n,0,0) <<"\n";
	return 0;
}