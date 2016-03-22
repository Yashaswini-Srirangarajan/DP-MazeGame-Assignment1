package com.pesit.maze;

//Room is a basic object in a maze
//A basic room can have doors and walls
public class Room extends Mapsite 
{

    private int roomNumber;
    private Mapsite[] sides=new Mapsite[4];

    //A constructor for the Room class which will take an id which is going to be unique for each room.
    public Room(int id) 
    {
    	roomNumber=id;
    }

    //Takes the parameter direction
    //Returns the mapsite that is there in that particular direction
    Mapsite getSide(int dir)
    {
    	return sides[dir];//returns the side of a room in that particular direction
    }

 
    //Takes 2 parameters
    //First parameter is the direction in which something should be created
    //Second parameter is what should be created
    void setSide(int dir, Mapsite mapsite)
    {
    	sides[dir]=mapsite;
    	//We are placing the respective component of the room in the sides array
       //That component can be a room , a wall or a door. 
    }

    
    
    //Enter is called when the person enters a room
    //Returns -1
    @Override
    int Enter(Room room) 
    {
        return -1;
    }

    //This is a getter method to access the private roomNumber in the rooms class 
	public int getRooms() 
	{
		return roomNumber;
	}
}
