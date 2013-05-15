package com.undeadstudio.returners.persistence;

import com.swarmconnect.SwarmLeaderboard;

public class SwarmHandler {

	private static boolean scoreSubmitted = false;

	public static void submitHighScore(float score) {
		if(!isScoreSubmitted())
		SwarmLeaderboard.submitScore(9145, score);

	}

	public static void setScoreSubmitted(boolean isSubmitted) {
		scoreSubmitted = isSubmitted;
	}

	public static boolean isScoreSubmitted() {
		return scoreSubmitted;
	}

}
