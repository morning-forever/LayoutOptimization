package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.bean.DiameterParam;
import com.bean.PipeKind;
import com.diameter.algorithm.DiameterGA;
import com.diameter.algorithm.DiameterIndividual;
import com.diameter.model.PipeTree;
import com.diameter.model.PipeTreeEdge;
import com.diameter.model.PipeTreeNode;
import com.layout.model.Point;

public class DiameterTest {
	public static void main(String[] args){
		List<PipeKind> pipeKinds=new ArrayList<PipeKind>();
		
		pipeKinds.add(new PipeKind(1,50,30,3.5));
		pipeKinds.add(new PipeKind(2,65,30,3.5));
		pipeKinds.add(new PipeKind(3,85,30,3.5));
		pipeKinds.add(new PipeKind(4,100,30,3.5));
		pipeKinds.add(new PipeKind(5,125,30,3.5));
		pipeKinds.add(new PipeKind(6,150,30,3.5));
		pipeKinds.add(new PipeKind(7,200,40,4.5));
		pipeKinds.add(new PipeKind(8,250,40,4.5));
		pipeKinds.add(new PipeKind(9,300,40,6));
		pipeKinds.add(new PipeKind(10,350,40,6));
		pipeKinds.add(new PipeKind(11,400,50,7));
		pipeKinds.add(new PipeKind(12,450,50,8));
		pipeKinds.add(new PipeKind(13,500,50,9));
		pipeKinds.add(new PipeKind(14,600,55,10));
		pipeKinds.add(new PipeKind(15,700,55,11));
		pipeKinds.add(new PipeKind(16,800,55,14));
		pipeKinds.add(new PipeKind(17,900,55,14));
		pipeKinds.add(new PipeKind(18,1000,57,15));
		pipeKinds.add(new PipeKind(19,1200,57,15));
		
		List<PipeTreeEdge> edges=new ArrayList<PipeTreeEdge>();
		edges.add(new PipeTreeEdge(1, 1, 2,50,51));
		edges.add(new PipeTreeEdge(2, 1, 3,80,81));
		edges.add(new PipeTreeEdge(3, 1, 4,70,71));
		edges.add(new PipeTreeEdge(4, 2, 6,60,61));
		edges.add(new PipeTreeEdge(5, 3, 7,60,61));
		edges.add(new PipeTreeEdge(6,4,8,90,91));
		edges.add(new PipeTreeEdge(7,4,5,100,101));
		edges.add(new PipeTreeEdge(8,7,9,50,51));
		edges.add(new PipeTreeEdge(9,7,10,40,41));
		
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
		
		DiameterParam dp=new DiameterParam(15, 0.8, 0.993*1000, 1.0, 0.5, 0.1, 100, 0.56, 365*24, 20, 5, 5,1,1,10);
		
		PipeTree pipeTree=new PipeTree(nodes, edges, pipeKinds, dp);
		
		DiameterGA diameterGA=new DiameterGA(pipeTree, 10, 50);
		diameterGA.go();
		List<DiameterIndividual> parents=diameterGA.getParents();
		for(DiameterIndividual individual:parents){
			System.out.println(individual.getFitness()+Arrays.toString(individual.getChrom()));
		}
		
		
		
	}
}
