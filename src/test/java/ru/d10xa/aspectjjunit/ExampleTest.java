package ru.d10xa.aspectjjunit;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ExampleTest {
    @Test
    public void twoEqualTwo() {
        assertThat(2, equalTo(2));
    }

    @Test
    @Ignore
    public void ignored() {

    }
}
