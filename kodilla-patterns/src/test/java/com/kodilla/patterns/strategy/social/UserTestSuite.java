package com.kodilla.patterns.strategy.social;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTestSuite {

    @Test
    void testDefaultSharingSettings() {
        //Given
        User twitterUser = new YGeneration("Y Generation User");
        User facebookUser = new Millenials("Millenials User");
        User snapchatUser = new ZGeneration("Z Generation User");

        //When
        String twitterPost = twitterUser.sharePost();
        System.out.println(twitterUser.getName() + " has chosen media: " + twitterPost);
        String facebookPost = facebookUser.sharePost();
        System.out.println(facebookUser.getName() + " has chosen media: " + facebookPost);
        String snapchatPost = snapchatUser.sharePost();
        System.out.println(snapchatUser.getName() + " has chosen media: " + snapchatPost);

        //Then
        assertEquals("Twitter", twitterPost);
        assertEquals("Facebook", facebookPost);
        assertEquals("Snapchat", snapchatPost);
    }

    @Test
    void testIndividualSharingStrategy() {
        //Given
        User twitterUser = new YGeneration("Y Generation User");

        //When
        String twitterPost = twitterUser.sharePost();
        System.out.println(twitterUser.getName() + " has chosen media: " + twitterPost);
        twitterUser.setPublishingMedia(new FacebookPublisher());
        twitterPost = twitterUser.sharePost();
        System.out.println(twitterUser.getName() + " has chosen media: " + twitterPost);

        //Then
        assertEquals("Facebook", twitterPost);

    }
}
