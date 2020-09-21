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
    private Job blankLinesCheck;
    private Job labelForEachField;
    private Job emptyFields;
    private Job idOnlyField;

    @Before
    public void createJobs() {
        jobOne = new Job();
        jobTwo = new Job();
        fullConstructor = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        identicalJobOne = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        identicalJobTwo = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        blankLinesCheck = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        labelForEachField = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        emptyFields = new Job("Product tester", new Employer(), new Location(), new PositionType(), new CoreCompetency());
        idOnlyField = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
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

    @Test
    public void testStringForBlankLines() {
        assertEquals('\n', blankLinesCheck.toString().charAt(0));
        assertEquals('\n', blankLinesCheck.toString().charAt(blankLinesCheck.toString().length() - 1));
    }

    @Test
    public void testLabelForEachField() {
        String testString = "\nID: " + labelForEachField.getId() +
                "\nName: Product tester" +
                "\nEmployer: ACME" +
                "\nLocation: Desert" +
                "\nPosition Type: Quality control" +
                "\nCore Competency: Persistence" +
                "\n";
        assertEquals(testString, labelForEachField.toString());
    }

    @Test
    public void testForEmptyField() {
        assertTrue(emptyFields.toString().contains("Data not available"));
    }

    @Test
    public void testForOnlyIdField() {
        String testString = "OOPS! This job does not seem to exist.";
        assertEquals(testString, idOnlyField.toString());
    }
}
