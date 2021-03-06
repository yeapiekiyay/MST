/**
 * Vertex.java
 * 
 * The purpose of this class is to represent a vertex within an
 * undirected, weighted graph.
 * 
 * @author Michael Yeaple
 *
 */

import java.util.*;

public class Vertex {
	
	private int name; // Name is a number (i.e. 0, 1, etc.)
//	// weightByInteger represents the weight between this vertex and 
//	// another by the name of the other vertex.
//	// K: otherVertex -> V: weight of edge
//	private HashMap<Integer, Long> weightByVertexName;
	private ArrayList<Edge> edges;
	private boolean visited;
	
	public Vertex(){ }
	
	/**
	 * Vertex() - specific constructor
	 * 
	 * @param name - the "name" of the vertex (an integer).
	 */
	public Vertex(int name)
	{
		this.name = name;
//		weightByVertexName = new HashMap<Integer, Long>();
		edges = new ArrayList<Edge>();
	}
	
//	/**
//	 * addEdge()
//	 * 
//	 * Adds a new edge connected to the provided vertex with the
//	 * provided weight.
//	 * 
//	 * @param vNew - the vertex to connect to via the new edge.
//	 * @param weight - the weight of the edge connecting the two vertices.
//	 */
//	public void addEdge(Vertex vNew, long weight) throws VertexException
//	{
//		int vName = vNew.getName();
//		
//		if (!weightByVertexName.containsKey(vName))
//		{
//			weightByVertexName.put(vName, weight);
//		}
//		else
//		{
//			throw new VertexException("Edge already exists.");
//		}
//	}
	
	/**
	 * addEdge()
	 * 
	 * Adds a new edge to the Vertex.
	 * 
	 * @param eNew - the edge to be added to the Vertex.
	 */
	public void addEdge(Edge eNew)
	{
		edges.add(eNew);
	}
	
	/**
	 * visit()
	 * 
	 * Marks the current node as visited.
	 */
	public void visit()
	{
		visited = true;
	}
	
	/**
	 * reset()
	 * 
	 * Marks the current node as not visited.
	 */
	public void reset()
	{
		visited = false;
	}
	
	/**
	 * isVisited()
	 * 
	 * Returns true if the vertex has already been visited.
	 * 
	 * @return - true: vertex has been visited; false: vertex not visited.
	 */
	public boolean isVisited()
	{
		return visited;
	}
	
	/**
	 * nameToString()
	 * 
	 * Returns the "name" of the vertex as a string.
	 * 
	 * @return - the "name" of the vertex.
	 */
	public String nameToString()
	{
		return Integer.toString(name);
	}
	
	/**
	 * getName()
	 * 
	 * Returns the name of the string as an int.
	 * 
	 * @return - the name of the string as an int.
	 */
	public int getName()
	{
		return name;
	}
	
//	/**
//	 * getEdgeMap()
//	 * 
//	 * Returns the connected vertices mapped to the weights.
//	 * 
//	 * @return - a hashmap of the weight of each edge by the vertex name.
//	 */
//	public HashMap<Integer, Long> getEdgeMap()
//	{
//		return weightByVertexName;
//	}
	
	/**
	 * getEdges()
	 * 
	 * Returns the edges connected to this Vertex.
	 * 
	 * @return - an ArrayList of the edges connected to this Vertex.
	 */
	public ArrayList<Edge> getEdges()
	{
		return edges;
	}
	
	/**
	 * getEdgesRight()
	 * 
	 * Returns Edges in which this Vertex is the left Vertex
	 * on the Edge.
	 * 
	 * @return - a list of Edges.
	 */
	public ArrayList<Edge> getEdgesRight()
	{
		ArrayList<Edge> result = new ArrayList<Edge>();
		
		Iterator<Edge> iter = edges.iterator();
		while(iter.hasNext())
		{
			Edge e = iter.next();
			if (e.getLeftVertex().equals(this))
				result.add(e);
		}
		
		return result;
	}
	
	/**
	 * getEdgeByVRight()
	 * 
	 * Returns the Edge with a right Vertex of the specified name.
	 * 
	 * @param vRightName - the name of the right Vertex on the edge to be found.
	 * @return - the found Edge (null if not found).
	 */
	public Edge getEdgeByVRight(int vRightName)
	{
		for (int i = 0; i < edges.size(); i++)
		{
			if (edges.get(i).getRightVertex().getName() == vRightName)
				return edges.get(i);
		}
		
		return null;
	}
	
	/**
	 * getEdge()
	 * 
	 * Returns the Edge connected to both this one 
	 * and the Vertex of the specified name.
	 * 
	 * @param v - the other Vertex.
	 * @return - the Edge between the two vertices (null if not found).
	 */
	public Edge getEdge(int v)
	{
		for (int i = 0; i < edges.size(); i++)
		{
			if (edges.get(i).getRightVertex().getName() == v ||
					edges.get(i).getLeftVertex().getName() == v)
				return edges.get(i);
		}
		
		return null;
	}
	
}
