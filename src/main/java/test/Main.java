package test;

import jnr.ffi.LibraryLoader;
import jnr.ffi.Platform;

public class Main {
    static final jnr.ffi.Platform NATIVE_PLATFORM = Platform.getNativePlatform();
    static final String STANDARD_C_LIBRARY_NAME = NATIVE_PLATFORM.getStandardCLibraryName();

    public static void main(String[] args) {
        LibraryLoader<JNRInterface> loader = LibraryLoader.create(JNRInterface.class);
        loader.library(STANDARD_C_LIBRARY_NAME);
        JNRInterface jnr = loader.load();
        System.out.println(jnr.gettid());
    }

    public interface JNRInterface {
        int gettid();
    }
}

