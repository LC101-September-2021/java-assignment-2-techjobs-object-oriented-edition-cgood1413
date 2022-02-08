package org.launchcode.techjobs.oo.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import java.io.PipedOutputStream;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

//    Job job1;
//    Job job2;
////    Job job3;
////    Job job4;
//
////    @Before
////    public void testJobTest(){
////        job1 = new Job("Test job", new Employer("TestEmployer"), new Location("St. Louis"), new PositionType("Tester"), new CoreCompetency("Testing"));
////        job2 = new Job("", new Employer("TestEmployer"), new Location(""), new PositionType("Tester"), new CoreCompetency(""));
//////        job3 = new Job();
//////        job4 = new Job();
////    }

    @Test
    public void testSettingJobId(){
        Job job3 = new Job();
        Job job4 = new Job();
        assertFalse(job3.equals(job4));
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(testJob.getName() instanceof String);
        assertEquals(testJob.getName(), "Product tester");

        assertTrue(testJob.getEmployer() instanceof Employer);
        assertEquals(testJob.getEmployer().getValue(), "ACME");

        assertTrue(testJob.getLocation() instanceof Location);
        assertEquals(testJob.getLocation().getValue(), "Desert");

        assertTrue(testJob.getPositionType() instanceof PositionType);
        assertEquals(testJob.getPositionType().getValue(), "Quality control");

        assertTrue(testJob.getCoreCompetency() instanceof CoreCompetency);
        assertEquals(testJob.getCoreCompetency().getValue(), "Persistence");
    }

    @Test
    public void testJobsForEquality(){
        Job job1 = new Job("Test job", new Employer("TestEmployer"), new Location("St. Louis"), new PositionType("Tester"), new CoreCompetency("Testing"));
        Job job2 = new Job("", new Employer("TestEmployer"), new Location(""), new PositionType("Tester"), new CoreCompetency(""));
        assertFalse(job1.equals(job2));

    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job testJob = new Job("", new Employer("TestEmployer"), new Location(""), new PositionType("Tester"), new CoreCompetency(""));
        assertEquals(testJob.toString(), "\nID: 3\n" +
                "Name: Data not available\n" +
                "Employer: TestEmployer\n" +
                "Location: Data not available\n" +
                "Position Type: Tester\n" +
                "Core Competency: Data not available\n");
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job testJob = new Job("Test job", new Employer("TestEmployer"), new Location("St. Louis"), new PositionType("Tester"), new CoreCompetency("Testing"));
//        assertTrue(testJob.toString().startsWith("\n"));
//        assertTrue(testJob.toString().endsWith("\n"));
        String jobString = testJob.toString();
        assertEquals(jobString.charAt(0), '\n');
        assertEquals(jobString.charAt(jobString.length()-1), '\n');
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job testJob = new Job("Test job", new Employer("TestEmployer"), new Location("St. Louis"), new PositionType("Tester"), new CoreCompetency("Testing"));

        assertTrue(testJob.toString().contains("ID: " + testJob.getId()));
        assertTrue(testJob.toString().contains("Name: " + testJob.getName()));
        assertTrue(testJob.toString().contains("Employer: " + testJob.getEmployer().getValue()));
        assertTrue(testJob.toString().contains("Location: " + testJob.getLocation().getValue()));
        assertTrue(testJob.toString().contains("Position Type: " + testJob.getPositionType().getValue()));
        assertTrue(testJob.toString().contains("Core Competency: " + testJob.getCoreCompetency().getValue()));

        assertEquals(testJob.toString(), "\nID: 4\n" +
                "Name: Test job\n" +
                "Employer: TestEmployer\n" +
                "Location: St. Louis\n" +
                "Position Type: Tester\n" +
                "Core Competency: Testing\n");

    }

}
