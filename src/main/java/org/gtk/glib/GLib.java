package org.gtk.glib;

import org.bridj.*;
import org.bridj.ann.*;
import org.bridj.ann.Runtime;

import java.io.IOException;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.function.Consumer;

/**
 * @author Benjamin P. Jung
 */
@Library(GLib.LIBRARY_NAME)
@Runtime(CRuntime.class)
final class GLib {

    public static final String LIBRARY_NAME = "glib-2.0";

    private static final BridJRuntime bridj;
    static {
        bridj = BridJ.register(GLib.class);
    }

    @Name("glib_major_version")
    static int majorVersion() {
        try {
            return BridJ.getNativeLibrary(LIBRARY_NAME).getSymbolPointer("glib_major_version").as(int.class).get().intValue();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Name("glib_minor_version")
    static int minorVersion() {
        try {
            return BridJ.getNativeLibrary(LIBRARY_NAME).getSymbolPointer("glib_minor_version").as(int.class).get().intValue();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Name("glib_micro_version")
    static int microVersion() {
        try {
            return BridJ.getNativeLibrary(LIBRARY_NAME).getSymbolPointer("glib_micro_version").as(int.class).get().intValue();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Name("glib_check_version")
    static native Pointer<Byte> checkVersion(int major, int micro, int minor);

    /**
     * GVariant is a variant datatype;
     * it stores a value along with information about the type of that value.
     * The range of possible values is determined by the type.
     * @since GLib 2.24
     */
    @Name("GVariant")
    @Optional
    public static final class GVariant extends StructObject {
        public GVariant() { super(); }
        public GVariant(Pointer<GVariant> peer) { super(peer); }
    }

    /**
     * @since GLib 2.24
     */
    @Name("GVariantType")
    @Optional
    public static final class GVariantType extends StructObject {
        public GVariantType() { super(); }
        public GVariantType(Pointer<GVariantType> peer) { super(peer); }
    }

    /**
     * Decreases the reference count of {@code value}.
     * When its reference count drops to {@code 0}, the memory used by the variant is freed.
     * @since GLib 2.24
     */
    @Name("g_variant_unref")
    @Optional
    static native void gVariantUnref(Pointer<GVariant> value);

    /**
     * Increases the reference count of {@code value}.
     * @since GLib 2.24
     */
    @Name("g_variant_ref")
    @Optional
    static native Pointer<GVariant> gVariantRef(Pointer<GVariant> value);

    /**
     * GVariant uses a floating reference count system.
     * All methods with names starting with {@code gVariantNew_} return floating references.
     * @since GLib 2.24
     */
    @Name("g_variant_ref_sink")
    @Optional
    static native Pointer<GVariant> gVariantRefSink(Pointer<GVariant> value);

    /**
     * Checks whether value has a floating reference count.
     * <p>This function should only ever be used to assert that a given variant is or is not floating,
     * or for debug purposes. To acquire a reference to a variant that might be floating, always use
     * {@link #gVariantRefSink(Pointer)} or {@link #gVariantTakeRef()}.</p>
     * See {@link #gVariantRefSink(Pointer)} for more information about floating reference counts.
     * @param value
     *         a GVariant.
     * @return Whether the given value is floating or not.*
     *
     * @since GLib 2.24
     */
    @Name("g_variant_is_floating")
    @Optional
    static native boolean gVariantIsFloating(Pointer<GVariant> value);

    /**
     * If value is floating, sink it. Otherwise, do nothing.
     * <p>Typically you want to use {@link #gVariantRefSink(Pointer)} in order to automatically do the correct
     * thing with respect to floating or non-floating references, but there is one specific scenario where this
     * function is helpful.</p>
     * <p>The situation where this function is helpful is when creating an API that allows the user to provide a
     * callback function that returns a {@code GVariant}. We certainly want to allow the user the flexibility to
     * return a non-floating reference from this callback (for the case where the value that is being returned already
     * exists).</p>
     * <p>At the same time, the style of the GVariant API makes it likely that for newly-created GVariant instances,
     * the user can be saved some typing if they are allowed to return a GVariant with a floating reference.</p>
     * <p>Using this function on the return value of the user's callback allows the user to do whichever is more
     * convenient for them. The caller will always receive exactly one full reference to the value: either the one that
     * was returned in the first place, or a floating reference that has been converted to a full reference</p>
     * <p>This function has an odd interaction when combined with {@link #gVariantRefSink(org.bridj.Pointer)}  running
     * at the same time in another thread on the same GVariant instance. If {@link #gVariantRefSink(org.bridj.Pointer)}
     * runs first then the result will be that the floating reference is converted to a hard reference. If
     * {@link #gVariantTakeRef(org.bridj.Pointer)} runs first then the result will be that the floating reference is
     * converted to a hard reference and an additional reference on top of that one is added.
     * It is best to avoid this situation.</p>
     * @param value
     *         A GVariant.
     * @return
     *         The same value.
     * @since GLib 2.24
     */
    @Name("g_variant_take_ref")
    @Optional
    static native Pointer<GVariant> gVariantTakeRef(Pointer<GVariant> value);

    /**
     * Determines the type of value.
     * <p>The return value is valid for the lifetime of value and must not be freed.</p>
     * @param value
     *         A GVariant.
     * @return
     *         A GVariantType.
     * @since GLib 2.24
     */
    @Name("g_variant_get_type")
    @Optional
    static native Pointer<GVariantType> gVariantGetType(Pointer<GVariant> value);

    /**
     * Returns the type string of value.
     * <p>Unlike the result of calling {@link gVariantTypePeekString(Pointer), this string is nul-terminated.
     * This string belongs to {@code GVariant} and must not be freed.</p>
     * @param value
     *         A GVariant.
     * @return
     *         The type string for the type of value
     * @since GLib 2.24
     */
    @Name("g_variant_get_type_string")
    @Optional
    static native Pointer<Byte> gVariantGetTypeString(Pointer<GVariant> value);

    /**
     * Checks if a value has a type matching the provided type.
     * @param value
     *         A GVariant instance,
     * @param type
     *         A GVariantType.
     * @return
     *         {@code true} if the type of value matches type, {@code false} otherwise.
     * @since GLib 2.24
     */
    @Name("g_variant_is_of_type")
    @Optional
    static native boolean gVariantIsOfType(Pointer<GVariant> value,
                                           Pointer<GVariantType> type);

    /**
     * Checks if {@code value} is a container.
     * @param value
     *         A {@code GVariant} instance.
     * @return
     *         {@code true} if {@code value} is a container, {@code false} otherwise.
     * @since GLib 2.24
     */
    @Name("g_variant_is_container")
    @Optional
    static native boolean gVariantIsContainer(Pointer<GVariant> value);

    /**
     * Compares one and two.
     * <p>If you only require an equality comparison, {@link gVariantEqual(Pointer, Pointer)} is more general.</p>
     * @param one
     *         A basic-typed GVariant instance.
     * @param two
     *         A GVariant instance of the same type.
     * @return
     *         Negative value if one < two; zero if one = two; positive value if one > two.
     * @since GLib 2.24
     */
    @Name("g_variant_compare")
    @Optional
    static native int gVariantCompare(Pointer<GVariant> one,
                                      Pointer<GVariant> two);

    /**
     * Classifies value according to its top-level type.
     * @param value
     *         A GVariant.
     * @return
     *         The GVariantClass of {@code value}.
     * @since GLib 2.24
     */
    @Name("g_variant_classify")
    @Optional
    static native Pointer<GVariantClass> gVariantClassify(Pointer<GVariant> value);

    /**
     * @since GLib 2.24
     */
    @Name("GVariantClass")
    enum GVariantClass implements IntValuedEnum {

        G_VARIANT_CLASS_BOOLEAN('b'),
        G_VARIANT_CLASS_BYTE('y'),
        G_VARIANT_CLASS_INT16('n'),
        G_VARIANT_CLASS_UINT16('q'),
        G_VARIANT_CLASS_INT32('i'),
        G_VARIANT_CLASS_UINT32('u'),
        G_VARIANT_CLASS_INT64('x'),
        G_VARIANT_CLASS_UINT64('t'),
        G_VARIANT_CLASS_HANDLE('h'),
        G_VARIANT_CLASS_DOUBLE('d'),
        G_VARIANT_CLASS_STRING('s'),
        G_VARIANT_CLASS_OBJECT_PATH('o'),
        G_VARIANT_CLASS_SIGNATURE('g'),
        G_VARIANT_CLASS_VARIANT('v'),
        G_VARIANT_CLASS_MAYBE('m'),
        G_VARIANT_CLASS_ARRAY('a'),
        G_VARIANT_CLASS_TUPLE('('),
        G_VARIANT_CLASS_DICT_ENTRY('{');

        private final int value;
        private GVariantClass(final int value) { this.value = value; }

        @Override
        public long value() {
            return this.value;
        }

        @Override
        public Iterator iterator() {
            return EnumSet.of(this).iterator();
        }

    }
}
