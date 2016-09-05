package com.example;

import java.util.Random;

public class JokeMaker {
    public String getAJoke() {
        String jokes[] = {"Why did the chicken cross the road?\n\nTo get to the other side",
                "The only time incorrectly isn’t spelled incorrectly is when it’s spelled incorrectly",
                "I used to think the brain was the most important organ. Then I thought, look what’s telling me that",
                "Today a man knocked on my door and asked for a small donation towards the local swimming pool. I gave him a glass of water"};
        Random random = new Random();
        int r = random.nextInt(jokes.length);
        return jokes[r];
    }
}
