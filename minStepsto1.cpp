#include<iostream>
#include<math.h>

using namespace std;

int minSteps(int ans[], int n){
	if(n==1)
	  return 0;
	
	if(ans[n]!=-1)
	  return ans[n];
	
	int x,y=INT_MAX,z=INT_MAX;
	x = minSteps(ans,n-1);
	if(n%2==0)
	  y = minSteps(ans,n/2);
	if(n%3==0)
	  z = minSteps(ans,n/3);
	ans[n] = 1+min(min(x,y),z);
	return ans[n];
}

int main(){
	int n;
	cin>>n;
	int ans[n+1];
	for(int i=0;i<=n;i++)
	  ans[i]=-1;
	int min_steps =  minSteps(ans,n);
	cout<<min_steps;
	return 0;
}
