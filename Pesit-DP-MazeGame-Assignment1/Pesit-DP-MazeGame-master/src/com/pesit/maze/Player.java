package com.pesit.maze;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Player 
{	
	public static void main(String args[]) throws IOException
	{
		BufferedReader br=new BufferedReader(new FileReader("CreateMaze.txt"));
		String line="";
		String[] temp_ReadLine_String;
		int[] temp_ReadLine_int;
		Room myRoom;
		Wall myWall;
		Door myDoor;
		Maze myMaze=new Maze();
		MazeFactory Factory=new MazeFactory();
		Traversal t=new Traversal();
		 while((line = br.readLine()) != null)
		{
			 
			 temp_ReadLine_String=line.split(" ");
			 temp_ReadLine_int=new int[temp_ReadLine_String.length];
			 
			 for(int i=0;i<temp_ReadLine_int.length;i++)
			 {
				 temp_ReadLine_int[i]=Integer.parseInt(temp_ReadLine_String[i]);
				 
			 }
			 
			 //A room is created 
			 myRoom=Factory.MakeRoom(temp_ReadLine_int[0]);
			
			 
			 for(int i=1;i<temp_ReadLine_int.length;i++)
			 {
				 if(temp_ReadLine_int[i]==0)
				 {
					 myWall=Factory.MakeWall();//Creating a wall if given zero
					 myRoom.setSide(i-1, myWall);//Setting the appropriate MapSite
				 }
				 else
				 {
					 Room tempRoom=Factory.MakeRoom(temp_ReadLine_int[i]);//Creating a room if the values greater than 0
					 myDoor=Factory.MakeDoor(myRoom,tempRoom);//Creating a door between two valid rooms
					 myRoom.setSide(i-1,myDoor );
				 }	
			 }
			 
			 //Adding the rooms to our list
			 if(myMaze!=null)
			 {
				 myMaze.AddRoom(myRoom); 
			 } 
		}
		 
		 //Traversing the created maze
		 t.TraverseMaze(myMaze);
	}
}
