package com.pesit.maze;

//Abstract base class for all the components of a MazeGame
public abstract class Mapsite 
{
	//The Enter function returns:
	//0 for a wall
	//1 for a door
	//-1 for a room
    abstract int Enter(Room room);
}
