package org.gtk.glib;

import static org.testng.Assert.*;

import org.testng.annotations.Test;

/**
 * @author Benjamin P. Jung
 */
@Test
public class VersionTest {

    @Test
    public void testVersionAvailability() {
        final Version glibVersion = Version.get();
        assertNotNull(glibVersion);
    }

}
