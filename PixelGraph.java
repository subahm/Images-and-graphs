

import java.awt.Color;

public class PixelGraph{
	PixelVertex[][] array2;
	/* PixelGraph constructor
	   Given a 2d array of colour values (where element [x][y] is the colour 
	   of the pixel at position (x,y) in the image), initialize the data
	   structure to contain the pixel graph of the image. 
	*/
	public PixelGraph(Color[][] imagePixels){
		array2 = new PixelVertex[imagePixels.length][imagePixels[0].length];
		for(int i=0; i<imagePixels.length; i++){
			for(int j=0; j<imagePixels[0].length; j++){
				array2[i][j] = new PixelVertex(i, j, imagePixels[i][j]);
			}
		}
		//Adding neighbours
		for(int i=0; i<imagePixels.length-1; i++){
			for(int j=0; j<imagePixels[0].length-1; j++){
				//When row is 0, but column is not 0
				if(i==0 && j!=0){
					if(array2[i][j].c.equals(array2[i+1][j].c)){
						array2[i][j].addNeighbour(array2[i+1][j]);
					}
					if(array2[i][j].c.equals(array2[i][j-1].c)){
						array2[i][j].addNeighbour(array2[i][j-1]);
					}
					if(array2[i][j].c.equals(array2[i][j+1].c)){
						array2[i][j].addNeighbour(array2[i][j+1]);
					}
				}
				//When row is not 0, but column is 0
				if(j==0 && i!=0){
					if(array2[i][j].c.equals(array2[i+1][j].c)){
						array2[i][j].addNeighbour(array2[i+1][j]);
					}
					if(array2[i][j].c.equals(array2[i][j+1].c)){
						array2[i][j].addNeighbour(array2[i][j+1]);
					}
					if(array2[i][j].c.equals(array2[i-1][j].c)){
						array2[i][j].addNeighbour(array2[i-1][j]);
					}
				}
				//When row is the last row, but column is not the last column
				if(i==imagePixels.length-2 && j!=(imagePixels[0].length)-2){
					if(array2[i+1][j+1].c.equals(array2[i][j+1].c)){
						array2[i+1][j+1].addNeighbour(array2[i][j+1]);
					}
					if(array2[i+1][j+1].c.equals(array2[i+1][j+2].c)){
						array2[i+1][j+1].addNeighbour(array2[i+1][j+2]);
					}
					if(array2[i+1][j+1].c.equals(array2[i+1][j].c)){
						array2[i+1][j+1].addNeighbour(array2[i+1][j]);
					}
				}
				//When row is not the last row, but column is the last column
				if(j==(imagePixels[0].length)-2 && i!=(imagePixels.length)-2){
					if(array2[i+1][j+1].c.equals(array2[i][j+1].c)){
						array2[i+1][j+1].addNeighbour(array2[i][j+1]);
					}
					if(array2[i+1][j+1].c.equals(array2[i+2][j+1].c)){
						array2[i+1][j+1].addNeighbour(array2[i+2][j+1]);
					}
					if(array2[i+1][j+1].c.equals(array2[i+1][j].c)){
						array2[i+1][j+1].addNeighbour(array2[i+1][j]);
					}
				}
				//When column and rows are neither 0 nor at the end.
				if(i!=0 && j!=0 && i!=(imagePixels.length-1) && j!=(imagePixels[0].length-1)){
					if(array2[i][j].c.equals(array2[i][j-1].c)){
						array2[i][j].addNeighbour(array2[i][j-1]);
					}
					if(array2[i][j].c.equals(array2[i-1][j].c)){
						array2[i][j].addNeighbour(array2[i-1][j]);
					}
					if(array2[i][j].c.equals(array2[i][j+1].c)){
						array2[i][j].addNeighbour(array2[i][j+1]);
					}
					if(array2[i][j].c.equals(array2[i+1][j].c)){
						array2[i][j].addNeighbour(array2[i+1][j]);
					}
				}
			}
		}
	}
		
	
	/* getPixelVertex(x,y)
	   Given an (x,y) coordinate pair, return the PixelVertex object 
	   corresponding to the pixel at the provided coordinates.
	   This method is not required to perform any error checking (and you may
	   assume that the provided (x,y) pair is always a valid point in the 
	   image).
	*/
	public PixelVertex getPixelVertex(int x, int y){
		return array2[x][y];
	}
	
	/* getWidth()
	   Return the width of the image corresponding to this PixelGraph 
	   object.
	*/
	public int getWidth(){
		return array2.length;
	}
	
	/* getHeight()
	   Return the height of the image corresponding to this PixelGraph 
	   object.
	*/
	public int getHeight(){
		return array2[0].length;
	}
	
}
