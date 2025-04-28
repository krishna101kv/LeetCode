import java.util.*;

class Twitter {
    private static int timeStamp = 0;
    private Map<Integer, Set<Integer>> followMap;
    private Map<Integer, List<int[]>> tweetMap;

    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId, new ArrayList<>());
        tweetMap.get(userId).add(new int[]{timeStamp++, tweetId});
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        followMap.putIfAbsent(userId, new HashSet<>());
        followMap.get(userId).add(userId); // Ensure user follows himself

        for (int followeeId : followMap.get(userId)) {
            List<int[]> tweets = tweetMap.get(followeeId);
            if (tweets != null) {
                for (int i = Math.max(0, tweets.size() - 10); i < tweets.size(); i++) {
                    maxHeap.offer(tweets.get(i));
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        int n = 0;
        while (!maxHeap.isEmpty() && n < 10) {
            res.add(maxHeap.poll()[1]);
            n++;
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId) && followerId != followeeId) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}


/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */