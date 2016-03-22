package com.pesit.maze;

import java.util.ArrayList;
import java.util.List;

//This represents a collection of rooms
//We can find a particular room using its roomNumber
public class Maze 
{

    private List<Room> rooms = new ArrayList<>();

    public void Maze() 
    {
    	//We Don't need the constructor 
    }

    //Adds a room to the maze
    public void AddRoom(Room roomToAdd) 
    {
        rooms.add(roomToAdd);
    }

    //Does a lookup of the room based on the roomNumber
    public Room RoomNo(int roomNumber) 
    {
    	int i=0;
    	Room r=rooms.get(i);
    	//Searches the Entire List for the room with a given room number and returns the room
    	while(r.getRooms()!=roomNumber && i<rooms.size())
    	{
    		r=rooms.get(i);
    		i++;
    	}
    	
        return r;
    }
}