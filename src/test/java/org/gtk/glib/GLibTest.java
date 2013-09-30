package org.gtk.glib;

import static org.testng.Assert.*;

import org.bridj.Pointer;
import org.testng.annotations.Test;

/**
 * @author Benjamin P. Jung
 */
@Test
public class GLibTest {

    @Test
    public void testVariants() {

        final boolean value = true;

        final Pointer<GLib.GVariant> variant = GLib.variantNewBoolean(value);
        assertEquals(GLib.variantGetBoolean(variant), value);

    }
}
