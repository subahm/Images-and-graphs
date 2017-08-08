
import java.awt.Color;
import java.util.Queue;
import java.util.LinkedList;

public class A3Algorithms{

	/* FloodFillDFS(v, viewer, fillColour)
	   Traverse the component the vertex v using DFS and set the colour 
	   of the pixels corresponding to all vertices encountered during the 
	   traversal to fillColour.
	   
	   To change the colour of a pixel at position (x,y) in the image to a 
	   colour c, use
			viewer.setPixel(x,y,c);
	*/
	
	public static void FloodFillDFS(PixelVertex v, ImageViewer225 viewer, Color fillColour){
		v.Visited();
		viewer.setPixel(v.getX(),v.getY(),fillColour);
		for(int i = 0; i < v.array.length; i++){
			if (v.array[i] != null && (v.array[i].isVisited() == false)){
				FloodFillDFS(v.array[i], viewer, fillColour);
			}
		}	
	}
	
	/* FloodFillBFS(v, viewer, fillColour)
	   Traverse the component the vertex v using BFS and set the colour 
	   of the pixels corresponding to all vertices encountered during the 
	   traversal to fillColour.
	   
	   To change the colour of a pixel at position (x,y) in the image to a 
	   colour c, use
			viewer.setPixel(x,y,c);
	*/
	public static void FloodFillBFS(PixelVertex v, ImageViewer225 viewer, Color fillColour){
		Queue<PixelVertex> q = new LinkedList<PixelVertex>();
		q.add(v);
		while(!q.isEmpty()){
			PixelVertex n = q.remove();
			for(int i = 0; i < n.array.length; i++){
				if (n.array[i] != null && (n.array[i].isVisited() == false)){
					n.array[i].Visited();
			    	viewer.setPixel(n.array[i].getX(), n.array[i].getY(), fillColour);
				    q.add(n.array[i]);
				}
			}
		}
	}
	
	/* OutlineRegionDFS(v, viewer, outlineColour)
	   Traverse the component the vertex v using DFS and set the colour 
	   of the pixels corresponding to all vertices with degree less than 4
	   encountered during the traversal to outlineColour.
	   
	   To change the colour of a pixel at position (x,y) in the image to a 
	   colour c, use
			viewer.setPixel(x,y,c);
	*/
	public static void OutlineRegionDFS(PixelVertex v, ImageViewer225 viewer, Color outlineColour){
		if(v.getDegree() < 4){
			viewer.setPixel(v.getX(),v.getY(), outlineColour);
		}
		v.Visited();
		for(int i = 0; i < v.array.length; i++){
			if (v.array[i] != null && (v.array[i].isVisited() == false)){
				v.array[i].Visited();
				OutlineRegionDFS(v.array[i], viewer, outlineColour);
			}
		}		
	}
	
	/* OutlineRegionBFS(v, viewer, outlineColour)
	   Traverse the component the vertex v using BFS and set the colour 
	   of the pixels corresponding to all vertices with degree less than 4
	   encountered during the traversal to outlineColour.
	   
	   To change the colour of a pixel at position (x,y) in the image to a 
	   colour c, use
			viewer.setPixel(x,y,c);
	*/
	public static void OutlineRegionBFS(PixelVertex v, ImageViewer225 viewer, Color outlineColour){
		Queue<PixelVertex> q = new LinkedList<PixelVertex>();
		q.add(v);
		v.Visited();
		if(v.getDegree() < 4)
			viewer.setPixel(v.getX(),v.getY(), outlineColour);
		while(!q.isEmpty()){
			PixelVertex n = q.remove();
			for(int i = 0; i < n.array.length; i++){
				if (n.array[i] != null && (n.array[i].isVisited() == false)){
					if(v.c.equals(n.array[i].c)){
						n.array[i].Visited();
			    		if(n.array[i].getDegree() < 4)
			    			viewer.setPixel(n.array[i].getX(),n.array[i].getY(),outlineColour);
				    	q.add(n.array[i]);
				    }
				}
			}
		}	
	}

	/* CountComponents(G)
	   Count the number of connected components in the provided PixelGraph 
	   object.
	*/
	public static int CountComponents(PixelGraph G){
		PixelVertex v;
		int comp = 0;
		for(int i=0; i<G.getWidth(); i++){
			for(int j=0; j<G.getHeight(); j++){
				v = G.getPixelVertex(i,j);
				if(v.isVisited() == false){
					componentsDFS(v);
					comp++;
				}
			}
		}
		return comp-1;
	}
	
	public static void componentsDFS(PixelVertex v){
		v.Visited();
		for(int i = 0; i < v.array.length; i++){
			if(v.array[i] != null && v.array[i].isVisited() == false){
				componentsDFS(v.array[i]);
			}
		}
	}
	
}
