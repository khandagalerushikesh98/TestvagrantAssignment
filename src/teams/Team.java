package com.testvagrant.team;

import java.util.Arrays;

public class Team {
    private String name;
    private int point;
    private char[] result;

    public Team() {}
    
    public Team(String name, int point, char[] result) {
        this.name = name;
        this.point = point;
        this.result = result;
    }

    @Override
	public String toString() {
		return "Team [name=" + name + ", point=" + point + 
				", score=" + Arrays.toString(result) + "]";
	}

	public String getName() {
        return name;
    }

    public int getPoint() {
        return point;
    }

    public char[] getResult() {
        return result;
    }
}
