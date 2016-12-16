package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.bean.LayoutEdge;
import com.bean.LayoutNode;
import com.dao.LayoutEdgeDAO;
import com.dao.LayoutNodeDAO;
import com.layout.algorithm.LayoutGA;
import com.layout.algorithm.LayoutIndividual;
import com.layout.model.PipeEdge;
import com.layout.model.PipeNet;
import com.layout.model.PipeTreeNode;
import com.layout.model.Point;

public class PipeNetTest {
	public static void main(String[] args){
		List<PipeEdge> edges=new ArrayList<PipeEdge>();
		/*edges.add(new PipeEdge(1, 1, 2));
		edges.add(new PipeEdge(2, 1, 3));
		edges.add(new PipeEdge(3, 1, 4));
		edges.add(new PipeEdge(4, 2, 3));
		edges.add(new PipeEdge(5, 2, 6));
		edges.add(new PipeEdge(6, 2, 7));
		edges.add(new PipeEdge(7,3,4));
		edges.add(new PipeEdge(8,3,5));
		edges.add(new PipeEdge(9,3,6));
		edges.add(new PipeEdge(10,3,7));
		edges.add(new PipeEdge(11,4,5));
		edges.add(new PipeEdge(12,4,7));
		edges.add(new PipeEdge(13,4,8));
		edges.add(new PipeEdge(14,5,7));
		edges.add(new PipeEdge(15,5,8));
		edges.add(new PipeEdge(16,6,7));
		edges.add(new PipeEdge(17,6,9));
		edges.add(new PipeEdge(18,7,8));
		edges.add(new PipeEdge(19,7,9));
		edges.add(new PipeEdge(20,7,10));
		edges.add(new PipeEdge(21,8,9));
		edges.add(new PipeEdge(22,8,10));
		edges.add(new PipeEdge(23,9,10));*/
		
		
		edges.add(new PipeEdge(4, 9, 2, 3));
		edges.add(new PipeEdge(5, 8, 2, 6));
		edges.add(new PipeEdge(6, 11, 2, 7));
		edges.add(new PipeEdge(7,7,3,4));
		edges.add(new PipeEdge(8,9,3,5));
		edges.add(new PipeEdge(9,11,3,6));
		edges.add(new PipeEdge(10,7,3,7));
		edges.add(new PipeEdge(11,3,4,5));
		edges.add(new PipeEdge(12,10,4,7));
		edges.add(new PipeEdge(13,7,4,8));
		edges.add(new PipeEdge(14,10,5,7));
		edges.add(new PipeEdge(15,5,5,8));
		edges.add(new PipeEdge(16,9,6,7));
		edges.add(new PipeEdge(17,8,6,9));
		edges.add(new PipeEdge(18,8,7,8));
		edges.add(new PipeEdge(19,6,7,9));
		edges.add(new PipeEdge(20,11,7,10));
		edges.add(new PipeEdge(21,11,8,9));
		edges.add(new PipeEdge(22,11,8,10));
		edges.add(new PipeEdge(23,10,9,10));
		edges.add(new PipeEdge(1, 8, 1, 2));
		edges.add(new PipeEdge(2, 5, 1, 3));
		edges.add(new PipeEdge(3, 9, 1, 4));
		
		List<PipeTreeNode> nodes=new ArrayList<PipeTreeNode>();
		nodes.add(new PipeTreeNode(new Point(300,0)));
		nodes.add(new PipeTreeNode(new Point(200,100)));
		nodes.add(new PipeTreeNode(new Point(400,200)));
		nodes.add(new PipeTreeNode(new Point(300,200)));
		nodes.add(new PipeTreeNode(new Point(150,300)));
		nodes.add(new PipeTreeNode(new Point(300,300)));
		nodes.add(new PipeTreeNode(new Point(450,300)));
		nodes.add(new PipeTreeNode(new Point(200,500)));
		nodes.add(new PipeTreeNode(new Point(350,500)));
		nodes.add(new PipeTreeNode(new Point(300,600)));
		/*LayoutEdgeDAO leDAO=new LayoutEdgeDAO();
		LayoutNodeDAO lnDAO=new LayoutNodeDAO();
		List<LayoutEdge> dbEdges=leDAO.findEdgeByProjectId(1);
		List<LayoutNode> dbNodes=lnDAO.findNodeByProjectId(1);
		
		List<PipeEdge> edges=new ArrayList<PipeEdge>();
		List<PipeTreeNode> nodes=new ArrayList<PipeTreeNode>();
		
		for(LayoutEdge edge: dbEdges) {
			edges.add(new PipeEdge(edge.getNoOfProj(),8, edge.getSnode(),edge.getEnode()));	
		}
		
		for(LayoutNode node: dbNodes) {
			
			nodes.add(new PipeTreeNode(new Point(node.getNodeX(),node.getNodeY())));
		}
		
		*/
		PipeNet pipeNet=new PipeNet(nodes,edges);
		/*int[][] aKN=pipeNet.getKn();
		System.out.println(aKN.length);
		int sum=0;
		for(int i=0;i<aKN.length;i++){
			for(int j=0;j<aKN[i].length;j++){
				if(aKN[i][j]==1){
					sum++;
				}
			}
		}
		System.out.println(sum);
		for(int i=0;i<aKN.length;i++){
			System.out.println(Arrays.toString(aKN[i]));
		}*/
		/*List<BEdge> bEdges=pipeNet.getnB();
		for(int i=1;i<=bEdges.size();i++){
			System.out.println("NB["+i+"]="+bEdges.get(i-1));
		}*/
//		int[][] aBT=pipeNet.getBt();
//		System.out.println(aBT.length);
//		System.out.println(aBT[1].length);
//		for(int i=0;i<aBT.length;i++){
//			System.out.println(Arrays.toString(aBT[i]));
//		}
		/*double[][] ln=pipeNet.getLn();
		for(int i=0;i<ln.length;i++){
			System.out.println(Arrays.toString(ln[i]));
		}*/
		LayoutGA layoutGA=new LayoutGA(pipeNet,10,50,0.5f,0.5f);
		
		try {
			layoutGA.go();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		List<LayoutIndividual> parents=layoutGA.getParents();
		for(LayoutIndividual individual:parents){
			int[] chrom=individual.getChrom();
			System.out.println(Arrays.toString(chrom));
			int[] edgesNO=new int[9];
			int n=0;
			for(int i=0;i<chrom.length;i++){
				if(chrom[i]==1){
					edgesNO[n]=i+1;
					n++;
				}
			}
			/*List<PipeEdge> pes=new ArrayList<PipeEdge>();*/
			
			System.out.println(Arrays.toString(edgesNO));
		}
	}
}
