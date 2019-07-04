/*
* Dijkstra算法，求有向图G的某一个起始点V0到其余顶点V的最短路径P[V] 以及路径长度D[V]
* 
*
*/

#define MAXVEX 9 //定义9个顶点
#define INFINITY 65535 //用INFINITY来定义两个顶点之间不连接

typedef int Patharc[MAXVEX]; //存储最短路径下标的数组 -> 顶点？
typedef int ShortPathTable[MAXVEX]; //存储到各个顶点最短路径的权重之和，最短长度

Void ShortestPath_Dijkstra (MGraph G, int V0, Patharc *P, ShortPathTable *D) {

	int V, w, k, min;
	bool final[MAXVEX]; //final[w] = 1表示已经求得V0到Vw最短路径
	
	for (V = 0; V < G.numVertexes; V++) {
		final[V] = 0;
		(*D)[V] = G.arc[V0][V];
		(*P)[V] = 0;
	}

	(*D)[V0] = 0; //V0 到自身的路径为0 
	final[V0] = TRUE; //V0 到V0不需要求出最短路径，直接得到final的值

	for (V = 1; V < G.numVertexes; V++) {
		min = INFINITY;
		for (w = 0; w < G.numVertexes; w++) {
			if (!final[w] && (*D)[w] < min) {
				k = w;
				min = (*D)[w];
			}
		}
		final[k] = TRUE;
		//如果经过 V顶点的路径比当前路径更短，则更新当前路径
		for (w = 0; w < G.numVertexes; w++) {
			if (!final[w] && (min + G.arc[k][w] < (*D)[w])) {
				(*D)[w] = min + G.arc[k][w];
				(*P)[w] = k;
			}
		}
	}
}