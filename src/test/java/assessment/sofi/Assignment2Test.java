package assessment.sofi;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class Assignment2Test {

    private Assignment2 assignment2;

    @Before
    public void setUp() {
        assignment2 = new Assignment2();
    }

    @After
    public void tearDown() {
        assignment2 = null;
    }

    @Test
    public void getMoviesForAValidTitle() throws Exception {
        String title = "spiderman";
        Assert.assertEquals(13, assignment2.getMoviesTitles(title).size());
    }

    @Test
    public void getMoviesForInvalidTitle() throws Exception {
        String title = "abcdef";
        Assert.assertEquals(0, assignment2.getMoviesTitles(title).size());
    }

    @Test
    public void callHttpGet() throws Exception {
        String title = "spiderman";
        Assert.assertEquals(2, assignment2.getHttpResponsesList(title).size());
    }
}


