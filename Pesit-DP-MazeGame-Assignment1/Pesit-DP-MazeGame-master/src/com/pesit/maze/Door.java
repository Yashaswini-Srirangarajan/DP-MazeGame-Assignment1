package com.pesit.maze;

//Door exists between 2 rooms
//Door can either be locked or unlocked
public class Door extends Mapsite 
{

    private Room room1;
    private Room room2;

    //Creates a door between 2 rooms r1 and r2
    public Door(Room r1, Room r2) 
    {
        room1 = r1;
        room2 = r2;
    }

    //This will control the flow when the user is entering a door
    //This method returns the Room Number of the room on the otherside of the door
    @Override
    public int Enter(Room room) 
    {
         room=WhichRoomAcrossTheDoor(room);   
        return room.getRooms();
    }


    //This function returns the room on the otherside of the door if you provide it the reference of the adjacent room to which the door belongs to
    //Useful while Traversing
    public Room WhichRoomAcrossTheDoor(Room r) 
    {
        if(room1.equals(r)) 
        {
            return room2;
        }
        	return room1;
    }
}