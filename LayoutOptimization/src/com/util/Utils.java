package com.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.bean.DiameterEdge;
import com.bean.DiameterNode;
import com.bean.LayoutEdge;
import com.bean.LayoutNode;
import com.layout.model.PipeEdge;
import com.layout.model.PipeNet;

public class Utils {
	
	public static final double PI=3.14;
	/**
	 * 深度优先搜索
	 * @param edges 组成图的边信息
	 * @param start 从start这个点开始遍历
	 * @param visited  标记下标所对应节点是否已被访问过
	 * @return
	 */
	/*public static void dfs(List<PipeEdge> edges,int start,boolean[] visited){
		
		visited[start]=true;
		for(PipeEdge edge:edges){
			if(edge.getsNode()==start+1&&!visited[edge.geteNode()-1]){
				
				dfs(edges,edge.geteNode()-1,visited);
			}else if(edge.geteNode()==start+1&&!visited[edge.getsNode()-1]){
				dfs(edges,edge.getsNode()-1,visited);
			}
			
		}
	}*/
	public static void dfs(List<PipeEdge> edges,int start,boolean[] visited){
		
		visited[start-1]=true;
		for(PipeEdge edge:edges){
			if(edge.getsNode()==start&&!visited[edge.geteNode()-1]){
				dfs(edges,edge.geteNode(),visited);
			}
			
			else if(edge.geteNode()==start&&!visited[edge.getsNode()-1]){
				dfs(edges,edge.getsNode(),visited);
			}
			
		}
	}
	public static   boolean isTree(int[] bitString, PipeNet pipeNet) {

		/*List<Integer> standardList = new ArrayList<Integer>();// ����һ�����ϣ���10���ڵ�
		for (int i = 1; i <= 10; i++) {
			standardList.add(i);
		}*/
		List<PipeEdge> edges = new ArrayList<PipeEdge>(); // ����һ��Edge[]���飬������������������бߡ�
		for (int i = 0; i < bitString.length; i++) {
			if (bitString[i] == 1) {
				edges.add(pipeNet.getEdges().get(i));
			}
		}
		if (edges.size() == pipeNet.getnNumber()- 1) {

			boolean[] visited = new boolean[pipeNet.getnNumber()];

			Utils.dfs(edges, edges.get(0).getsNode(), visited);
			for (int i = 0; i < visited.length; i++) {
				if (!visited[i]) {
					return false;
				}
			}
			System.out.println(Arrays.toString(visited));
			return true;

		}
		return false;

	}
	public static String getNodesJSON(List<LayoutNode> nodes){
		if(nodes.size()==0||nodes==null){
			return null;
		}
		StringBuffer nodesJSON=new StringBuffer("[");
		for(int i=0;i<nodes.size()-1;i++){
			nodesJSON.append(nodes.get(i).toString()+",");
		}
		nodesJSON.append(nodes.get(nodes.size()-1).toString()+"]");
		
		return nodesJSON.toString();
	}
	
	public static String getEdgesJSON(List<LayoutEdge> edges){
		if(edges.size()==0||edges==null){
			return null;
		}
		StringBuffer edgesJSON=new StringBuffer("[");
		for(int i=0;i<edges.size()-1;i++){
			edgesJSON.append(edges.get(i).toString()+",");
		}
		edgesJSON.append(edges.get(edges.size()-1).toString()+"]");
		return edgesJSON.toString();
	}
	
	public static boolean layoutIsExist(List<LayoutNode> nodes,Integer node){
		boolean flag=false;
		for(LayoutNode ln:nodes){
			if(ln.getNoOfProj().equals(node)){
				flag=true;
			}
		}
		return flag;
	}
	public static boolean diameterIsExist(List<DiameterNode> nodes,Integer node){
		boolean flag=false;
		for(DiameterNode dn:nodes){
			if(dn.getNoOfProj().equals(node)){
				flag=true;
			}
		}
		return flag;
	}
	
	public static boolean layoutEdgeIsExist(Integer snode,Integer enode,List<LayoutEdge> edges){
		for(LayoutEdge le:edges){
			if((le.getSnode().equals(snode)&&le.getEnode().equals(enode))||(le.getEnode().equals(snode)&&le.getSnode().equals(enode))){
				return true;
			}
		}
		return false;
	}
	
	public static boolean diameterIsExist(Integer snode,Integer enode,List<DiameterEdge> edges){
		for(DiameterEdge de:edges){
			if((de.getSnode().equals(snode)&&de.getEnode().equals(enode))||(de.getEnode().equals(snode)&&de.getSnode().equals(enode))){
				return true;
			}
		}
		return false;
	}
	public static void generateNB(List<LayoutEdge> edges,List<LayoutNode> nodes){
		int[][] aKN=new int[nodes.size()][nodes.size()];
		for (LayoutEdge edge : edges) {
			aKN[edge.getSnode() - 1][edge.getEnode() - 1] = 1;
		}
		int n=1;
		
		for (int i = 0; i < aKN.length; i++) {
			for (int j = 0; j < aKN[i].length; j++) {
				if (aKN[i][j] == 1) {
					for(LayoutEdge edge:edges){
						if(edge.getSnode()==i+1&&edge.getEnode()==j+1){
							edge.setNoOfProj(n);
							n++;
							break;
						}
					}
				}
			}
		}
	}
	
}
