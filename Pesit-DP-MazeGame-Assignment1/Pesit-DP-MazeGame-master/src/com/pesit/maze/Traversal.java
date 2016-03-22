package com.pesit.maze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Traversal
{	
	public void TraverseMaze(Maze  myMaze) throws NumberFormatException, IOException
	{
		MazeFactory Factory=new MazeFactory();
		File fout = new File("C:\\Users\\Yashaswini\\Documents\\4th SEM\\Design pattern\\Destinations.txt");
		FileOutputStream fos = new FileOutputStream(fout);
	 
		 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
		 BufferedReader br=new BufferedReader(new FileReader("C:\\Users\\Yashaswini\\Documents\\4th SEM\\Design pattern\\TraverseMaze.txt"));
		 String line="";
		 String[] temp_ReadLine_String;
		 int[] temp_ReadLine_int;
		 Room currentRoom;
		 Maze TraverseMaze=myMaze;
		 while((line = br.readLine()) != null)
		{
			 
			 temp_ReadLine_String=line.split(" ");
			 temp_ReadLine_int=new int[temp_ReadLine_String.length];
			 
			 for(int i=0;i<temp_ReadLine_int.length;i++)
			 {
				 temp_ReadLine_int[i]=Integer.parseInt(temp_ReadLine_String[i]);	 
			 }
			 
			 
			 //Assigning the starting room to our current room
			 currentRoom=TraverseMaze.RoomNo(temp_ReadLine_int[0]);
				 
			 //Traversing the maze line by line
			 for(int i=1;i<temp_ReadLine_int.length;i++)
			 {
				 
					Mapsite mapsite_side=currentRoom.getSide(temp_ReadLine_int[i]);
					
					//Check_Front is:
					//0 if wall
					//The Adjacent room number if a door
					//-1 if a room
					int check_Front=mapsite_side.Enter(currentRoom);
					
					//If the direction leads to a room it updates the current room
					if(check_Front>0)
					{
						currentRoom=myMaze.RoomNo(check_Front);	
					}
									
			 }
			 
			 //Writing to a file
			 	//System.out.println(" Destination room : "+currentRoom.getRooms());
			 	bw.write(new Integer(currentRoom.getRooms()).toString());
				bw.newLine();	 
		}
		 
		 bw.close();	
	}
}