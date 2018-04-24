package controller;

import exceptions.InvalidIdException;
import exceptions.InvalidTypeException;
import model.Member;
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
        repo.addMember(new Member("a", 1));
        ctrl.addEntry("income", 1, 1);
        assertTrue(true);
    }

    @Test
    public void addEntry2() throws Exception {
        repo.addMember(new Member("a", 1));
        try {
            ctrl.addEntry("cost", 1, -1);
            assertTrue(false);
        }
        catch(InvalidIdException e){
            assertTrue(true);
        }
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

    @Test
    public void addEntry4() throws Exception {
        try {
            ctrl.addEntry("cost", 100, 1);
            assertTrue(false);
        }
        catch(InvalidIdException e){
            assertTrue(true);
        }
    }

}