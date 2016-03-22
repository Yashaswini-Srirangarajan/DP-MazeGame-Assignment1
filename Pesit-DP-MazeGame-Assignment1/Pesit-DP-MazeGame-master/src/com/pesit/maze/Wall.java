package com.pesit.maze;

//It is the basic building block of a Maze
//This helps block the player from entering one place to another place
public class Wall extends Mapsite{
    public Wall() {
    	
    	//We don't find any necessity to give it any attribute
    }

    //This function lets the user know that he approached a wall and cannot proceed further
    @Override
    int Enter(Room room) 
    {
      return 0;
    }
}
