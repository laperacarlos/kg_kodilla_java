package com.kodilla.testing.statistics;

public class CalculateStatistics {
    private Statistics statistics;
    private double usersNumber;
    private double postsNumber;
    private double commentsNumber;
    private double postPerUser;
    private double commentPerUser;
    private double commentsPerPost;


    public CalculateStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    public void calculateAdvStatistics(Statistics statistics) {
        usersNumber = statistics.usersNames().size();
        postsNumber = statistics.postCount();
        commentsNumber = statistics.commentsCount();

        if (usersNumber == 0) {
            postPerUser = 0;
        } else {
            postPerUser = postsNumber / usersNumber;
        }

        if (usersNumber == 0) {
            commentPerUser = 0;
        } else {
            commentPerUser = commentsNumber / usersNumber;
        }

        if (postsNumber == 0) {
            commentsPerPost = 0;
        } else {
            commentsPerPost = commentsNumber / postsNumber;
        }
    }

    public void showStatistics(){

        System.out.println("Forum statistics \nNumber of users: " + usersNumber);
        System.out.println("Number of posts: " + postsNumber);
        System.out.println("Number of comments: " + commentsNumber);
        System.out.println("Number of posts per user: " + postPerUser);
        System.out.println("Number of comments per user: " + commentPerUser);
        System.out.println("Number of comments per post: " + commentsPerPost);
    }

   public double getPostPerUser() {
        return postPerUser;
    }

    public double getCommentPerUser() {
        return commentPerUser;
    }

    public double getCommentsPerPost() {
        return commentsPerPost;
    }
}
