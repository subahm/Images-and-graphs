/*
Name: Subah Mehrotra
V#: V00855471
Netlink id: subah123
*/







/* PixelVertex.java
   CSC 225 - Summer 2017
   Programming Assignment 3 - Pixel Vertex Data Structure


   B. Bird - 07/03/2017
*/

import java.awt.Color;
public class PixelVertex{

	int count = 0;
	int x;
	int y;
	Color c;
	boolean visit;
	PixelVertex[] array = new PixelVertex [4]; //contains all the neighbours of a vertex v
	
	/* Add a constructor here (if necessary) */
	public PixelVertex(int x, int y, Color c){
		this.x = x;
		this.y = y;
		this.c = c;
		visit = false;
	}
	
	/* getX()
	   Return the x-coordinate of the pixel corresponding to this vertex.
	*/
	public int getX(){
		return this.x;
	}
	
	/* getY()
	   Return the y-coordinate of the pixel corresponding to this vertex.
	*/
	public int getY(){
		return this.y;
	}
	
	/* getNeighbours()
	   Return an array containing references to all neighbours of this vertex.
	*/
	public PixelVertex[] getNeighbours(){
		return array;
	}
	
	/* addNeighbour(newNeighbour)
	   Add the provided vertex as a neighbour of this vertex.
	*/
	public void addNeighbour(PixelVertex newNeighbour){
		array[count] = newNeighbour;
		count++;
	}
	
	/* removeNeighbour(neighbour)
	   If the provided vertex object is a neighbour of this vertex,
	   remove it from the list of neighbours.
	*/
	public void removeNeighbour(PixelVertex neighbour){
		for(int i=0; i<count; i++){
			if(array[i]==neighbour){
				array[i] = array[count];
			}
		}
		array[count]=null;
		count--;	
	}
	
	/* getDegree()
	   Return the degree of this vertex.
	*/
	public int getDegree(){
		return count;
	}
	
	/* isNeighbour(otherVertex)
	   Return true if the provided PixelVertex object is a neighbour of this
	   vertex and false otherwise.
	*/
	public boolean isNeighbour(PixelVertex otherVertex){
		for(int i=0; i<count; i++){
			if(array[i]==otherVertex){
				return true;
			}
		}
		return false;	
	}
	
	public void Visited(){
		visit = true;
	}
	
	public boolean isVisited(){
		return visit;
	}
	
	
}