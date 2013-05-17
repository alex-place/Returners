package com.undeadstudio.returners.persistence;

import com.swarmconnect.SwarmAchievement;
import com.swarmconnect.SwarmLeaderboard;

public class SwarmHandler {

	private static boolean scoreSubmitted = false;

	public static void submitHighScore(float score) {
		if (!isScoreSubmitted())
			SwarmLeaderboard.submitScore(9145, score);
	}

	public static void setIsScoreSubmitted(boolean isSubmitted) {
		scoreSubmitted = isSubmitted;

	}

	public static boolean isScoreSubmitted() {
		return scoreSubmitted;
	}

	public static void checkAchievements(float score) {
		if (score >= 1)
			SwarmAchievement.unlock(13851);
	}

}
