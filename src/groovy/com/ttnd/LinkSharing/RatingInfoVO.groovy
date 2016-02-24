package com.ttnd.LinkSharing

/**
 * Created by sagar on 2/24/16.
 */
class RatingInfoVO {

        Integer totalVotes, averageScore, totalScore
        String toString(){
            "Total Votes:${totalVotes} ,TotalScore: ${totalScore} ,AverageScore: ${averageScore}"
        }


}
