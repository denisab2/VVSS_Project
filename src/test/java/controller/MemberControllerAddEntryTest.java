package controller;

import exceptions.InvalidTypeException;
import org.junit.Test;
import repository.MemberRepository;

import static org.junit.Assert.*;

/**
 * Created by Deni on 04/04/2018.
 */
public class MemberControllerAddEntryTest {
    private MemberRepository repo = new MemberRepository();

    private MemberController ctrl = new MemberController(repo);

    @Test
    public void addEntry1() throws Exception {
        ctrl.addEntry("income", 1, 1);
        assertTrue(true);
    }

    @Test
    public void addEntry2() throws Exception {
        ctrl.addEntry("cost", 1, 1);
        assertTrue(true);
    }

    @Test
    public void addEntry3() throws Exception {
        try {
            ctrl.addEntry("a", 1, 1);
            assertTrue(false);
        }
        catch(InvalidTypeException e){
            assertTrue(true);
        }
    }



}