package com.jojoldu.book.springboot.web;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.mock.env.MockEnvironment;

public class ProfileControllerUnitTest {

    @Test
    public void search_real_profile() {
        String expectedProfile = "real";
        MockEnvironment env = new MockEnvironment();
        env.addActiveProfile(expectedProfile);
        env.addActiveProfile("oauth");
        env.addActiveProfile("real-db");
        ProfileController controller = new ProfileController(env);

        String profile = controller.profile();

        Assertions.assertThat(profile).isEqualTo(expectedProfile);
    }

    @Test
    public void check_real_profile_then_first(){
        String expectedProfile = "oauth";
        MockEnvironment env = new MockEnvironment();
        env.addActiveProfile(expectedProfile);
        env.addActiveProfile("real-db");
        ProfileController controller = new ProfileController(env);

        String profile = controller.profile();

        Assertions.assertThat(profile).isEqualTo(expectedProfile);
    }

    @Test
    public void check_real_profile_then_default(){
        String expectedProfile = "default";
        MockEnvironment env = new MockEnvironment();
        ProfileController controller = new ProfileController(env);

        String profile = controller.profile();

        Assertions.assertThat(profile).isEqualTo(expectedProfile);
    }
}
