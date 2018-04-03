package controller;

import org.junit.Before;
import org.junit.Test;
import repository.MemberRepository;

import static org.junit.Assert.*;

/**
 * Created by Deni on 23/03/2018.
 */
public class MemberControllerTest {

    MemberRepository repo = new MemberRepository();

    MemberController ctrl = new MemberController(repo);

    @Test
    public void addMember1() throws Exception {

        try {
            int id = 1;
            String name = "ana";
            ctrl.addMember(name, id);
            assertTrue(true);
        } catch (Exception e) {
            assertTrue(false);
        }
    }
    @Test
    public void addMember2 () throws Exception {

        try {

                String name = "ana";
                ctrl.addMember(name, -1);
                assertTrue(false);
            } catch (NumberFormatException e) {
                assertTrue(true);
            }
        }


}