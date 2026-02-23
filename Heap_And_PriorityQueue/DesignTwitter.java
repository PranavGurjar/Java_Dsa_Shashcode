package Tree_Data_Structure.Heap_And_PriorityQueue;

import java.util.*;

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */

public class DesignTwitter {
    public static void main(String[] args) {

        Twitter twitter = new Twitter();

        List<Object> res = new ArrayList<>();


        twitter.postTweet(1, 5);

        res.add(twitter.getNewsFeed(1));

        twitter.follow(1, 2);
//        twitter.follow(3, 3);

        twitter.postTweet(2, 6);

        res.add(twitter.getNewsFeed(1));

        twitter.unfollow(1, 2);
//        twitter.unfollow(3, 3);

        res.add(twitter.getNewsFeed(1));

        System.out.println(res);
    }

    static class Tweet implements Comparable<Tweet>{
        int time;
        int tweetId;

        public Tweet(int time, int tweetId) {
            this.time = time;
            this.tweetId = tweetId;
        }

        @Override
        public int compareTo(Tweet that) {
            return that.time - this.time;       //dec
        }
    }

    static class User{
        int userId;
        HashSet<Integer> followers;
        List<Tweet> tweets;

        public User(int userId) {
            this.userId = userId;
            this.followers = new HashSet<>();
            followers.add(userId);      //add self also as followers
            this.tweets = new LinkedList<>();
        }
        public void addTweet(Tweet t){
            tweets.add(0, t);       //insertion at the head
        }

        public void addFollower(int followeeId){
            followers.add(followeeId);
        }

        public void removeFollower(int followeeId){
            followers.remove(followeeId);
        }
    }

    static class Twitter {

        HashMap<Integer, User> userMap;
        int timeCounter;

        public Twitter() {
            userMap = new HashMap<>();
            timeCounter = 0;
        }

        public void postTweet(int userId, int tweetId) {
            timeCounter++;
            //const
            if (!userMap.containsKey(userId)){
                userMap.put(userId, new User(userId));
            }
            //const
            User user = userMap.get(userId);
            user.addTweet(new Tweet(timeCounter, tweetId));
        }

        public List<Integer> getNewsFeed(int userId) {
            //const
            if (!userMap.containsKey(userId)){
                return new ArrayList<>();
            }
            PriorityQueue<Tweet> pq = new PriorityQueue<>();
            //add self tweets + followers tweets
            User user = userMap.get(userId);
            //N*TlogT   //N*10log10
            for (int followerId : user.followers){      //N
                int count = 0;
                for (Tweet tweet : userMap.get(followerId).tweets){     //T
                    pq.offer(tweet);        //logT
                    count++;
                    if (count > 10){
                        break;
                    }
                }
            }
            //10log10
//            int count = 0;
//            for (Tweet tweet : user.tweets){
//                pq.offer(tweet);
//                count++;
//                if (count > 10){
//                    break;
//                }
//            }
            //10log10
            List<Integer> res = new ArrayList<>();
            int index = 0;
            while (!pq.isEmpty() && index < 10){
                Tweet tweet = pq.poll();
                res.add(tweet.tweetId);
                index++;
            }
            return res;
        }

        public void follow(int followerId, int followeeId) {
            //const
            if (!userMap.containsKey(followerId)){
                userMap.put(followerId, new User(followerId));
            }
            if (!userMap.containsKey(followeeId)){
                userMap.put(followeeId, new User(followeeId));
            }
            // cannot unfollow yourself (LeetCode rule)
            if (followerId == followeeId) {
                return;
            }
            User user = userMap.get(followerId);
            user.addFollower(followeeId);
        }

        public void unfollow(int followerId, int followeeId) {
            //const
            if (!userMap.containsKey(followerId) && !userMap.containsKey(followeeId)){
                return;
            }
            // cannot unfollow yourself (LeetCode rule)
            if (followerId == followeeId) {
                return;
            }
            User user = userMap.get(followerId);
            user.removeFollower(followeeId);
        }
    }
}

