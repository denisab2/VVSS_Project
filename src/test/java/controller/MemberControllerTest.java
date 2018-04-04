package controller;

import exceptions.InvalidIdException;
import exceptions.InvalidNameException;
import model.Member;
import org.junit.Before;
import org.junit.Test;
import repository.MemberRepository;

import static org.junit.Assert.*;

/**
 * Created by Deni on 23/03/2018.
 */
public class MemberControllerTest {

    private MemberRepository repo = new MemberRepository();

    private MemberController ctrl = new MemberController(repo);


    @Test
    public void addMember1() throws Exception {

        try {
            int id = 1;
            String name = "a";
            int initialLength = repo.getMembers().size();
            ctrl.addMember(name, id);
            assertTrue(true);
            assertEquals(initialLength+1,repo.getMembers().size());
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    @Test
    public void addMember2 () throws Exception {

        try {

            int id = 1;
                String name = "#";
                ctrl.addMember(name, id);
                assertTrue(false);
            } catch (InvalidNameException e) {
                assertTrue(true);
            }
    }

    @Test
    public void addMember3 () throws Exception {

        try {

            int id = 1;
            String name = "";
            ctrl.addMember(name, id);
            assertTrue(false);
        } catch (InvalidNameException e) {
            assertTrue(true);
        }
    }

    @Test
    public void addMember4 () throws Exception {

        try {

            int id = -1;
            String name = "a";
            ctrl.addMember(name, id);
            assertTrue(false);
        } catch (InvalidIdException e) {
            assertTrue(true);
        }
    }

    @Test
    public void addMember5 () throws Exception {

        try {


            String name = "a";
            ctrl.addMember(name, Integer.MAX_VALUE+1);
            assertTrue(false);
        } catch (InvalidIdException e) {
            assertTrue(true);
        }
    }

    @Test
    public void addMember6 () throws Exception {

        try {

            int id = 1;
            String name = "a#a";
            ctrl.addMember(name, id);
            assertTrue(false);
        } catch (InvalidNameException e) {
            assertTrue(true);
        }
    }


    @Test
    public void addMember7() throws Exception {

        try {
            int id = 0;
            String name = "a";
            int initialLength = repo.getMembers().size();
            ctrl.addMember(name, id);
            assertTrue(true);
            assertEquals(initialLength+1,repo.getMembers().size());
        } catch (Exception e) {
            assertTrue(false);
        }
    }
    @Test
    public void addMember8 () throws Exception {

        try {

            int id = Integer.MAX_VALUE;
            String name = "a";
            int initialLength = repo.getMembers().size();
            ctrl.addMember(name, id);
            assertTrue(true);
            assertEquals(initialLength+1,repo.getMembers().size());
        } catch (Exception e) {
            assertTrue(false);
        }
    }

    @Test
    public void addMember9() throws Exception {

        try {

            int id = Integer.MAX_VALUE - 1;
            String name = "a";
            int initialLength = repo.getMembers().size();
            ctrl.addMember(name, id);
            assertTrue(true);
            assertEquals(initialLength+1,repo.getMembers().size());
        } catch (Exception e) {
            assertTrue(false);
        }
    }
}