#include<iostream>
#include<vector>
#include<algorithm>
#include<memory.h>
using namespace std;

vector<int> adj[10004];
int visited[10004];
int mx, n, m ,a ,b;
int arr[10004];

int dfs(int here) {
	visited[here] = 1;
	int ret = 1;
	for (auto there : adj[here]) {
		if (visited[there]) continue;
		ret += dfs(there);
	}
	return ret;
}

int main() {
	cin >> n >> m;
	while (m--) {
		cin >> a >> b;
		adj[b].push_back(a);
	}
	for (int i = 1; i <= n; i++) {
		memset(visited, 0, sizeof(visited));
		arr[i] = dfs(i);
		mx = max(arr[i], mx);
	}
	for (int i = 1; i <= n; i++) {
		if (arr[i] == mx) cout << i << " ";
	}

	return 0;
}
