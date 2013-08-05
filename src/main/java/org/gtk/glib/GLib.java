package org.gtk.glib;

import org.bridj.*;
import org.bridj.ann.*;
import org.bridj.ann.Runtime;

import java.io.IOException;
import java.lang.annotation.*;
import java.util.EnumSet;
import java.util.Iterator;

/**
 * Java bindings for GLib.
 * @author Benjamin P. Jung
 */
@Library(GLib.LIBRARY_NAME)
@Runtime(CRuntime.class)
public final class GLib {

    public static final String LIBRARY_NAME = "glib-2.0";

    private static final BridJRuntime bridj;
    static {
        bridj = BridJ.register(GLib.class);
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ ElementType.FIELD, ElementType.LOCAL_VARIABLE, ElementType.PARAMETER, ElementType.METHOD })
    public @interface gboolean {}

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ ElementType.FIELD, ElementType.LOCAL_VARIABLE, ElementType.PARAMETER, ElementType.METHOD })
    public @interface gchar {}

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ ElementType.FIELD, ElementType.LOCAL_VARIABLE, ElementType.PARAMETER, ElementType.METHOD })
    public @interface guchar {}

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ ElementType.FIELD, ElementType.LOCAL_VARIABLE, ElementType.PARAMETER, ElementType.METHOD })
    public @interface gint {}

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ ElementType.FIELD, ElementType.LOCAL_VARIABLE, ElementType.PARAMETER, ElementType.METHOD })
    public @interface guint {}

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ ElementType.FIELD, ElementType.LOCAL_VARIABLE, ElementType.PARAMETER, ElementType.METHOD })
    public @interface gshort {}

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ ElementType.FIELD, ElementType.LOCAL_VARIABLE, ElementType.PARAMETER, ElementType.METHOD })
    public @interface gushort {}

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ ElementType.FIELD, ElementType.LOCAL_VARIABLE, ElementType.PARAMETER, ElementType.METHOD })
    public @interface glong {}

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ ElementType.FIELD, ElementType.LOCAL_VARIABLE, ElementType.PARAMETER, ElementType.METHOD })
    public @interface gulong {}

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ ElementType.FIELD, ElementType.LOCAL_VARIABLE, ElementType.PARAMETER, ElementType.METHOD })
    public @interface gint8 {}

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ ElementType.FIELD, ElementType.LOCAL_VARIABLE, ElementType.PARAMETER, ElementType.METHOD })
    public @interface guint8 {}

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ ElementType.FIELD, ElementType.LOCAL_VARIABLE, ElementType.PARAMETER, ElementType.METHOD })
    public @interface gint16 {}

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ ElementType.FIELD, ElementType.LOCAL_VARIABLE, ElementType.PARAMETER, ElementType.METHOD })
    public @interface guint16 {}

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ ElementType.FIELD, ElementType.LOCAL_VARIABLE, ElementType.PARAMETER, ElementType.METHOD })
    public @interface gint32 {}

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ ElementType.FIELD, ElementType.LOCAL_VARIABLE, ElementType.PARAMETER, ElementType.METHOD, ElementType.ANNOTATION_TYPE })
    public @interface guint32 {}

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ ElementType.FIELD, ElementType.LOCAL_VARIABLE, ElementType.PARAMETER, ElementType.METHOD })
    public @interface gint64 {}

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ ElementType.FIELD, ElementType.LOCAL_VARIABLE, ElementType.PARAMETER, ElementType.METHOD })
    public @interface guint64 {}

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ ElementType.FIELD, ElementType.LOCAL_VARIABLE, ElementType.PARAMETER, ElementType.METHOD })
    public @interface gfloat {}

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ ElementType.FIELD, ElementType.LOCAL_VARIABLE, ElementType.PARAMETER, ElementType.METHOD })
    public @interface gdouble {}

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ ElementType.FIELD, ElementType.LOCAL_VARIABLE, ElementType.PARAMETER, ElementType.METHOD })
    public @interface gsize {}

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ ElementType.FIELD, ElementType.LOCAL_VARIABLE, ElementType.PARAMETER, ElementType.METHOD })
    public @interface gssize {}

    /**
     * A 2-way association between a string and a unique integer identifier
     */
    @Retention(RetentionPolicy.RUNTIME)
    @Target({ ElementType.FIELD, ElementType.LOCAL_VARIABLE, ElementType.PARAMETER, ElementType.METHOD })
    @guint32
    public @interface  GQuark {}


    @Name("glib_major_version")
    static @guint int majorVersion() {
        try {
            return BridJ.getNativeLibrary(LIBRARY_NAME).getSymbolPointer("glib_major_version").as(int.class).get().intValue();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Name("glib_minor_version")
    static @guint int minorVersion() {
        try {
            return BridJ.getNativeLibrary(LIBRARY_NAME).getSymbolPointer("glib_minor_version").as(int.class).get().intValue();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Name("glib_micro_version")
    static @guint int microVersion() {
        try {
            return BridJ.getNativeLibrary(LIBRARY_NAME).getSymbolPointer("glib_micro_version").as(int.class).get().intValue();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Name("glib_binary_age")
    static @guint int binaryAge() {
        try {
            return BridJ.getNativeLibrary(LIBRARY_NAME).getSymbolPointer("glib_binary_age").as(int.class).get().intValue();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Name("glib_interface_age")
    static @guint int interfaceAge() {
        try {
            return BridJ.getNativeLibrary(LIBRARY_NAME).getSymbolPointer("glib_interface_age").as(int.class).get().intValue();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Name("glib_check_version")
    static native @gchar Pointer<Byte> checkVersion(@guint int major, @guint int micro, @guint int minor);

    @Name("g_quark_from_string")
    public static native @GQuark int quarkFromString(@gchar Pointer<Byte> string);

    @Name("g_quark_from_static_string")
    public static native @GQuark int quarkFromStaticString(@gchar Pointer<Byte> string);

    @Name("g_quark_to_string")
    public static native @gchar Pointer<Byte> quarkToString(@GQuark int quark);

    @Name("g_quark_try_string")
    public static native @GQuark int quarkTryString(@gchar Pointer<Byte> string);

    /**
     * @since GLib 2.10
     */
    @Optional
    @Name("g_intern_string")
    public static native @gchar Pointer<Byte> internString(@gchar Pointer<Byte> string);

    /**
     * @since GLib 2.10
     */
    @Optional
    @Name("g_intern_static_string")
    public static native @gchar Pointer<Byte> internStaticString(@gchar Pointer<Byte> string);

    @Struct(fieldCount = 3)
    @Name("GError")
    public static final class GError extends StructObject {
        public GError() { super(); }
        public GError(Pointer<GError> peer) { super(peer); }
        @Field(0) public @GQuark int domain() { return this.io.getIntField(this, 0); }
        @Field(0) public GError domain(@GQuark int domain) { this.io.setIntField(this, 0, domain); return this; }
        @Field(1) public @gint int code() { return this.io.getIntField(this, 1); }
        @Field(1) public GError code(@gint int code) { this.io.setIntField(this, 1, code); return this; }
        @Field(2) public @gchar Pointer<Byte> message() { return this.io.getPointerField(this, 2); }
        @Field(2) public GError message(@gchar Pointer<Byte> message) { this.io.setPointerField(this, 2, message); return this; }

    }

    /**
     * GVariant is a variant datatype;
     * it stores a value along with information about the type of that value.
     * The range of possible values is determined by the type.
     * @since GLib 2.24
     */
    @Struct
    @Optional
    @Name("GVariant")
    public static final class GVariant extends StructObject {
        public GVariant() { super(); }
        public GVariant(Pointer<GVariant> peer) { super(peer); }
    }

    /**
     * @since GLib 2.24
     */
    @Struct
    @Optional
    @Name("GVariantType")
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
    public static native void variantUnref(Pointer<GVariant> value);

    /**
     * Increases the reference count of {@code value}.
     * @since GLib 2.24
     */
    @Name("g_variant_ref")
    @Optional
    public static native Pointer<GVariant> variantRef(Pointer<GVariant> value);

    /**
     * GVariant uses a floating reference count system.
     * All methods with names starting with {@code gVariantNew_} return floating references.
     * @since GLib 2.24
     */
    @Name("g_variant_ref_sink")
    @Optional
    public static native Pointer<GVariant> variantRefSink(Pointer<GVariant> value);

    /**
     * Checks whether value has a floating reference count.
     * <p>This function should only ever be used to assert that a given variant is or is not floating,
     * or for debug purposes. To acquire a reference to a variant that might be floating, always use
     * {@link #variantRefSink(Pointer)} or {@link #variantTakeRef(Pointer)}.</p>
     * See {@link #variantRefSink(Pointer)} for more information about floating reference counts.
     * @param value
     *         a GVariant.
     * @return Whether the given value is floating or not.*
     *
     * @since GLib 2.24
     */
    @Name("g_variant_is_floating")
    @Optional
    public static native boolean variantIsFloating(Pointer<GVariant> value);

    /**
     * If value is floating, sink it. Otherwise, do nothing.
     * <p>Typically you want to use {@link #variantRefSink(Pointer)} in order to automatically do the correct
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
     * <p>This function has an odd interaction when combined with {@link #variantRefSink(org.bridj.Pointer)}  running
     * at the same time in another thread on the same GVariant instance. If {@link #variantRefSink(org.bridj.Pointer)}
     * runs first then the result will be that the floating reference is converted to a hard reference. If
     * {@link #variantTakeRef(org.bridj.Pointer)} runs first then the result will be that the floating reference is
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
    public static native Pointer<GVariant> variantTakeRef(Pointer<GVariant> value);

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
    public static native Pointer<GVariantType> variantGetType(Pointer<GVariant> value);

    /**
     * Returns the type string of value.
     * <p>Unlike the result of calling {@link #variantTypePeekString(Pointer), this string is nul-terminated.
     * This string belongs to {@code GVariant} and must not be freed.</p>
     * @param value
     *         A GVariant.
     * @return
     *         The type string for the type of value
     * @since GLib 2.24
     */
    @Optional
    @Name("g_variant_get_type_string")
    public static native Pointer<Byte> variantGetTypeString(Pointer<GVariant> value);

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
    public static native boolean variantIsOfType(Pointer<GVariant> value,
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
    public static native @gboolean boolean variantIsContainer(Pointer<GVariant> value);

    /**
     * Compares one and two.
     * <p>If you only require an equality comparison, {@link gVariantEqual(Pointer, Pointer)} is more general.</p>
     * @param one
     *         A basic-typed GVariant instance.
     * @param two
     *         A GVariant instance of the same type.
     * @return
     *         Negative value if one &lt; two; zero if one = two; positive value if one &gt; two.
     * @since GLib 2.24
     */
    @Name("g_variant_compare")
    @Optional
    public static native int variantCompare(Pointer<GVariant> one,
                                            Pointer<GVariant> two);

    /**
     * Classifies value according to its top-level type.
     * @param value
     *         A GVariant.
     * @return
     *         The GVariantClass of {@code value}.
     * @since GLib 2.24
     */
    @Optional
    @Name("g_variant_classify")
    public static native Pointer<GVariantClass> variantClassify(Pointer<GVariant> value);

    /**
     * Deconstructs a GVariant instance.
     * Think of this function as an analogue to {@code scanf()}.
     * The arguments that are expected by this function are entirely determined by {@code formatString}.
     * {@code formatString} also restricts the permissible types of value.
     * It is an error to give a value with an incompatible type.
     * See the section on GVariant Format Strings.
     * Please note that the syntax of the format string is very likely to be extended in the future.</p>
     * <p>format_string determines the C types that are used for unpacking the values and also determines if the values
     * are copied or borrowed, see the section on GVariant Format Strings.</p>
     * @param value
     *         A GVariant instance.
     * @param formatString
     *         A GVariant format string.
     * @param varargs
     *         Arguments, as per {@code formatString}.
     * @since GLib 2.24
     */
    @Optional
    @Name("g_variant_get")
    public static native void variantGet(Pointer<GVariant> value,
                                         @gchar Pointer<Byte> formatString,
                                         Object... varargs);
    /**
     * TODO Documentation
     * @since GLib 2.24
     */
    @Optional
    @Name("g_variant_get_va")
    public static native void variantGetVa(Pointer<GVariant> value,
                                           @gchar Pointer<Byte> formatString,
                                           @gchar Pointer<Pointer<Byte>> endPtr,
                                           Pointer<?> app);

    /**
     * TODO Documentation
     * @since GLib 2.24
     */
    @Optional
    @Name("g_variant_new")
    public static native Pointer<GVariant> variantNew(@gchar Pointer<Byte> formatString,
                                                      Object... varargs);

    /**
     * TODO Documentation
     * @since GLib 2.24
     */
    @Optional
    @Name("g_variant_new_va")
    public static native Pointer<GVariant> variantNewVa(@gchar Pointer<Byte> formatString,
                                                        @gchar Pointer<Pointer<Byte>> endPtr,
                                                        Pointer<?> app);

    /**
     * TODO Documentation
     * @since GLib 2.24
     */
    @Optional
    @Name("g_variant_new_boolean")
    public static native Pointer<GVariant> variantNewBoolean(@gboolean boolean value);

    /**
     * TODO Documentation
     * @since GLib 2.24
     */
    @Optional
    @Name("g_variant_new_byte")
    public static native Pointer<GVariant> variantNewByte(@guchar byte value);

    /**
     * TODO Documentation
     * @since GLib 2.24
     */
    @Optional
    @Name("g_variant_new_int16")
    public static native Pointer<GVariant> variantNewInt16(@gint16 short value);

    /**
     * TODO Documentation
     * @since GLib 2.24
     */
    @Optional
    @Name("g_variant_new_uint16")
    public static native Pointer<GVariant> variantNewUint16(@guint16 short value);

    /**
     * TODO Documentation
     * @since GLib 2.24
     */
    @Optional
    @Name("g_variant_new_int32")
    public static native Pointer<GVariant> variantNewInt32(@gint32 int value);

    /**
     * TODO Documentation
     * @since GLib 2.24
     */
    @Optional
    @Name("g_variant_new_uint32")
    public static native Pointer<GVariant> variantNewUint32(@guint32 int value);

    /**
     * TODO Documentation
     * @since GLib 2.24
     */
    @Optional
    @Name("g_variant_new_int64")
    public static native Pointer<GVariant> variantNewInt64(@gint64 long value);

    /**
     * TODO Documentation
     * @since GLib 2.24
     */
    @Optional
    @Name("g_variant_new_uint64")
    public static native Pointer<GVariant> variantNewUint64(@guint64 long value);

    /**
     * Creates a new handle GVariant instance.
     * <p>By convention, handles are indexes into an array of file descriptors that are sent alongside a D-Bus message.
     * If you're not interacting with D-Bus, you probably don't need them.</p>
     * @param value
     *         A {@code gint32} value.
     * @return
     *         A floating reference to a new handle GVariant instance.
     * @since GLib 2.24
     */
    @Optional
    @Name("g_variant_new_handle")
    public static native Pointer<GVariant> variantNewHandle(@gint32 int value);

    /**
     * TODO Documentation
     * @since GLib 2.24
     */
    @Optional
    @Name("g_variant_new_double")
    public static native Pointer<GVariant> variantNewDouble(@gdouble double value);

    /**
     * TODO Documentation
     * @since GLib 2.24
     */
    @Optional
    @Name("g_variant_new_string")
    public static native Pointer<GVariant> variantNewString(@gchar Pointer<Byte> string);

    /**
     * TODO Documentation
     * @since GLib 2.24
     */
    @Optional
    @Name("g_variant_new_object_path")
    public static native Pointer<GVariant> variantNewObjectPath(@gchar Pointer<Byte> objectPath);

    /**
     * TODO Documentation
     * @since GLib 2.24
     */
    @Optional
    @Name("g_variant_is_object_path")
    public static native @gboolean boolean variantIsObjectPath(@gchar Pointer<Byte> string);

    /**
     * TODO Documentation
     * @since GLib 2.24
     */
    @Optional
    @Name("g_variant_new_signature")
    public static native Pointer<GVariant> variantNewSignature(@gchar Pointer<Byte> signature);

    /**
     * TODO Documentation
     * @since GLib 2.24
     */
    @Optional
    @Name("g_variant_is_signature")
    public static native @gboolean boolean variantIsSignature(@gchar Pointer<Byte> string);

    /**
     * TODO Documentation
     * @since GLib 2.24
     */
    @Optional
    @Name("g_variant_new_strv")
    public static native Pointer<GVariant> variantNewStrv(@gchar Pointer<Pointer<Byte>> strv,
                                                             @gssize long length);

    /**
     * TODO Documentation
     * @since GLib 2.30
     */
    @Optional
    @Name("g_variant_new_objv")
    public static native Pointer<GVariant> variantNewObjv(@gchar Pointer<Pointer<Byte>> strv,
                                                          @gssize long length);

    /**
     * TODO Documentation
     * @since GLib 2.24
     */
    @Optional
    @Name("g_variant_new_bytestring")
    public static native Pointer<GVariant> variantNewBytestring(@gchar Pointer<Byte> string);

    /**
     * TODO Documentation
     * @since GLib 2.24
     */
    @Optional
    @Name("g_variant_new_bytestring_array")
    public static native Pointer<GVariant> variantNewBytestringArray(@gchar Pointer<Pointer<Byte>> strv,
                                                                     @gssize long length);

    /**
     * TODO Documentation
     * @since GLib 2.24
     */
    @Optional
    @Name("g_variant_get_boolean")
    public static native @gboolean boolean variantGetBoolean(Pointer<GVariant> value);

    /**
     * TODO Documentation
     * @since GLib 2.24
     */
    @Optional
    @Name("g_variant_get_byte")
    public static native @guchar byte variantGetByte(Pointer<GVariant> value);

    /**
     * TODO Documentation
     * @since GLib 2.24
     */
    @Optional
    @Name("g_variant_get_int16")
    public static native @gint16 short variantGetInt16(Pointer<GVariant> value);

    /**
     * TODO Documentation
     * @since GLib 2.24
     */
    @Optional
    @Name("g_variant_get_uint16")
    public static native @guint16 short variantGetUint16(Pointer<GVariant> value);

    /**
     * TODO Documentation
     * @since GLib 2.24
     */
    @Optional
    @Name("g_variant_get_int32")
    public static native @gint32 int variantGetInt32(Pointer<GVariant> value);

    /**
     * TODO Documentation
     * @since GLib 2.24
     */
    @Optional
    @Name("g_variant_get_uint32")
    public static native @guint32 int variantGetUint32(Pointer<GVariant> value);

    /**
     * TODO Documentation
     * @since GLib 2.24
     */
    @Optional
    @Name("g_variant_get_int64")
    public static native @gint64 long variantGetInt64(Pointer<GVariant> value);

    /**
     * TODO Documentation
     * @since GLib 2.24
     */
    @Optional
    @Name("g_variant_get_uint64")
    public static native @guint64 long variantGetUint64(Pointer<GVariant> value);

    /**
     * TODO Documentation
     * @since GLib 2.24
     */
    @Optional
    @Name("g_variant_get_handle")
    public static native @gint32 int variantGetHandle(Pointer<GVariant> value);

    /**
     * TODO Documentation
     * @since GLib 2.24
     */
    @Optional
    @Name("g_variant_get_string")
    public static native @gchar Pointer<Byte> variantGetString(Pointer<GVariant> value);

    /**
     * TODO Documentation
     * @since GLib 2.24
     */
    @Optional
    @Name("g_variant_dup_string")
    public static native @gchar Pointer<Byte> variantDupString(Pointer<GVariant> value);

    /**
     * Returns the length of the type string corresponding to the given type.
     * <p>This function must be used to determine the valid extent of the memory region returned by
     * {@link #variantTypePeekString(org.bridj.Pointer)} ()}.</p>
     * @param type
     *         A GVariantType.
     * @return
     *         The length of the corresponding type string.
     * @since GLib 2.24
     */
    @Optional
    @Name("g_variant_type_get_string_length")
    public static native @gsize int variantTypeGetStringLength(Pointer<GVariantType> type);

    /**
     * Returns the type string corresponding to the given type.
     * <p>The result is not nul-terminated; in order to determine its length you must call
     * {@link #variantTypeGetStringLength(org.bridj.Pointer)}.</p>
     * <p>To get a nul-terminated string, see {@link #variantTypeDupString(org.bridj.Pointer)}.</p>
     * @since GLib 2.24
     */
    @Optional
    @Name("g_variant_type_peek_string")
    public static native @gchar Pointer<Byte> variantTypePeekString(Pointer<GVariantType> type);

    /**
     * Returns a newly-allocated copy of the type string corresponding to type.
     * <p>The returned string is nul-terminated. It is appropriate to call {@link #free()} on the return value.</p>
     * @param type
     *         A GVariantType.
     * @return
     *         The corresponding type string.
     * @since GLibs 2.24
     */
    @Optional
    @Name("g_variant_type_dup_string")
    public static native @gchar Pointer<Byte> variantTypeDupString(Pointer<GVariantType> type);

    /**
     * @since GLib 2.24
     */
    @Struct
    @Optional
    @Name("GVariantClass")
    public static enum GVariantClass implements IntValuedEnum {

        @Name("G_VARIANT_CLASS_BOOLEAN")
        BOOLEAN('b'),

        @Name("G_VARIANT_CLASS_BYTE")
        BYTE('y'),

        @Name("G_VARIANT_CLASS_INT16")
        INT16('n'),

        @Name("G_VARIANT_CLASS_UINT16")
        UINT16('q'),

        @Name("G_VARIANT_CLASS_INT32")
        INT32('i'),

        @Name("G_VARIANT_CLASS_UINT32")
        UINT32('u'),

        @Name("G_VARIANT_CLASS_INT64")
        INT64('x'),

        @Name("G_VARIANT_CLASS_UINT64")
        UINT64('t'),

        @Name("G_VARIANT_CLASS_HANDLE")
        HANDLE('h'),

        @Name("G_VARIANT_CLASS_DOUBLE")
        DOUBLE('d'),

        @Name("G_VARIANT_CLASS_STRING")
        STRING('s'),

        @Name("G_VARIANT_CLASS_OBJECT_PATH")
        OBJECT_PATH('o'),

        @Name("G_VARIANT_CLASS_SIGNATURE")
        SIGNATURE('g'),

        @Name("G_VARIANT_CLASS_VARIANT")
        VARIANT('v'),

        @Name("G_VARIANT_CLASS_MAYBE")
        MAYBE('m'),

        @Name("G_VARIANT_CLASS_ARRAY")
        ARRAY('a'),

        @Name("G_VARIANT_CLASS_TUPLE")
        TUPLE('('),

        @Name("G_VARIANT_CLASS_DICT_ENTRY")
        DICT_ENTRY('{');

        private final long value;
        private GVariantClass(final long value) { this.value = value; }

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
