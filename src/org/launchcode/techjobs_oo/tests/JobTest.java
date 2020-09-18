package org.launchcode.techjobs_oo.tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {

    private Job jobOne;
    private Job jobTwo;
    private Job fullConstructor;
    private Job identicalJobOne;
    private Job identicalJobTwo;

    @Before
    public void createJobs() {
        jobOne = new Job();
        jobTwo = new Job();
        fullConstructor = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        identicalJobOne = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        identicalJobTwo = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }

    @Test
    public void testIdValues() {
        assertEquals(jobOne.getId(), jobTwo.getId(), 1);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertTrue(fullConstructor instanceof Job);
        assertEquals("Product tester", fullConstructor.getName());
        assertTrue(fullConstructor.getEmployer() instanceof Employer);
        assertTrue(fullConstructor.getLocation() instanceof Location);
        assertTrue(fullConstructor.getPositionType() instanceof PositionType);
        assertTrue(fullConstructor.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality() {
        assertFalse(identicalJobOne.getId() == identicalJobTwo.getId());
    }
}
