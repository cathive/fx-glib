package com.cathive.fx.glib;

import org.gtk.glib.GLib;
import org.gtk.glib.Version;

/**
 * @author Benjamin P. Jung
 */
public class GLibDebugger {

    public static void main(String... args) {
        System.out.println("Your GLib version: " + Version.get().toString());

        System.out.print("Checking compatibility with version 1.0.0... ");
        System.out.println(Version.check(1, 0, 0));

        System.out.print("Checking compatibility with version 2.0.0... ");
        System.out.println(Version.check(2, 0, 0));

        System.out.print("Checking compatibility with version 2.4.0... ");
        System.out.println(Version.check(2, 30, 0));

    }
}
