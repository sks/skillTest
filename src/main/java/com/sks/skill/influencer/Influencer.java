package com.sks.skill.influencer;

import java.util.HashSet;
import java.util.Set;

public class Influencer {

	private static final int totalUsers	= 100;

	private static Boolean[][] followingMatrix	= new Boolean[totalUsers][totalUsers];

	private static final int influencerAnswer	=	 99;


	//Creating the 2D-array
	static{
		for(int user = 0; user< totalUsers ; user++){
			for(int influencer = 0; influencer< totalUsers ; influencer++){
				//influencerAnswer is a a influencer , so he/she does not follow anyone
				if(user==influencerAnswer){
					followingMatrix[user][influencer]=  false;
					continue;
				}
				if(user==influencer){
					followingMatrix[user][user]=false;
					continue;
				}
				//we need an answer so, we set that the user is following influencer 
				if(influencer==influencerAnswer){
					followingMatrix[user][influencer]=  true;
					continue;
				}
				//Create the flag using random 
				followingMatrix[user][influencer]=  Math.random() < 0.5;
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args){
		System.out.println(getInfluencer(followingMatrix));
	}

	private static int getInfluencer(Boolean[][] followingMatrix2) {
		//create the namespace
		boolean isPossibleInfluencer	;
		//cache that store the candidates that are not a influencer , so that we dont check them again.
		Set<Integer> nonInfluencer	= new HashSet<Integer>();
		for(int influencer = 0; influencer< totalUsers ; influencer++){
			if(nonInfluencer.contains(influencer)){
				System.out.println("We already know that the user "+influencer+" is not a influencer");
				continue;
			}
			isPossibleInfluencer	= true;
			//Lets hope that this user is a influencer

			for(int followedBy = 0; followedBy< totalUsers ; followedBy++){
				//System.out.println(influencer+"  "+followedBy+" "+followingMatrix[influencer][followedBy]);
				if(followedBy==influencer){
					//the same user, check the next user
					continue;
				}
				
				if(	followingMatrix[influencer][followedBy] || //He should be following himself only.
					! followingMatrix[followedBy][influencer]//The rest of the users should be following him
						){
					//the user is following influencer. so not a influencer or the user is not followed by followedBy
					isPossibleInfluencer	= false;
					break;
				}else{
					//this means that the user followedBy is following influencer, making followedBy not a influencer
					nonInfluencer.add(followedBy);
				}
			}
			if(isPossibleInfluencer){
				//System.out.println(influencer+" is an influencer");
				return influencer;
			}
			//This is Follower.
		}
		return -1;
	}


}
