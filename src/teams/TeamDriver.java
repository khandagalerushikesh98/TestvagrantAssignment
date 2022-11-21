package com.testvagrant.team;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TeamDriver {
    public static void main(String[] args) {
    	try (Scanner sc = new Scanner(System.in)) {
			List<Team> list = new ArrayList<>();
			list.add(new Team("GT", 20, new char[]{'W','W','L','L','W'}));
			list.add(new Team("LSG", 18, new char[]{'W','L','L','W','W'}));
			list.add(new Team("RR", 16, new char[]{'W','L','W','L','L'}));
			list.add(new Team("DC", 14, new char[]{'W','W','L','W','L'}));
			list.add(new Team("RCB", 14, new char[]{'L','W','W','L','L'}));
			list.add(new Team("KKR", 12, new char[]{'L','W','W','L','W'}));
			list.add(new Team("PBKS", 12, new char[]{'L','W','L','W','L'}));
			list.add(new Team("SRH", 12, new char[]{'W','L','L','L','L'}));
			list.add(new Team("CSK", 6, new char[]{'L','L','W','L','W'}));
			list.add(new Team("MT", 6, new char[]{'L','W','L','W','W'}));
			int number = 0;
			char ch = 0;
			try {
				System.out.println("Teams that have 2 consecutive losses are: ");
				List<Team> teamList = winLossNumber(list, "LL");
				teamList.stream().forEach(System.out::println);
				
				System.out.println("Enter the number of consecutives");
				number = sc.nextInt();
				if(number < 0 || number > 5) {
					throw new InputMismatchException("You have typed incorrect number");
				}
				System.out.println("Enter 'W' for Win or 'L' for Loss: ");
				ch = sc.next().charAt(0);
				if(ch != 'W' && ch != 'L') {
					throw new InputMismatchException("You have typed incorrect option: ("
							+ "Please enter W or L)");
				}
				String pattern = "";
				while(number > 0) {
					pattern += ch ;   //creating pattern to be found out
					number--;
				}
				System.out.println("Collected teams are: ");
				int sum = 0;
				double avg = 0.0;
				List<Team> collected = winLossNumber(list,pattern);
				for(Team t: collected){
				    System.out.println(t);
				    sum+=t.getPoint();
				}
				try {
					avg = sum/collected.size();
					System.out.println("Avg points of collected teams: "+avg);
				} catch (ArithmeticException e) {
					System.out.println("No team found !");
					e.printStackTrace();
				}
			}catch (InputMismatchException e) {
				e.printStackTrace();
			}
			finally {
				System.out.println("End of the program !");
			}
			
    	}
    }
    public static List<Team> winLossNumber(List<Team> list, String pattern){
        return list.stream()
        		.filter(n->String.valueOf(n.getResult())
        		.contains(pattern))
        		.collect(Collectors.toList());
    }
}
