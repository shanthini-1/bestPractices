package com.chainsys.bestPractices.abstractDemo;

public class TestScoreBoard {

	public static void main(String[] args) {
		
		
		ScoreBoard obj=  ScoreBoard.createObject();
		System.out.println(obj.TargetScore);
		obj.TargetScore=186;
		System.out.println((obj.TargetScore));

	}

}
