package org.gtk.glib;

import org.bridj.Pointer;

import java.beans.ConstructorProperties;
import java.util.Objects;

/**
 * @author Benjamin P. Jung
 */
public final class Version implements Comparable<Version> {

    public static Version get() {
        return new Version(GLib.majorVersion(), GLib.minorVersion(), GLib.microVersion());
    }

    public static boolean check(final int major, final int minor, final int micro) {
        final Pointer<Byte> _result = GLib.checkVersion(major, minor, micro);
        return _result == Pointer.NULL;
    }

    private final int major;
    private final int minor;
    private final int micro;

    @ConstructorProperties({"major", "micro", "minor"})
    private Version(final int major, final int minor, final int micro) {
        super();
        this.major = major;
        this.minor = minor;
        this.micro = micro;
    }

    public int getMajor() {
        return this.major;
    }

    public int getMinor() {
        return this.minor;
    }

    public int getMicro() {
        return this.micro;
    }

    @Override
    public int compareTo(Version that) {
        final int maj = this.getMajor() - that.getMajor();
        if (maj != 0) {
            return maj;
        }
        final int min = this.getMinor() - that.getMinor();
        if (min != 0) {
            return min;
        }
        return this.getMicro() - that.getMicro();
    }

    @Override
    public String toString() {
        return String.format("%d.%d.%d", this.getMajor(), this.getMinor(), this.getMicro());
    }

    @Override
    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.getMajor()),
                            Integer.valueOf(this.getMinor()),
                            Integer.valueOf(this.getMicro()));
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this) { return true; }
        if (o == null || !(o instanceof Version)) { return false; }
        final Version that = (Version) o;
        return Objects.equals(Integer.valueOf(this.getMajor()), Integer.valueOf(that.getMajor()))
            && Objects.equals(Integer.valueOf(this.getMinor()), Integer.valueOf(that.getMinor()))
            && Objects.equals(Integer.valueOf(this.getMicro()), Integer.valueOf(that.getMicro()));
    }

}
